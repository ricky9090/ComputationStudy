package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.XBuilder.*;

public class XWhile extends XStatement {

    private XObject condition;
    private XObject body;

    public XWhile(XObject condition, XObject body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toString() {
        return "while (" + condition.toString() + ") { "
                + body.toString() + " }";
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

        XIf equivalence = _If(
                condition, _Sequence(body, this), _DoNothing()
        );
        StatementRunner wrapper = new StatementRunner(equivalence, environment);
        return wrapper;
    }
}
