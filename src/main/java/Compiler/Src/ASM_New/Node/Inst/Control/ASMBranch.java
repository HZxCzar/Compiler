package Compiler.Src.ASM_New.Node.Inst.Control;

import java.util.ArrayList;

import Compiler.Src.ASM_New.Node.Stmt.ASMBlock;
import Compiler.Src.ASM_New.ASMVisitor;
import Compiler.Src.ASM_New.Entity.ASMReg;
import Compiler.Src.ASM_New.Entity.ASMVirtualReg;
import Compiler.Src.ASM_New.Node.Inst.ASMInst;
import Compiler.Src.Util.Error.ASMError;

@lombok.Getter
@lombok.Setter
public class ASMBranch extends ASMInst {
    private ASMReg cond;
    private String label;

    public ASMBranch(int id,ASMBlock parent,ASMReg cond,String label) {
        super(id, parent);
        this.cond = cond;
        this.label = label;
    }

    @Override
    public String toString() {
        throw new ASMError("Branch instruction should not be printed");
    }
    @Override
    public <T> T accept(ASMVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void setDest(ASMReg reg) {
        return;
    }

    @Override
    public ASMReg getDef() {
        return null;
    }

    @Override
    public ArrayList<ASMReg> getUses() {
        var ret = new ArrayList<ASMReg>();
        return ret;
    }

    @Override
    public void replaceUse(ASMReg oldReg, ASMReg newReg) {
        if (cond.equals(oldReg)) {
            cond = newReg;
        }
    }
}
