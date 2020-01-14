package rickyxe.dfa;

import java.util.List;

/**
 * 保存DFA的规则列表
 */
public class DFARulebook {

    private final List<FARule> rules;

    public DFARulebook(List<FARule> rules) {
        this.rules = rules;
    }

    /**
     * 搜索规则，匹配则返回下一个状态
     *
     * @param state     当前状态
     * @param character 接收的字符
     * @return 下一个状态
     */
    public FAState nextState(FAState state, char character) {
        FARule target = ruleFor(state, character);
        // 当没有匹配到规则时，下面的调用将引起 NullPointer
        return target.follow();
    }

    private FARule ruleFor(FAState state, char character) {
        FARule target = null;
        for (FARule rule : rules) {
            if (rule.appliesTo(state, character)) {
                target = rule;
                break;
            }
        }
        return target;
    }
}
