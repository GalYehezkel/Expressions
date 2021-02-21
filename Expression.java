//ID: 315786228

import java.util.List;
import java.util.Map;
/**
 * An interface that represents expression.
 */
public interface Expression {
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
    double evaluate(Map<String, Double> assignment) throws Exception;
    /**
     *  A convenience method. Like the `evaluate(assignment)` method above,
     *   but uses an empty assignment.
     * @throws Exception exp
     * @return double
     */
    double evaluate() throws Exception;
    /**
     * Returns a list of the variables in the expression.
     * @return List<String>
     */
    List<String> getVariables();
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    String toString();
    /**
     * Returns a new expression in which all occurrences of the variable
     *  var are replaced with the provided expression (Does not modify the
     *  current expression).
     * @param var the variable to assign in.
     * @param expression the expression to replace with.
     * @return Expression
     */
    Expression assign(String var, Expression expression);
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    Expression differentiate(String var);
    /**
     *   Returned a simplified version of the current expression.
     * @return Expression
     */
    Expression simplify();
}