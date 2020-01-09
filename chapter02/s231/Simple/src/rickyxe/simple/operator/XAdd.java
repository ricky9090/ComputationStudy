package rickyxe.simple.operator;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XExpression;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.CastUtils.castXNumber;
import static rickyxe.simple.utils.XBuilder._Add;
import static rickyxe.simple.utils.XBuilder._Number;

public class XAdd extends XExpression {

    private final XObject left;
    private final XObject right;

    public XAdd(XObject left, XObject right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
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

        /**
         * 从左到右规约reduce
         */
        if (left.reducible()) {
            return _Add(
                    left.reduce(environment),
                    right);
        } else if (right.reducible()) {
            return _Add(
                    left,
                    right.reduce(environment));
        } else {
            return _Number(
                    castXNumber(left).getValue() + castXNumber(right).getValue());
        }
    }
}
