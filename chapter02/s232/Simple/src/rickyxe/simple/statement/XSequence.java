package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.CastUtils.castStatementRunner;

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
    public XObject evaluate(XEnvironment environment) {
        XObject r = first.evaluate(environment);
        return second.evaluate(castStatementRunner(r).getEnvironment());
    }
}
