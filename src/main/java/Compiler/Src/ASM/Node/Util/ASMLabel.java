package Compiler.Src.ASM.Node.Util;

import Compiler.Src.ASM.ASMVisitor;
import Compiler.Src.ASM.Node.Inst.ASMInst;

@lombok.Getter
@lombok.Setter
public class ASMLabel extends ASMInst {
    private final String label;

    public ASMLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public <T> T accept(ASMVisitor<T> visitor) {
        return visitor.visit(this);
    }
}