package Compiler.Src.OPT;

import Compiler.Src.IR.Node.IRRoot;

public class IROptimize {
    public void visit(IRRoot root)
    {
        new CFGBuilder().visit(root);
        return;
    }
}
