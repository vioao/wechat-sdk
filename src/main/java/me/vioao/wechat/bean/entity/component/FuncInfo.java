package me.vioao.wechat.bean.entity.component;

/**
 * 公众号授权给开发者的权限集列表.
 *
 * @author vioao
 */
public class FuncInfo {
    private FuncScopeCategory funcScopeCategory;
    private ConfirmInfo confirmInfo;

    public FuncScopeCategory getFuncScopeCategory() {
        return funcScopeCategory;
    }

    public void setFuncScopeCategory(FuncScopeCategory funcScopeCategory) {
        this.funcScopeCategory = funcScopeCategory;
    }

    public ConfirmInfo getConfirmInfo() {
        return confirmInfo;
    }

    public void setConfirmInfo(ConfirmInfo confirmInfo) {
        this.confirmInfo = confirmInfo;
    }

    @Override
    public String toString() {
        return "FuncInfo{" +
                "funcScopeCategory=" + funcScopeCategory +
                ", confirmInfo=" + confirmInfo +
                '}';
    }
}

