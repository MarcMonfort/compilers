//////////////////////////////////////////////////////////////////////
//
//    TypeCheckVisitor - Walk the parser tree to do the semantic
//                       typecheck for the Asl programming language
//
//    Copyright (C) 2019  Universitat Politecnica de Catalunya
//
//    This library is free software; you can redistribute it and/or
//    modify it under the terms of the GNU General Public License
//    as published by the Free Software Foundation; either version 3
//    of the License, or (at your option) any later version.
//
//    This library is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//    Affero General Public License for more details.
//
//    You should have received a copy of the GNU Affero General Public
//    License along with this library; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
//    contact: José Miguel Rivero (rivero@cs.upc.edu)
//             Computer Science Department
//             Universitat Politecnica de Catalunya
//             despatx Omega.110 - Campus Nord UPC
//             08034 Barcelona.  SPAIN
//
//////////////////////////////////////////////////////////////////////


#include "TypeCheckVisitor.h"

#include "antlr4-runtime.h"

#include "../common/TypesMgr.h"
#include "../common/SymTable.h"
#include "../common/TreeDecoration.h"
#include "../common/SemErrors.h"

#include <iostream>
#include <string>

// uncomment the following line to enable debugging messages with DEBUG*
// #define DEBUG_BUILD
#include "../common/debug.h"

// using namespace std;


// Constructor
TypeCheckVisitor::TypeCheckVisitor(TypesMgr       & Types,
				   SymTable       & Symbols,
				   TreeDecoration & Decorations,
				   SemErrors      & Errors) :
  Types{Types},
  Symbols {Symbols},
  Decorations{Decorations},
  Errors{Errors} {
}

