package Compiler.Src.IR.Node.Inst;

import Compiler.Src.IR.IRVisitor;
import Compiler.Src.IR.Entity.IRVariable;
import Compiler.Src.IR.Type.IRType;
import Compiler.Src.Util.Error.BaseError;

@lombok.Getter
@lombok.Setter
public class IRSelect extends IRInst {
    private IRVariable dest;
    private String cond;
    private IRType ty1,ty2;
    private IRVariable val1,val2;

    public IRSelect(IRVariable dest, String cond, IRType ty1, IRVariable val1, IRType ty2, IRVariable val2) {
        this.dest = dest;
        this.cond = cond;
        this.ty1 = ty1;
        this.val1 = val1;
        this.ty2 = ty2;
        this.val2 = val2;
    }
    @Override
    public <T> T accept(IRVisitor<T> visitor) throws BaseError {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return dest.getValue() + " = select i1 " + cond + " " + ty1.toString() + " " + val1.getValue() + ", " + ty2.toString() + " " + val2.getValue();
    }
}
