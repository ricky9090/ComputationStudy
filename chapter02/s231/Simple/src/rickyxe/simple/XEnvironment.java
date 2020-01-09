package rickyxe.simple;

import rickyxe.simple.attr.Inspectable;
import rickyxe.simple.base.XObject;
import rickyxe.simple.basictype.XVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static rickyxe.simple.utils.XBuilder._Environment;
import static rickyxe.simple.utils.XBuilder._Variable;

public class XEnvironment implements Inspectable {

    private Map<String, XObject> environment;

    public XEnvironment() {
        environment = new HashMap<>();
    }

    public XEnvironment(Map<String, XObject> environment) {
        this.environment = environment;
    }

    public void put(String name, XObject obj) {
        if (environment == null) {
            return;
        }

        environment.put(name, obj);
    }

    public XObject get(String name) {
        if (environment == null) {
            return null;
        }

        return environment.get(name);
    }

    /**
     * 在当前环境中创建变量，已String作为变量名称
     * @param name
     * @param value
     * @return
     */
    public XVariable createVariable(String name, XObject value) {
        if (environment == null) {
            return null;
        }

        XVariable variable = _Variable(name);
        put(name, value);
        return variable;
    }

    public Map<String, XObject> getMap() {
        return environment;
    }

    /**
     * 合并新旧执行环境
     */
    public XEnvironment merge(XEnvironment updateEnv) {
        XEnvironment env = _Environment();

        Map<String, XObject> current = this.getMap();
        Map<String, XObject> update = updateEnv.getMap();

        env.getMap().putAll(current);
        env.getMap().putAll(update);

        return env;
    }

    @Override
    public String toString() {
        if (environment == null) {
            return "{ }";
        }
        String result = "{ ";
        Set<Map.Entry<String, XObject>> entrySet = environment.entrySet();
        for (Map.Entry<String, XObject> entry : entrySet) {
            result = result + entry.getKey() + "=>" + entry.getValue().inspect() + ", ";
        }
        result = result + "}";

        return result;
    }

    @Override
    public String inspect() {
        return this.toString();
    }
}
