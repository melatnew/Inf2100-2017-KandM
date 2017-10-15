package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import static no.uio.ifi.asp.scanner.TokenKind.leftBracketToken;
import static no.uio.ifi.asp.scanner.TokenKind.leftParToken;

public abstract class AspPrimarySuffix extends AspSyntax{
    //static AspPrimarySuffix prSuffix = null;
    TokenKind tokenKind;
    AspPrimarySuffix(int n) {
        super(n);
    }

    public static AspPrimarySuffix parse(Scanner s) {
        AspPrimarySuffix prSuffix = null;
        Main.log.enterParser("primary suffix");
        //
        if(s.curToken().kind == leftBracketToken){
            prSuffix = AspSubscription.parse(s);
        }else if(s.curToken().kind == leftParToken){
            prSuffix = AspArguments.parse(s);
        }

        Main.log.leaveParser("primary suffix");
        return prSuffix;
    }


}
