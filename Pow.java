//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An expression that represents power.
 * extends BinaryExpression.
 */
public class Pow extends BinaryExpression {
    /**
     * constructor.
     *
     * @param e1 first expression in BinaryExpresion.
     * @param e2 second expression in BinaryExpresion.
     */
    public Pow(Expression e1, Expression e2) {
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
        double result1 = getE1().evaluate(assignment);
        double result2 = getE2().evaluate(assignment);
        if (result1 < 0 && result2 > 0 && result2 < 1) {
            throw new Exception("can't calculate, power is between 0-1 and and the number is negative");
        }
        return Math.pow(getE1().evaluate(assignment), getE2().evaluate(assignment));
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return "(" + getE1().toString() + "^" + getE2().toString() + ")";
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
        return new Pow(getE1().assign(var, expression), getE2().assign(var, expression));
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        Pow fIng = new Pow(getE1(), getE2());
        Mult ftaggDivf = new Mult(getE1().differentiate(var), new Div(getE2(), getE1()));
        Mult gtaglnf = new Mult(getE2().differentiate(var), new Log(new Var("e"), getE1()));
        return new Mult(fIng, new Plus(ftaggDivf, gtaglnf));
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        Expression temp1 = getE1().simplify();
        Expression temp2 = getE2().simplify();
        Pow p = new Pow(temp1, temp2);
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
