package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import java.util.ArrayList;

public class AspSuite extends AspSyntax{
    ArrayList<AspStmt> stmts = new ArrayList<>();

    AspSuite(int n) {
        super(n);
    }

    public static AspSuite parse(Scanner s) {
        Main.log.enterParser("suite");
        AspSuite suite = new AspSuite(s.curLineNum());

        skip(s, TokenKind.newLineToken);
        skip(s,TokenKind.indentToken);
        //suite.stmts.add(AspStmt.parse(s));
        while (true){
            suite.stmts.add(AspStmt.parse(s));
            System.out.println(suite.stmts.size());
            if (s.curToken().kind== TokenKind.dedentToken) break;
        }

        skip(s,TokenKind.dedentToken);

        Main.log.leaveParser("suite");
        return suite;
    }

    @Override
    public void prettyPrint() {
        Main.log.prettyWriteLn();
        Main.log.prettyIndent();
        System.out.println( "ok til here");

        for (AspStmt as: stmts) {
            as.prettyPrint();
        }

        System.out.println( "ok til here");
        Main.log.prettyDedent();

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
