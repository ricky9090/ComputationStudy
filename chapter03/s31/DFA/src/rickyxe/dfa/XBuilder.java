package rickyxe.dfa;

import java.util.Arrays;
import java.util.List;

public class XBuilder {

    public static FAState _FAState(int state) {
        return new FAState(state);
    }

    public static FARule _FARule(FAState state, char character, FAState nextState) {
        return new FARule(state, character, nextState);
    }

    public static DFARulebook _DFARulebook(FARule... rules) {
        return new DFARulebook(Arrays.asList(rules));
    }

    public static List<FAState> _acceptStates(FAState ... states) {
        return Arrays.asList(states);
    }

    public static DFA _DFA(FAState currentState, List<FAState> acceptStates, DFARulebook rulebook) {
        return new DFA(currentState, acceptStates, rulebook);
    }

    public static DFADesign _DFADesign(FAState currentState, List<FAState> acceptStates, DFARulebook rulebook) {
        return new DFADesign(currentState, acceptStates, rulebook);
    }
}
