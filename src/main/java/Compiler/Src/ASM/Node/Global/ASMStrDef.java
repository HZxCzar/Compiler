package Compiler.Src.ASM.Node.Global;

import Compiler.Src.ASM.Node.ASMNode;

@lombok.Getter
@lombok.Setter
public class ASMStrDef extends ASMNode{
    private String name;
    private String value;
    
    public ASMStrDef(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "";
    }
}