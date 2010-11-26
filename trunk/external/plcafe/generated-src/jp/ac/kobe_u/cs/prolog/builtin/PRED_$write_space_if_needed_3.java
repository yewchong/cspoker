package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$write_space_if_needed'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$write_space_if_needed_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("punct");
    static SymbolTerm s2 = SymbolTerm.makeSymbol(" ");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("other");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("alpha");
    static Predicate _$write_space_if_needed_3_var = new PRED_$write_space_if_needed_3_var();
    static Predicate _$write_space_if_needed_3_var_1 = new PRED_$write_space_if_needed_3_var_1();
    static Predicate _$write_space_if_needed_3_var_2 = new PRED_$write_space_if_needed_3_var_2();
    static Predicate _$write_space_if_needed_3_var_3 = new PRED_$write_space_if_needed_3_var_3();
    static Predicate _$write_space_if_needed_3_int = new PRED_$write_space_if_needed_3_int();
    static Predicate _$write_space_if_needed_3_int_1 = new PRED_$write_space_if_needed_3_int_1();
    static Predicate _$write_space_if_needed_3_con = new PRED_$write_space_if_needed_3_con();
    static Predicate _$write_space_if_needed_3_con_0 = new PRED_$write_space_if_needed_3_con_0();
    static Predicate _$write_space_if_needed_3_con_0_1 = new PRED_$write_space_if_needed_3_con_0_1();
    static Predicate _$write_space_if_needed_3_con_0_2 = new PRED_$write_space_if_needed_3_con_0_2();
    static Predicate _$write_space_if_needed_3_con_1 = new PRED_$write_space_if_needed_3_con_1();
    static Predicate _$write_space_if_needed_3_con_1_1 = new PRED_$write_space_if_needed_3_con_1_1();
    static Predicate _$write_space_if_needed_3_con_1_2 = new PRED_$write_space_if_needed_3_con_1_2();
    static Predicate _$write_space_if_needed_3_1 = new PRED_$write_space_if_needed_3_1();
    static Predicate _$write_space_if_needed_3_2 = new PRED_$write_space_if_needed_3_2();
    static Predicate _$write_space_if_needed_3_3 = new PRED_$write_space_if_needed_3_3();
    static Predicate _$write_space_if_needed_3_4 = new PRED_$write_space_if_needed_3_4();
    static java.util.Hashtable<Term, Predicate> con = new java.util.Hashtable<Term, Predicate>(2);
    static {
        con.put(s1, _$write_space_if_needed_3_con_0);
        con.put(s3, _$write_space_if_needed_3_con_1);
    }

    public Term arg1, arg2, arg3;

    public PRED_$write_space_if_needed_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$write_space_if_needed_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$write_space_if_needed(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$write_space_if_needed_3_var, _$write_space_if_needed_3_int, _$write_space_if_needed_3_int, _$write_space_if_needed_3_con, _$write_space_if_needed_3_int, _$write_space_if_needed_3_int);
    }
}

class PRED_$write_space_if_needed_3_var extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$write_space_if_needed_3_1, _$write_space_if_needed_3_var_1);
    }
}

class PRED_$write_space_if_needed_3_var_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$write_space_if_needed_3_2, _$write_space_if_needed_3_var_2);
    }
}

class PRED_$write_space_if_needed_3_var_2 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$write_space_if_needed_3_3, _$write_space_if_needed_3_var_3);
    }
}

class PRED_$write_space_if_needed_3_var_3 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_space_if_needed_3_4);
    }
}

class PRED_$write_space_if_needed_3_int extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$write_space_if_needed_3_2, _$write_space_if_needed_3_int_1);
    }
}

class PRED_$write_space_if_needed_3_int_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_space_if_needed_3_4);
    }
}

class PRED_$write_space_if_needed_3_con extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(con, _$write_space_if_needed_3_int);
    }
}

class PRED_$write_space_if_needed_3_con_0 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$write_space_if_needed_3_1, _$write_space_if_needed_3_con_0_1);
    }
}

class PRED_$write_space_if_needed_3_con_0_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$write_space_if_needed_3_2, _$write_space_if_needed_3_con_0_2);
    }
}

class PRED_$write_space_if_needed_3_con_0_2 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_space_if_needed_3_4);
    }
}

class PRED_$write_space_if_needed_3_con_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$write_space_if_needed_3_2, _$write_space_if_needed_3_con_1_1);
    }
}

class PRED_$write_space_if_needed_3_con_1_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$write_space_if_needed_3_3, _$write_space_if_needed_3_con_1_2);
    }
}

class PRED_$write_space_if_needed_3_con_1_2 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_space_if_needed_3_4);
    }
}

class PRED_$write_space_if_needed_3_1 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
    // '$write_space_if_needed'(punct,A,B):-!
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$write_space_if_needed'(punct,A,B):-['$neck_cut']
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
        return cont;
    }
}

class PRED_$write_space_if_needed_3_2 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
    // '$write_space_if_needed'(A,A,B):-!,put_char(B,' ')
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$write_space_if_needed'(A,A,B):-['$neck_cut',put_char(B,' ')]
        if (! a1.unify(a2, engine.trail))
            return engine.fail();
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return new PRED_put_char_2(a3, s2, cont);
    }
}

class PRED_$write_space_if_needed_3_3 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
    // '$write_space_if_needed'(other,alpha,A):-!,put_char(A,' ')
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$write_space_if_needed'(other,alpha,A):-['$neck_cut',put_char(A,' ')]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s3))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s3, engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s4))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s4, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return new PRED_put_char_2(a3, s2, cont);
    }
}

class PRED_$write_space_if_needed_3_4 extends PRED_$write_space_if_needed_3 {
    public Predicate exec(Prolog engine) {
    // '$write_space_if_needed'(A,B,C):-true
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$write_space_if_needed'(A,B,C):-[]
        return cont;
    }
}