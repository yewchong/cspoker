package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$add_op'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$add_op_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(",");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("permission", 4);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("modify");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("operator");
    static SymbolTerm s5 = SymbolTerm.makeSymbol("op", 3);
    static IntegerTerm si6 = new IntegerTerm(3);
    static SymbolTerm s7 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s8 = SymbolTerm.makeSymbol("jp.ac.kobe_u.cs.prolog.builtin");
    static SymbolTerm s9 = SymbolTerm.makeSymbol("$current_operator", 3);
    static IntegerTerm si10 = new IntegerTerm(0);
    static Predicate _$add_op_3_var = new PRED_$add_op_3_var();
    static Predicate _$add_op_3_var_1 = new PRED_$add_op_3_var_1();
    static Predicate _$add_op_3_var_2 = new PRED_$add_op_3_var_2();
    static Predicate _$add_op_3_var_3 = new PRED_$add_op_3_var_3();
    static Predicate _$add_op_3_int = new PRED_$add_op_3_int();
    static Predicate _$add_op_3_int_1 = new PRED_$add_op_3_int_1();
    static Predicate _$add_op_3_int_2 = new PRED_$add_op_3_int_2();
    static Predicate _$add_op_3_1 = new PRED_$add_op_3_1();
    static Predicate _$add_op_3_2 = new PRED_$add_op_3_2();
    static Predicate _$add_op_3_3 = new PRED_$add_op_3_3();
    static Predicate _$add_op_3_4 = new PRED_$add_op_3_4();

    public Term arg1, arg2, arg3;

    public PRED_$add_op_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$add_op_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$add_op(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$add_op_3_var, _$add_op_3_int, _$add_op_3_int, _$add_op_3_var, _$add_op_3_int, _$add_op_3_int);
    }
}

class PRED_$add_op_3_var extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$add_op_3_1, _$add_op_3_var_1);
    }
}

class PRED_$add_op_3_var_1 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$add_op_3_2, _$add_op_3_var_2);
    }
}

class PRED_$add_op_3_var_2 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$add_op_3_3, _$add_op_3_var_3);
    }
}

class PRED_$add_op_3_var_3 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$add_op_3_4);
    }
}

class PRED_$add_op_3_int extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$add_op_3_2, _$add_op_3_int_1);
    }
}

class PRED_$add_op_3_int_1 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$add_op_3_3, _$add_op_3_int_2);
    }
}

class PRED_$add_op_3_int_2 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$add_op_3_4);
    }
}

class PRED_$add_op_3_1 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
    // '$add_op'(',',A,B):-!,illarg(permission(modify,operator,',',C),op(A,B,','),3)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$add_op'(',',A,B):-['$neck_cut',illarg(permission(modify,operator,',',C),op(A,B,','),3)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        Term[] y1 = {s3, s4, s1, new VariableTerm(engine)};
        a4 = new StructureTerm(s2, y1);
        Term[] y2 = {a2, a3, s1};
        a5 = new StructureTerm(s5, y2);
        return new PRED_illarg_3(a4, a5, si6, cont);
    }
}

class PRED_$add_op_3_2 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
    // '$add_op'(A,B,C):-clause('$current_operator'(D,E,A),F),'$op_specifier'(C,G),'$op_specifier'(E,H),G=H,retract('$current_operator'(I,E,A)),fail
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        Predicate p1, p2, p3, p4, p5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$add_op'(A,B,C):-[clause('jp.ac.kobe_u.cs.prolog.builtin':'$current_operator'(D,E,A),F),'$op_specifier'(C,G),'$op_specifier'(E,H),'$unify'(G,H),retract('jp.ac.kobe_u.cs.prolog.builtin':'$current_operator'(I,E,A)),fail]
        a4 = new VariableTerm(engine);
        Term[] y1 = {new VariableTerm(engine), a4, a1};
        a5 = new StructureTerm(s9, y1);
        Term[] y2 = {s8, a5};
        a6 = new StructureTerm(s7, y2);
        a7 = new VariableTerm(engine);
        a8 = new VariableTerm(engine);
        Term[] y3 = {new VariableTerm(engine), a4, a1};
        a9 = new StructureTerm(s9, y3);
        Term[] y4 = {s8, a9};
        a10 = new StructureTerm(s7, y4);
        p1 = new PRED_fail_0(cont);
        p2 = new PRED_retract_1(a10, p1);
        p3 = new PRED_$unify_2(a7, a8, p2);
        p4 = new PRED_$op_specifier_2(a4, a8, p3);
        p5 = new PRED_$op_specifier_2(a3, a7, p4);
        return new PRED_clause_2(a6, new VariableTerm(engine), p5);
    }
}

class PRED_$add_op_3_3 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
    // '$add_op'(A,0,B):-!
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$add_op'(A,0,B):-['$neck_cut']
        a2 = a2.dereference();
        if (a2.isInteger()){
            if (((IntegerTerm) a2).intValue() != 0)
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(si10, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$add_op_3_4 extends PRED_$add_op_3 {
    public Predicate exec(Prolog engine) {
    // '$add_op'(A,B,C):-assertz('$current_operator'(B,C,A))
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$add_op'(A,B,C):-[assertz('jp.ac.kobe_u.cs.prolog.builtin':'$current_operator'(B,C,A))]
        Term[] y1 = {a2, a3, a1};
        a4 = new StructureTerm(s9, y1);
        Term[] y2 = {s8, a4};
        a5 = new StructureTerm(s7, y2);
        return new PRED_assertz_1(a5, cont);
    }
}
