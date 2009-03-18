package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$findall'/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$findall_4 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("jp.ac.kobe_u.cs.prolog.builtin");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("$FINDALL");
    static Predicate _$findall_4_sub_1 = new PRED_$findall_4_sub_1();
    static Predicate _$findall_4_1 = new PRED_$findall_4_1();
    static Predicate _$findall_4_2 = new PRED_$findall_4_2();

    public Term arg1, arg2, arg3, arg4;

    public PRED_$findall_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_$findall_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "$findall(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$findall_4_1, _$findall_4_sub_1);
    }
}

class PRED_$findall_4_sub_1 extends PRED_$findall_4 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$findall_4_2);
    }
}

class PRED_$findall_4_1 extends PRED_$findall_4 {
    public Predicate exec(Prolog engine) {
    // '$findall'(A,B,C,D):-call(C),copy_term(B,E),'$hash_adda'(A,'$FINDALL',E),fail
        Term a1, a2, a3, a4, a5, a6;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$findall'(A,B,C,D):-[call('jp.ac.kobe_u.cs.prolog.builtin':C),copy_term(B,E),'$hash_adda'(A,'$FINDALL',E),fail]
        Term[] y1 = {s2, a3};
        a5 = new StructureTerm(s1, y1);
        a6 = new VariableTerm(engine);
        p1 = new PRED_fail_0(cont);
        p2 = new PRED_$hash_adda_3(a1, s3, a6, p1);
        p3 = new PRED_copy_term_2(a2, a6, p2);
        return new PRED_call_1(a5, p3);
    }
}

class PRED_$findall_4_2 extends PRED_$findall_4 {
    public Predicate exec(Prolog engine) {
    // '$findall'(A,B,C,D):-hash_get(A,'$FINDALL',E),'$builtin_reverse'(E,D)
        Term a1, a2, a3, a4, a5;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$findall'(A,B,C,D):-[hash_get(A,'$FINDALL',E),'$builtin_reverse'(E,D)]
        a5 = new VariableTerm(engine);
        p1 = new PRED_$builtin_reverse_2(a5, a4, cont);
        return new PRED_hash_get_3(a1, s3, a5, p1);
    }
}