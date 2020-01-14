package rickyxe.dfa;

/**
 * 将 int 型的 state 包装一下，方便调用
 */
public class FAState implements Inspectable {

    private int state;

    public FAState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return state + "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FAState) {
            return ((FAState) obj).getState() == this.state;
        } else {
            return false;
        }
    }

    @Override
    public String inspect() {
        return "[" + state + "]";
    }
}
