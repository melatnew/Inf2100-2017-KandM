package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

/**
 *
 */
public class AspFactorPrefix extends AspSyntax {
     TokenKind oprType;

    AspFactorPrefix(int n) {
        super(n);
    }

    public static AspFactorPrefix parse(Scanner s) {
        Main.log.enterParser("AspFactorPrefix");
        AspFactorPrefix fOpr = new AspFactorPrefix(s.curLineNum());

        fOpr.oprType = s.curToken().kind;
        skip(s,s.curToken().kind);

        Main.log.leaveParser("AspFactorPrefix");
        return fOpr;
    }

    @Override
    public void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
