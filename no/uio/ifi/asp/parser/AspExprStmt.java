package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;

import static no.uio.ifi.asp.scanner.TokenKind.eofToken;
import static no.uio.ifi.asp.scanner.TokenKind.newLineToken;


public class AspExprStmt extends AspStmt{
    AspExpr expr;

    public AspExprStmt(int i) {
        super(i);
    }

    public static AspExprStmt parse(Scanner s) {
        Main.log.enterParser("AspExprStmt");
        AspExprStmt exprStmt = new AspExprStmt(s.curLineNum());
        exprStmt.expr = AspExpr.parse(s);
        skip(s, newLineToken);
        Main.log.leaveParser("AspExprStmt");
        return exprStmt;
    }

}
