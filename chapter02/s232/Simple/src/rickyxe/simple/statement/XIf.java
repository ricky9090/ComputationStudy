package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;

import static rickyxe.simple.utils.CastUtils.castXBoolean;

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
    public XObject evaluate(XEnvironment environment) {
        XObject r = condition.evaluate(environment);
        if (castXBoolean(r).getValue()) {
            return consequence.evaluate(environment);
        } else {
            return alternative.evaluate(environment);
        }
    }
}
