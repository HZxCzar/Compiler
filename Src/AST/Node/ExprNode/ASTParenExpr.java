package Compile.Src.AST.Node.ExprNode;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import Compile.Src.Util.Info.ExprInfo;
import Compile.Src.AST.Node.Expr.ASTExpr;
import Compile.Src.Util.Info.*;
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public class ASTParenExpr extends ASTExpr {
    private final ASTExpr expr;
    @Override
    public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
        return visitor.visit(this);
    }
}
