package Compile.Src.AST.Node.StatementNode;

import AST.ASTNode;
import AST.ASTVisitor;
import Compile.Src.Util.Info.StmtInfo;
import Compile.Src.Util.Scope.*;
import Compile.Src.AST.Node.Expr.ASTExpr;
import Compile.Src.AST.Node.Statement.ASTStatement;
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public class ASTForstatement extends ASTStatement {
    private LoopScope scope;
    private final ASTVarstatement Varinit;
    private final ASTExpr Exprinit,cond,step;
    private final ASTStatement stmts;
    @Override
    public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
        return visitor.visit(this);
    }
}
