package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

public class AspFloatLiteral extends AspAtom{
    double fLit;
    AspFloatLiteral(int n) {
        super(n);
    }

    public static AspFloatLiteral parse(Scanner s) {
        Main.log.enterParser("AspFloatLiteral");
        AspFloatLiteral floatLiteral = new AspFloatLiteral(s.curLineNum());

        if(s.curToken().kind == TokenKind.floatToken){
            floatLiteral.fLit= s.curToken().floatLit;
        }

        skip(s, TokenKind.floatToken);


        Main.log.leaveParser("AspFloatLiteral");
        return floatLiteral;
    }


    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
