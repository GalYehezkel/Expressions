//ID: 315786228

import java.util.LinkedList;
import java.util.List;
/**
 * An expression that represents unary expression, contains one expression.
 * extends BaseExpression.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression e;
    /**
     * constructor.
     *
     * @param e expression.
     */
    public UnaryExpression(Expression e) {
        super();
        this.e = e;
    }
    /**
     * get expression.
     *
     * @return e1 first expression.
     */
    public Expression getE() {
        return e;
    }
    /**
     * Returns a list of the variables in the expression.
     * @return List<String>
     */
    public List<String> getVariables() {
        List<String> ls = new LinkedList<String>();
        ls.addAll(e.getVariables());
        return ls;
    }
}
