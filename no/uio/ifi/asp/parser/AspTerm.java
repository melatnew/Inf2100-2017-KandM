package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

import java.util.ArrayList;

public class AspTerm extends AspSyntax {
    ArrayList<AspFactor> factorsList = new ArrayList<AspFactor>();
    ArrayList<AspTermOpr> termOprsList = new ArrayList<AspTermOpr>();

    AspTerm(int n) {
        super(n);
    }

    public static AspTerm parse(Scanner s) {
        Main.log.enterParser("term");
        AspTerm term = new AspTerm(s.curLineNum());

        while(true) {
            term.factorsList.add(AspFactor.parse(s));
            if(! s.isTermOpr()) break;
            term.termOprsList.add(AspTermOpr.parse(s));
        }
        Main.log.leaveParser("term");
        return term;
    }





    @Override
    protected void prettyPrint() {

        factorsList.get(0).prettyPrint();
        for (int i = 0; i < termOprsList.size(); i++){
            termOprsList.get(i).prettyPrint();
            factorsList.get(i+1).prettyPrint();
        }

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
