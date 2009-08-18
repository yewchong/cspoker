package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
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
 <code>'$unify_witness'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$unify_witness_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("+", 2);
    static Predicate _$unify_witness_2_top = new PRED_$unify_witness_2_top();
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _$unify_witness_2_var = new PRED_$unify_witness_2_var();
    static Predicate _$unify_witness_2_var_1 = new PRED_$unify_witness_2_var_1();
    static Predicate _$unify_witness_2_1 = new PRED_$unify_witness_2_1();
    static Predicate _$unify_witness_2_2 = new PRED_$unify_witness_2_2();

    public Term arg1, arg2;

    public PRED_$unify_witness_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$unify_witness_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$unify_witness(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        return _$unify_witness_2_top;
    }
}

class PRED_$unify_witness_2_top extends PRED_$unify_witness_2 {
    public Predicate exec(Prolog engine) {
        engine.setB0();
        return engine.switch_on_term(_$unify_witness_2_var, _fail_0, _fail_0, _$unify_witness_2_1, _fail_0, _$unify_witness_2_2);
    }
}

class PRED_$unify_witness_2_var extends PRED_$unify_witness_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$unify_witness_2_1, _$unify_witness_2_var_1);
    }
}

class PRED_$unify_witness_2_var_1 extends PRED_$unify_witness_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$unify_witness_2_2);
    }
}

class PRED_$unify_witness_2_1 extends PRED_$unify_witness_2 {
    public Predicate exec(Prolog engine) {
    // '$unify_witness'([],A):-!
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$unify_witness'([],A):-['$neck_cut']
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

class PRED_$unify_witness_2_2 extends PRED_$unify_witness_2 {
    public Predicate exec(Prolog engine) {
    // '$unify_witness'([A+B|C],A):-'$unify_witness'(C,A)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$unify_witness'([A+B|C],A):-['$unify_witness'(C,A)]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a3, a4), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s2.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a5 = args[0];
        } else if (a3.isVariable()){
            a5 = new VariableTerm(engine);
            Term[] args = {a5, new VariableTerm(engine)};
            ((VariableTerm) a3).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        if (! a5.unify(a2, engine.trail))
            return engine.fail();
        engine.aregs[1] = a4;
        engine.aregs[2] = a5;
        engine.cont = cont;
        return _$unify_witness_2_top;
    }
}
