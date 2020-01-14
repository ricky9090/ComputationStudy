package rickyxe.dfa;

public class FARule {

    private FAState mState;
    private char mCharacter;
    private FAState mNextState;

    public FARule(FAState state, char character, FAState nextState) {
        this.mState = state;
        this.mCharacter = character;
        this.mNextState = nextState;
    }

    public boolean appliesTo(FAState state, char character) {
        return mState.equals(state) && mCharacter == character;
    }

    public FAState follow() {
        return mNextState;
    }
}
