package rickyxe.simple.statement;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

public class StatementRunner extends XObject {

    private XObject statement;
    private XEnvironment environment;

    public StatementRunner(XObject statement, XEnvironment environment) {
        this.statement = statement;
        this.environment = environment;
    }

    public XObject getStatement() {
        return statement;
    }

    public XEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public String inspect() {
        return environment.inspect();
    }
}
