package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>open/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_open_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");

    public Term arg1, arg2, arg3;

    public PRED_open_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_open_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "open(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
    // open(A,B,C):-open(A,B,C,[])
        engine.setB0();
        Term a1, a2, a3;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
    // open(A,B,C):-[open(A,B,C,[])]
        return new PRED_open_4(a1, a2, a3, s1, cont);
    }
}
