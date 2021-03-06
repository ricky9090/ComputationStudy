package rickyxe.simple.operator;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XExpression;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.CastUtils.castXNumber;
import static rickyxe.simple.utils.XBuilder._Boolean;

public class XLessThan extends XExpression {

    private final XObject left;
    private final XObject right;

    public XLessThan(XObject left, XObject right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " < " + right.toString();
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        return _Boolean(
                castXNumber(left.evaluate(environment)).getValue()
                        < castXNumber(right.evaluate(environment)).getValue());
    }
}
