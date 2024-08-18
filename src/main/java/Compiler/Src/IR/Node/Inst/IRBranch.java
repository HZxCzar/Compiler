package Compiler.Src.IR.Node.Inst;

import Compiler.Src.IR.IRVisitor;
import Compiler.Src.IR.Entity.IREntity;
import Compiler.Src.IR.Entity.IRVariable;
import Compiler.Src.IR.Node.util.IRLabel;
import Compiler.Src.Util.Error.BaseError;
import Compiler.Src.Util.ScopeUtil.GlobalScope;

@lombok.Getter
@lombok.Setter
public class IRBranch extends IRInst {
    private boolean isJump = false;
    private IREntity cond;
    private IRLabel trueLabel, falseLabel;

    public IRBranch(IREntity cond, IRLabel trueLabel, IRLabel falseLabel) {
        this.cond = cond;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
        this.isJump = false;
    }

    public IRBranch(IRLabel jumpLabel) {
        this.cond = new IRVariable(GlobalScope.irBoolType, "true");
        this.trueLabel = jumpLabel;
        this.falseLabel = jumpLabel;
        this.isJump = true;
    }

    @Override
    public <T> T accept(IRVisitor<T> visitor) throws BaseError {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        if(isJump) return "br label %" + trueLabel;
        return "br " + cond.toString() + ", label %" + trueLabel + ", label %" + falseLabel;
    }
}