// Methods to visit each kind of node:
//
antlrcpp::Any TypeCheckVisitor::visitProgram(AslParser::ProgramContext *ctx) {
  DEBUG_ENTER();
  SymTable::ScopeId sc = getScopeDecor(ctx);
  Symbols.pushThisScope(sc);
  //Symbols.print();
  for (auto ctxFunc : ctx->function()) {
    visit(ctxFunc);
  }
  if (Symbols.noMainProperlyDeclared())
    Errors.noMainProperlyDeclared(ctx);
  Symbols.popScope();
  Errors.print();
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitFunction(AslParser::FunctionContext *ctx) {
  DEBUG_ENTER();



  //NUEVO
  std::vector<TypesMgr::TypeId> lParamsTy;
  TypesMgr::TypeId tRet = Types.createVoidTy();
  if (ctx->basic_type() != NULL){
    //visit(ctx->basic_type());   //no haria falta, ya se visito en Symbols.
    tRet = getTypeDecor(ctx->basic_type());
  }

  TypesMgr::TypeId tFunc = Types.createFunctionTy(lParamsTy, tRet);
  Symbols.setCurrentFunctionTy(tFunc);//HASTA AQUI


  //Symbols.setCurrentFunctionTy(getTypeDecor(ctx));  //NEW ???? relacionado SymbolsVisitors.cpp (Function)


  //std::cout << Types.to_string(Symbols.getCurrentFunctionTy()) << std::endl;
  //std::cout << Types.to_string(getTypeDecor(ctx)) << std::endl;




  SymTable::ScopeId sc = getScopeDecor(ctx);
  Symbols.pushThisScope(sc);

  //Symbols.print();

  visit(ctx->statements());
  Symbols.popScope();
  DEBUG_EXIT();
  return 0;
}

// antlrcpp::Any TypeCheckVisitor::visitDeclarations(AslParser::DeclarationsContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

// antlrcpp::Any TypeCheckVisitor::visitVariable_decl(AslParser::Variable_declContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

// antlrcpp::Any TypeCheckVisitor::visitType(AslParser::TypeContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

antlrcpp::Any TypeCheckVisitor::visitStatements(AslParser::StatementsContext *ctx) {
  DEBUG_ENTER();
  visitChildren(ctx);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitAssignStmt(AslParser::AssignStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->left_expr());
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->left_expr());
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isErrorTy(t2)) and
      (not Types.copyableTypes(t1, t2)))
    Errors.incompatibleAssignment(ctx->ASSIGN());
  if ((not Types.isErrorTy(t1)) and (not getIsLValueDecor(ctx->left_expr())))
    Errors.nonReferenceableLeftExpr(ctx->left_expr());
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitIfStmt(AslParser::IfStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1)))
    Errors.booleanRequired(ctx);
  visit(ctx->statements());
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitWhileStmt(AslParser::WhileStmtContext *ctx) {    //NEW
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1)))
    Errors.booleanRequired(ctx);
  visit(ctx->statements());
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitProcCall(AslParser::ProcCallContext *ctx) {
  DEBUG_ENTER();
  /*visit(ctx->ident());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->ident());
  if (not Types.isFunctionTy(t1) and not Types.isErrorTy(t1)) {
    Errors.isNotCallable(ctx->ident());
  }*/

  


  visit(ctx->ident());  //!!!!
  for (int i = 0; i < (ctx->expr()).size(); ++i) {  //hace falta... raro
          visit(ctx->expr(i));
  }
  

  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  TypesMgr::TypeId t = Types.createErrorTy();


  


  if (not Types.isFunctionTy(tID) and not Types.isErrorTy(tID)) {
    Errors.isNotCallable(ctx->ident());
  }
  else if (not Types.isErrorTy(tID)){
    t = Types.getFuncReturnType(tID);

    /*if (Types.isVoidFunction(tID)){
      Errors.isNotFunction(ctx->ident());
      t = Types.createErrorTy();
    }*/

    

    if (Types.getNumOfParameters(tID) != (ctx->expr()).size() ){
      Errors.numberOfParameters(ctx->ident());
    }
    else {
      std::vector<TypesMgr::TypeId> lParamsTy = Types.getFuncParamsTypes(tID);
      for (int i = 0; i < lParamsTy.size(); ++i) {
        visit(ctx->expr(i));  //si hace falta
        //std::cout << Types.to_string(getTypeDecor(ctx->expr(i))) << std::endl;
        //std::cout << Types.to_string(lParamsTy[i]) << std::endl;

        if (not Types.equalTypes(lParamsTy[i], getTypeDecor(ctx->expr(i)))) { //not error type ???
          if (not (Types.isIntegerTy(getTypeDecor(ctx->expr(i))) and Types.isFloatTy(lParamsTy[i])))
            Errors.incompatibleParameter(ctx->expr(i), i+1, ctx);
        }
      }
    }

  }






  




  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitReturnStmt(AslParser::ReturnStmtContext *ctx) {    //NEW
  DEBUG_ENTER();

  TypesMgr::TypeId f = Symbols.getCurrentFunctionTy();
  //if ()

  if (ctx->expr()) {
    
    visit(ctx->expr());
    TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
    TypesMgr::TypeId f = Symbols.getCurrentFunctionTy();

    TypesMgr::TypeId tr = Types.getFuncReturnType(f);

    /*std::cout << "hola" << std::endl;
    if (Types.isIntegerTy(tr)) std::cout << "1" << std::endl;
    if (Types.isErrorTy(tr)) std::cout << "2" << std::endl;
    if (Types.isFloatTy(tr)) std::cout << "3" << std::endl;
    if (Types.isBooleanTy(tr)) std::cout << "4" << std::endl;
    if (Types.isCharacterTy(tr)) std::cout << "5" << std::endl;
    if (Types.isVoidTy(tr)) std::cout << "6" << std::endl;
    if (Types.isNumericTy(tr)) std::cout << "7" << std::endl;
    if (Types.isPrimitiveTy(tr)) std::cout << "8" << std::endl;
    if (Types.isPrimitiveNonVoidTy(tr)) std::cout << "9" << std::endl;
    if (Types.isFunctionTy(tr)) std::cout << "10" << std::endl;
    //if (Types.isVoidFunction(tr)) std::cout << "11" << std::endl;
    std::cout << "adios" << std::endl;
    std::cout << "mama" << std::endl;
    if (Types.isIntegerTy(t1)) std::cout << "1" << std::endl;
    if (Types.isErrorTy(t1)) std::cout << "2" << std::endl;
    if (Types.isFloatTy(t1)) std::cout << "3" << std::endl;
    if (Types.isBooleanTy(t1)) std::cout << "4" << std::endl;
    if (Types.isCharacterTy(t1)) std::cout << "5" << std::endl;
    if (Types.isVoidTy(t1)) std::cout << "6" << std::endl;
    if (Types.isNumericTy(t1)) std::cout << "7" << std::endl;
    if (Types.isPrimitiveTy(t1)) std::cout << "8" << std::endl;
    if (Types.isPrimitiveNonVoidTy(t1)) std::cout << "9" << std::endl;
    if (Types.isFunctionTy(t1)) std::cout << "10" << std::endl;
    //if (Types.isVoidFunction(tr)) std::cout << "11" << std::endl;
    std::cout << "papa" << std::endl;*/

    if (Types.isVoidFunction(f)) Errors.incompatibleReturn(ctx->RETURN());  //funcion VOID salida no void
    else if ((not Types.isErrorTy(t1)) and (not Types.equalTypes(t1, tr))){
      if (not (Types.isIntegerTy(t1) and Types.isFloatTy(tr))) {
        Errors.incompatibleReturn(ctx->RETURN());
      }

    }
  }
  else if (!Types.isVoidFunction(f)) Errors.incompatibleReturn(ctx->RETURN());  //salida void, funcion no void
  
  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitReadStmt(AslParser::ReadStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->left_expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->left_expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isPrimitiveTy(t1)) and
      (not Types.isFunctionTy(t1)))
    Errors.readWriteRequireBasic(ctx);
  if ((not Types.isErrorTy(t1)) and (not getIsLValueDecor(ctx->left_expr())))
    Errors.nonReferenceableExpression(ctx);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitWriteExpr(AslParser::WriteExprContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isPrimitiveTy(t1)))
    Errors.readWriteRequireBasic(ctx);
  DEBUG_EXIT();
  return 0;
}

