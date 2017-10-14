package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import static no.uio.ifi.asp.scanner.TokenKind.*;


public class AspInnerExpr extends AspAtom {
    AspExpr expr;

    AspInnerExpr(int n) {
        super(n);
    }

    public static AspInnerExpr parse(Scanner s) {
        Main.log.enterParser("AspInnerExpr");
        AspInnerExpr ie = new AspInnerExpr(s.curLineNum());

        skip(s, leftParToken);
        ie.expr = AspExpr.parse(s);
        skip(s, rightParToken);

        Main.log.leaveParser("AspInnerExpr");
        return ie;
    }

    @Override
    public void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
