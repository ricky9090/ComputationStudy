package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.CastUtils.castStatementRunner;
import static rickyxe.simple.utils.CastUtils.castXBoolean;
import static rickyxe.simple.utils.XBuilder._DoNothing;
import static rickyxe.simple.utils.XBuilder._StatementRunner;

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
    public XObject evaluate(XEnvironment environment) {
        XObject cond = condition.evaluate(environment);
        if (castXBoolean(cond).getValue()) {
            StatementRunner runner = castStatementRunner(body.evaluate(environment));
            return evaluate(runner.getEnvironment());
        } else {
            return _StatementRunner(
                    _DoNothing(),
                    environment
            );
        }
    }
}
