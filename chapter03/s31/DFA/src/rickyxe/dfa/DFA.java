package rickyxe.dfa;

import java.util.List;

public class DFA {

    private FAState currentState;
    private List<FAState> acceptStates;
    private DFARulebook rulebook;

    public DFA(FAState currentState, List<FAState> acceptStates, DFARulebook rulebook) {
        this.currentState = currentState;
        this.acceptStates = acceptStates;
        this.rulebook = rulebook;
    }

    public boolean accepting() {
        return acceptStates.contains(currentState);
    }

    public void readCharacter(char character) {
        this.currentState = rulebook.nextState(currentState, character);
    }

    public void readString(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        for (char character : chars) {
            this.currentState = rulebook.nextState(currentState, character);
        }
    }
}
