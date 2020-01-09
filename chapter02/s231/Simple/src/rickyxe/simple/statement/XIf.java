package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.CastUtils.castXBoolean;
import static rickyxe.simple.utils.XBuilder._If;
import static rickyxe.simple.utils.XBuilder._StatementRunner;

public class XIf extends XStatement {

    private XObject condition;
    private XObject consequence;
    private XObject alternative;

    public XIf(XObject condition, XObject consequence, XObject alternative) {
        this.condition = condition;
        this.consequence = consequence;
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "if ( " + condition.toString() + " ) { "
                + consequence.toString() + " } else { "
                + alternative.toString() + " }";
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

        if (condition.reducible()) {
            return _StatementRunner(
                    _If(condition.reduce(environment), consequence, alternative),
                    environment);
        } else {
            if (castXBoolean(condition).getValue()) {
                return _StatementRunner(consequence, environment);
            } else {
                return _StatementRunner(alternative, environment);
            }

        }
    }
}
