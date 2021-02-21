//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An expression that represents Log.
 * extends BinaryExpression.
 */
public class Log extends BinaryExpression {
    /**
     * constructor.
     *
     * @param e1 first expression in BinaryExpresion.
     * @param e2 second expression in BinaryExpresion.
     */
    public Log(Expression e1, Expression e2) {
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
        if (result2 <= 0) {
            throw new Exception("zero and less can't be put in log");
        } else if (result1 == 1 || result1 <= 0) {
            throw new Exception("one, zero and less can't be base in log");
        }
        return  Math.log(getE2().evaluate(assignment)) /  Math.log(getE1().evaluate(assignment));
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return "log" + "(" + getE1().toString() + ", " + getE2().toString() + ")";
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
        return new Log(getE1().assign(var, expression), getE2().assign(var, expression));
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        //e1 f, e2 g
        Div left = new Div(new Mult(new Log(new Var("e"), getE1()), getE2().differentiate(var)), getE2());
        Div right = new Div(new Mult(new Log(new Var("e"), getE2()), getE1().differentiate(var)), getE1());
        Pow down = new Pow(new Log(new Var("e"), getE1()), new Num(2));
        return new Div(new Minus(left, right), down);
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        Expression temp1 = getE1().simplify();
        Expression temp2 = getE2().simplify();
        Log p = new Log(temp1, temp2);
        List<String> ls = p.getVariables();
        if (temp1.toString().equals(temp2.toString())) { // log(x, x) = 1.
           return new Num(1);
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
