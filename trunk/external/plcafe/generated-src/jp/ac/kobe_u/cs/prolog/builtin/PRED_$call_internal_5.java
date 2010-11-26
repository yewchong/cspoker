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
 <code>'$call_internal'/5</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$call_internal_5 extends Predicate {
    static IntegerTerm si1 = new IntegerTerm(1);
    static SymbolTerm s2 = SymbolTerm.makeSymbol(":", 2);
    static Predicate _$call_internal_5_sub_1 = new PRED_$call_internal_5_sub_1();
    static Predicate _$call_internal_5_1 = new PRED_$call_internal_5_1();
    static Predicate _$call_internal_5_2 = new PRED_$call_internal_5_2();

    public Term arg1, arg2, arg3, arg4, arg5;

    public PRED_$call_internal_5(Term a1, Term a2, Term a3, Term a4, Term a5, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        this.cont = cont;
    }

    public PRED_$call_internal_5(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        this.cont = cont;
    }

    public int arity() { return 5; }

    public String toString() {
        return "$call_internal(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$call_internal_5_1, _$call_internal_5_sub_1);
    }
}

class PRED_$call_internal_5_sub_1 extends PRED_$call_internal_5 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$call_internal_5_2);
    }
}

class PRED_$call_internal_5_1 extends PRED_$call_internal_5 {
    public Predicate exec(Prolog engine) {
    // '$call_internal'(A,B,C,D,E):-'$new_internal_database'(B),hash_contains_key(B,C),!,'$get_current_B'(F),G is D+1,clause(B:A,H),'$meta_call'(H,B,F,G,E)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        Predicate p1, p2, p3, p4, p5, p6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$call_internal'(A,B,C,D,E):-['$get_level'(F),'$new_internal_database'(B),hash_contains_key(B,C),'$cut'(F),'$get_current_B'(G),'$plus'(D,1,H),clause(B:A,I),'$meta_call'(I,B,G,H,E)]
        a6 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(6))
        if (! a6.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a7 = new VariableTerm(engine);
        a8 = new VariableTerm(engine);
        Term[] y1 = {a2, a1};
        a9 = new StructureTerm(s2, y1);
        a10 = new VariableTerm(engine);
        p1 = new PRED_$meta_call_5(a10, a2, a7, a8, a5, cont);
        p2 = new PRED_clause_2(a9, a10, p1);
        p3 = new PRED_$plus_3(a4, si1, a8, p2);
        p4 = new PRED_$get_current_B_1(a7, p3);
        p5 = new PRED_$cut_1(a6, p4);
        p6 = new PRED_hash_contains_key_2(a2, a3, p5);
        return new PRED_$new_internal_database_1(a2, p6);
    }
}

class PRED_$call_internal_5_2 extends PRED_$call_internal_5 {
    public Predicate exec(Prolog engine) {
    // '$call_internal'(A,B,C,D,E):-'$call'(B,A)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$call_internal'(A,B,C,D,E):-['$call'(B,A)]
        return new PRED_$call_2(a2, a1, cont);
    }
}