// antlrcpp::Any TypeCheckVisitor::visitWriteString(AslParser::WriteStringContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

antlrcpp::Any TypeCheckVisitor::visitLeft_expr(AslParser::Left_exprContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  bool b = getIsLValueDecor(ctx->ident());


  if (ctx->expr()) {  //is array
    visit(ctx->expr());

    TypesMgr::TypeId t = getTypeDecor(ctx->expr());
    bool array_okay = not Types.isErrorTy(tID);

    if ((not Types.isErrorTy(tID)) and (not Types.isArrayTy(tID))){  //ID no array
      Errors.nonArrayInArrayAccess(ctx);
      tID = Types.createErrorTy(); //no acumula mas errores
      //b = false;  //NOSE
      array_okay = false;
    }
    if ((not Types.isErrorTy(t)) and (not Types.isIntegerTy(t))){  //index no entero
      Errors.nonIntegerIndexInArrayAccess(ctx->expr());
      array_okay = false;
      //poner tID como errorType ???
    }
    if (array_okay) {
      tID = Types.getArrayElemType(tID);
      //b = true;
    }
  }
  putTypeDecor(ctx, tID);
  putIsLValueDecor(ctx, b);   //QUE ES???
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitArray_index(AslParser::Array_indexContext *ctx) {    //NEW
  DEBUG_ENTER();

  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  visit(ctx->expr());
  TypesMgr::TypeId t = getTypeDecor(ctx->expr());

  bool array_okay = not Types.isErrorTy(tID);

  if ((not Types.isErrorTy(tID)) and (not Types.isArrayTy(tID))){  //ID no array
    Errors.nonArrayInArrayAccess(ctx);
    tID = Types.createErrorTy();    //NOSE
    //b = False;
    array_okay = false;
  }
  if ((not Types.isErrorTy(t)) and (not Types.isIntegerTy(t))){  //index no entero
    Errors.nonIntegerIndexInArrayAccess(ctx->expr());
    array_okay = false;
    tID = Types.createErrorTy();  //hace falta
    //poner tID como errorType ???
  }
  if (array_okay) {
    tID = Types.getArrayElemType(tID);
    //b = true;
  }

  putTypeDecor(ctx, tID);


  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitArithmetic(AslParser::ArithmeticContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));

  TypesMgr::TypeId t = Types.createIntegerTy();

  if (ctx->MOD()) {
     if (((not Types.isErrorTy(t1)) and (not Types.isIntegerTy(t1))) or 
        ((not Types.isErrorTy(t2)) and (not Types.isIntegerTy(t2))))
        Errors.incompatibleOperator(ctx->op);
  }
  else {
    if (((not Types.isErrorTy(t1)) and (not Types.isNumericTy(t1))) or 
            ((not Types.isErrorTy(t2)) and (not Types.isNumericTy(t2))))
      Errors.incompatibleOperator(ctx->op);
    if (Types.isFloatTy(t1) or Types.isFloatTy(t2)) t = Types.createFloatTy();
  }
  

  
  
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitRelational(AslParser::RelationalContext *ctx) {  //NOTHING
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  std::string oper = ctx->op->getText();
  if ((not Types.isErrorTy(t1)) and (not Types.isErrorTy(t2)) and
      (not Types.comparableTypes(t1, t2, oper)))
    Errors.incompatibleOperator(ctx->op);
  TypesMgr::TypeId t = Types.createBooleanTy();
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitValue(AslParser::ValueContext *ctx) {  //NOTHING
  DEBUG_ENTER();

  TypesMgr::TypeId t = Types.createErrorTy();

	if (ctx->INTVAL()) t = Types.createIntegerTy();
	else if (ctx->FLOATVAL()) t = Types.createFloatTy();
	else if (ctx->BOOLVAL()) t = Types.createBooleanTy();
	else if (ctx->CHARVAL()) t = Types.createCharacterTy();

	putTypeDecor(ctx, t);
	putIsLValueDecor(ctx, false);	//what is this???

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitExprIdent(AslParser::ExprIdentContext *ctx) {  //NOTHING
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->ident());
  putTypeDecor(ctx, t1);
  bool b = getIsLValueDecor(ctx->ident());
  putIsLValueDecor(ctx, b);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitIdent(AslParser::IdentContext *ctx) {  //NOTHINg
  DEBUG_ENTER();
  std::string ident = ctx->getText();
  if (Symbols.findInStack(ident) == -1) {
    Errors.undeclaredIdent(ctx->ID());
    TypesMgr::TypeId te = Types.createErrorTy();
    putTypeDecor(ctx, te);
    putIsLValueDecor(ctx, true);
  }
  else {
    TypesMgr::TypeId t1 = Symbols.getType(ident);
    putTypeDecor(ctx, t1);
    if (Symbols.isFunctionClass(ident))
      putIsLValueDecor(ctx, false);
    else
      putIsLValueDecor(ctx, true);
  }
  DEBUG_EXIT();
  return 0;
}



antlrcpp::Any TypeCheckVisitor::visitLogical(AslParser::LogicalContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  if (((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1))) or
      ((not Types.isErrorTy(t2)) and (not Types.isBooleanTy(t2))))
    Errors.incompatibleOperator(ctx->op);
  TypesMgr::TypeId t = Types.createBooleanTy();
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitFunction_call(AslParser::Function_callContext *ctx) {
  DEBUG_ENTER();

  visit(ctx->ident());  //!!!!
  /*for (int i = 0; i < (ctx->expr()).size(); ++i) {    //aqui no!!! porque???
          visit(ctx->expr(i));
  }*/

  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  TypesMgr::TypeId t = Types.createErrorTy();

  if (not Types.isFunctionTy(tID) and not Types.isErrorTy(tID)) {
    Errors.isNotCallable(ctx->ident());
  }
  else {
    t = Types.getFuncReturnType(tID);

    if (Types.isVoidFunction(tID)){
      Errors.isNotFunction(ctx->ident());
      t = Types.createErrorTy();
    }
    if (Types.getNumOfParameters(tID) != (ctx->expr()).size() ){
      Errors.numberOfParameters(ctx->ident());
    }
    else {
      std::vector<TypesMgr::TypeId> lParamsTy = Types.getFuncParamsTypes(tID);
      for (int i = 0; i < lParamsTy.size(); ++i) {
        visit(ctx->expr(i));  //si hace falta
        //std::cout << Types.to_string(getTypeDecor(ctx->expr(i))) << std::endl;
        //std::cout << Types.to_string(lParamsTy[i]) << std::endl;

        if (not Types.equalTypes(lParamsTy[i], getTypeDecor(ctx->expr(i)))) { //not error type ???
          if (not (Types.isIntegerTy(getTypeDecor(ctx->expr(i))) and Types.isFloatTy(lParamsTy[i])))
            Errors.incompatibleParameter(ctx->expr(i), i+1, ctx);
        }
      }
    }

  }

  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);

  DEBUG_EXIT();
  return 0;
}



// Getters for the necessary tree node atributes:
//   Scope, Type ans IsLValue
SymTable::ScopeId TypeCheckVisitor::getScopeDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getScope(ctx);
}
TypesMgr::TypeId TypeCheckVisitor::getTypeDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getType(ctx);
}
bool TypeCheckVisitor::getIsLValueDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getIsLValue(ctx);
}

// Setters for the necessary tree node attributes:
//   Scope, Type ans IsLValue
void TypeCheckVisitor::putScopeDecor(antlr4::ParserRuleContext *ctx, SymTable::ScopeId s) {
  Decorations.putScope(ctx, s);
}
void TypeCheckVisitor::putTypeDecor(antlr4::ParserRuleContext *ctx, TypesMgr::TypeId t) {
  Decorations.putType(ctx, t);
}
void TypeCheckVisitor::putIsLValueDecor(antlr4::ParserRuleContext *ctx, bool b) {
  Decorations.putIsLValue(ctx, b);
}
