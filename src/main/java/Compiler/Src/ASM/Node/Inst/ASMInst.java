package Compiler.Src.ASM.Node.Inst;

import Compiler.Src.ASM.ASMVisitor;
import Compiler.Src.ASM.Node.ASMNode;

public abstract class ASMInst extends ASMNode {
    @Override
    public String toString() {
        return "";
    }

    @Override
    public <T> T accept(ASMVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
