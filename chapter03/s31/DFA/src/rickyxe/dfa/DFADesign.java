package rickyxe.dfa;

import java.util.List;

import static rickyxe.dfa.XBuilder._DFA;


/**
 * DFA 匹配规则后，就无法还原初始状态了。因此创建一个类来生成初始状态的DFA
 */
public class DFADesign {

    private FAState startState;
    private List<FAState> acceptStates;
    private DFARulebook rulebook;

    public DFADesign(FAState startState, List<FAState> acceptStates, DFARulebook rulebook) {
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.rulebook = rulebook;
    }

    /**
     * 以传入的参数生成DFA
     *
     * @param startState 起始状态
     * @param acceptStates 可接收状态
     * @param rulebook 规则表
     * @return 初始状态DFA
     */
    private DFA toDFA(FAState startState, List<FAState> acceptStates, DFARulebook rulebook) {
        return _DFA(startState, acceptStates, rulebook);
    }

    /**
     * 构建DFA，读取字符串，返回是否在accept状态
     * @param str 目标字符串
     * @return accept? true or false
     */
    public boolean accepts(String str) {
        DFA dfa = toDFA(startState, acceptStates, rulebook);
        dfa.readString(str);
        return dfa.accepting();
    }
}
