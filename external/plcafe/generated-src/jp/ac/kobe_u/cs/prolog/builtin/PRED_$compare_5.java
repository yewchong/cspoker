package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$compare'/5</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$compare_5 extends Predicate {

    public Term arg1, arg2, arg3, arg4, arg5;

    public PRED_$compare_5(Term a1, Term a2, Term a3, Term a4, Term a5, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        this.cont = cont;
    }

    public PRED_$compare_5(){}

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
        return "$compare(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$compare'(A,B,C,D,E):-'$compare'(A,C,D,F),'$combine'(B,F,E)
        engine.setB0();
        Term a1, a2, a3, a4, a5, a6;
        Predicate p1;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
        a4 = arg4;
        a5 = arg5;
    // '$compare'(A,B,C,D,E):-['$compare'(A,C,D,F),'$combine'(B,F,E)]
        a6 = new VariableTerm(engine);
        p1 = new PRED_$combine_3(a2, a6, a5, cont);
        return new PRED_$compare_4(a1, a3, a4, a6, p1);
    }
}