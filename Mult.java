//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An expression that represents multiplication.
 * extends BinaryExpression.
 */
public class Mult extends BinaryExpression {
    /**
     * constructor.
     *
     * @param e1 first expression in BinaryExpresion.
     * @param e2 second expression in BinaryExpresion.
     */
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
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
        return getE1().evaluate(assignment) * getE2().evaluate(assignment);
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return "(" + getE1().toString() + " * " + getE2().toString() + ")";
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
        return new Mult(getE1().assign(var, expression), getE2().assign(var, expression));
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        return new Plus(new Mult(getE1().differentiate(var), getE2()), new Mult(getE1(), getE2().differentiate(var)));
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        Expression temp1 = getE1().simplify();
        Expression temp2 = getE2().simplify();
        Mult p = new Mult(temp1, temp2);
        List<String> ls = p.getVariables();
        if (temp1.toString().equals("1.0")) { // 1 * X = X.
            return temp2;
        } else if (temp2.toString().equals("1.0")) { // X * 1 = X.
            return temp1;
        } else if (temp1.toString().equals("0.0") || (temp2.toString().equals("0.0"))) { // X * 0 = 0.
            return new Num(0);
        } else if (ls.isEmpty()) {
            try {
                return new Num(p.evaluate());
            } catch (Exception exp) {
                return p;
            }
        } else {
            return p;
        }
    }
}
