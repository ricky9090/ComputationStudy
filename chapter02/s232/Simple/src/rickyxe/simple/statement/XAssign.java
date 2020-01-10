package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.base.XStatement;
import rickyxe.simple.basictype.XVariable;

import static rickyxe.simple.utils.XBuilder.*;

public class XAssign extends XStatement {

    private final XVariable variable;
    private final XObject expression;

    public XAssign(XVariable name, XObject expression) {
        this.variable = name;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return variable + " = " + expression;
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        XEnvironment updateEnv = _Environment();
        updateEnv.put(variable.toString(), expression.evaluate(environment));
        return _StatementRunner(
                _DoNothing(),
                environment.merge(updateEnv));
    }
}
