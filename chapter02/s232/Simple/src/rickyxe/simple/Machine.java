package rickyxe.simple;

import rickyxe.simple.base.XObject;
import rickyxe.simple.statement.StatementRunner;
import rickyxe.simple.statement.XDoNothing;

public class Machine {

    private XObject statement;
    private XEnvironment environment;

    public Machine(XObject statement, XEnvironment environment) {
        this.statement = statement;
        this.environment = environment;
    }

    public void step() {
            StatementRunner wrapper = (StatementRunner) statement.evaluate(environment);
            this.statement = wrapper.getStatement();
            this.environment = wrapper.getEnvironment();
    }

    public void run() {
        while (!(statement instanceof XDoNothing)) {
            System.out.println(statement.inspect() + ", " + environment.inspect());
            step();
        }
        System.out.println(statement.inspect() + ", " + environment.inspect());
    }
}
