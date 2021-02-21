//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An expression that represents Divide.
 * extends BinaryExpression.
 */
public class Div extends BinaryExpression {
    /**
     * constructor.
     *
     * @param e1 first expression in BinaryExpresion.
     * @param e2 second expression in BinaryExpresion.
     */
    public Div(Expression e1, Expression e2) {
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
        double result = getE2().evaluate(assignment);
        if (result != 0) { //check if not zero.
            return getE1().evaluate(assignment) / getE2().evaluate(assignment);
        } else {
            throw new Exception("can't divide in zero!");
        }
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return "(" + getE1().toString() + " / " + getE2().toString() + ")";
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
        return new Div(getE1().assign(var, expression), getE2().assign(var, expression));
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        return new Div(new Minus(new Mult(getE1().differentiate(var), getE2()),
                new Mult(getE1(), getE2().differentiate(var))), new Pow(getE2(), new Num(2)));
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        Expression temp1 = getE1().simplify();
        Expression temp2 = getE2().simplify();
        Div p = new Div(temp1, temp2);
        List<String> ls = p.getVariables();
        if (temp1.toString().equals(temp2.toString()) && !temp1.toString().equals("0.0")) { // X / X = 1.
            return new Num(1);
        } else if (temp2.toString().equals("1.0")) { // X / 1 = X.
            return temp1;
        } else if (ls.isEmpty()) {
            try {
                return new Num(p.evaluate());
            } catch (Exception exp) {
                return p;
            }
        }
        return p;
    }
}
