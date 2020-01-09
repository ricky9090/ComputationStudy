package rickyxe.simple;

import rickyxe.simple.base.XObject;
import rickyxe.simple.statement.StatementRunner;

public class Machine {

    private XObject statement;
    private XEnvironment environment;

    public Machine(XObject statement, XEnvironment environment) {
        this.statement = statement;
        this.environment = environment;
    }

    public void step() {
        if (statement.reducible()) {
            StatementRunner wrapper = (StatementRunner) statement.reduce(environment);
            this.statement = wrapper.getStatement();
            this.environment = wrapper.getEnvironment();
        }
    }

    public void run() {
        while (statement.reducible()) {
            System.out.println(statement.inspect() + ", " + environment.inspect());
            step();
        }
        System.out.println(statement.inspect() + ", " + environment.inspect());
    }
}
