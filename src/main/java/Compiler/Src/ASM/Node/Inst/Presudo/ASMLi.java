package Compiler.Src.ASM.Node.Inst.Presudo;

import java.util.ArrayList;

import Compiler.Src.ASM.ASMVisitor;
import Compiler.Src.ASM.Entity.ASMReg;
import Compiler.Src.ASM.Entity.ASMVirtualReg;
import Compiler.Src.ASM.Node.Inst.ASMInst;

@lombok.Getter
@lombok.Setter
public class ASMLi extends ASMInst {
    private ASMReg dest;
    private int imm;

    public ASMLi(ASMReg dest, int imm) {
        this.dest = dest;
        this.imm = imm;
    }

    @Override
    public String toString() {
        String str = "li " + dest.toString() + ", " + imm;
        return str;
    }

    @Override
    public <T> T accept(ASMVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public ASMVirtualReg getDef() {
        if (dest instanceof ASMVirtualReg) {
            return (ASMVirtualReg) dest;
        }
        return null;
    }

    @Override
    public ArrayList<ASMVirtualReg> getUses() {
        var ret = new ArrayList<ASMVirtualReg>();
        return ret;
    }
}
