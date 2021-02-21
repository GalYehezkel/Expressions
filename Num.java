//ID: 315786228

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * An expression that represents number, contains double field.
 */
public class Num implements Expression {
    private double number;
    /**
     * constructor.
     *
     * @param num to assign in number.
     */
    public Num(double num) {
        this.number = num;
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
       return number;
    }
    /**
     *  A convenience method. Like the `evaluate(assignment)` method above,
     *   but uses an empty assignment.
     * @throws Exception exp
     * @return double
     */
    public double evaluate() throws Exception {
        return number;
    }
    /**
     * Returns a list of the variables in the expression.
     * @return List<String>
     */
    public List<String> getVariables() {
        return new LinkedList<String>();
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return String.valueOf(number);
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
         return this;
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        return new Num(0);
    }
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    public Expression simplify() {
        return this;
    }
}
