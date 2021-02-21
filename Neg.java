//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An expression that represents negative.
 * extends UnaryExpression.
 */
public class Neg extends UnaryExpression {
    /**
     * constructor.
     *
     * @param e to assign in UnaryExpression.
     */
    public Neg(Expression e) {
        super(e);
    }
    /**
     * Evaluate the expression using the variable values provided
     *  in the assignment, and return the result.  If the expression
     *  contains a variable which is not in the assignment, an exception
     *  is thrown.
     *
     * @param assignment map
     * @throws Exception exp
     * @return double
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return getE().evaluate(assignment) * (-1);
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return "(-" + getE().toString() + ")";
    }
    /**
     * Returns a new expression in which all occurrences of the variable
     *  var are replaced with the provided expression (Does not modify the
     *  current expression).
     * @param var the variable to assign in.
     * @param expression the expression to replace with.
     * @return Expression
     */
    public Expression assign(String var, Expression expression) {
        return new Neg(getE().assign(var, expression));
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        return new Neg(getE().differentiate(var));
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        Expression temp = getE().simplify();
        Neg p = new Neg(temp);
        List<String> ls = p.getVariables();
        if (ls.isEmpty()) {
            try {
                return new Num(p.evaluate());
            } catch (Exception exp) {
                return p;
            }
        }
        return p;
    }
}
