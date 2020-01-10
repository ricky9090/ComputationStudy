package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.XBuilder._StatementRunner;

public class XDoNothing extends XStatement {

    @Override
    public String toString() {
        return "do-nothing";
    }

    @Override
    public boolean equals(Object otherStatement) {
        return otherStatement instanceof XDoNothing;
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        return _StatementRunner(this, environment);
    }
}
