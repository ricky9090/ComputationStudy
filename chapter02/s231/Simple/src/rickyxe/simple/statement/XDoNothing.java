package rickyxe.simple.statement;

import rickyxe.simple.base.XStatement;

public class XDoNothing extends XStatement {

    @Override
    public String toString() {
        return "do-nothing";
    }

    @Override
    public boolean equals(Object otherStatement) {
        return otherStatement instanceof XDoNothing;
    }
}
