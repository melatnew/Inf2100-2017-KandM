package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

import java.util.ArrayList;

public class AspFactor extends AspSyntax{
    AspFactorPrefix fPrefix = null; // optional
    ArrayList<AspPrimary> primaryList = new ArrayList<AspPrimary>();
    ArrayList<AspFactorOpr> facOprList = new ArrayList<AspFactorOpr>();


    AspFactor(int n) {
        super(n);
    }

    public static AspFactor parse(Scanner s) {
        Main.log.enterParser("factor");
        AspFactor factor = new AspFactor(s.curLineNum());

        if(s.isFactorPrefix()) {
            factor.fPrefix = AspFactorPrefix.parse(s);
        }
        while(true) {
            factor.primaryList.add(AspPrimary.parse(s));
            if(! s.isFactorOpr()) break;
            factor.facOprList.add(AspFactorOpr.parse(s));
        }
        Main.log.leaveParser("factor");
        return factor;
    }

    @Override
    protected void prettyPrint() {
        if (fPrefix!=null) {
            fPrefix.prettyPrint();
        }
        primaryList.get(0).prettyPrint();
        for (int i = 0; i < facOprList.size(); i++) {
            facOprList.get(i).prettyPrint();
            primaryList.get(i+1).prettyPrint();
        }

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}



