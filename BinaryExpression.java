//ID: 315786228

import java.util.LinkedList;
import java.util.List;
/**
 * An expression that represents binary expression, contains two expressions.
 * extends BaseExpression.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression e1;
    private Expression e2;
    /**
     * constructor.
     *
     * @param e1 first expression.
     * @param e2 second expression.
     */
    public BinaryExpression(Expression e1, Expression e2) {
        super();
        this.e1 = e1;
        this.e2 = e2;
    }
    /**
     * get first expression.
     *
     * @return e1 first expression.
     */
    public Expression getE1() {
        return e1;
    }
    /**
     * get second expression.
     *
     * @return e2 second expression.
     */
    public Expression getE2() {
        return e2;
    }
    /**
     * Returns a list of the variables in the expression.
     * @return List<String>
     */
    public List<String> getVariables() {
        List<String> ls = new LinkedList<String>();
        ls.addAll(e1.getVariables()); // adds variables of expressions 1 and 2 to the list.
        ls.addAll(e2.getVariables());
        return ls;
    }
}
