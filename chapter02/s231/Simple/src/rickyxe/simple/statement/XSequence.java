package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.XBuilder._Sequence;
import static rickyxe.simple.utils.XBuilder._StatementRunner;

public class XSequence extends XStatement {

    private XObject first;
    private XObject second;

    public XSequence(XObject first, XObject second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + "; " + second.toString();
    }

    @Override
    public boolean reducible() {
        return true;
    }

    @Override
    public XObject reduce(XEnvironment environment) {
        if (environment == null) {
            return null;
        }

        if (first instanceof XDoNothing) {
            return _StatementRunner(second, environment);
        } else {
            StatementRunner wrapper = (StatementRunner) first.reduce(environment);
            XSequence updateSequence = _Sequence(wrapper.getStatement(), second);
            return _StatementRunner(updateSequence, wrapper.getEnvironment());
        }
    }
}
