//ID: 315786228

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * An expression that represents variable, contains String.
 */
public class Var implements Expression {
    private String variable;
    /**
     * constructor.
     *
     * @param var to assign in variable.
     */
    public Var(String var) {
        this.variable = var;
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
        if (assignment.containsKey(variable)) { // check if variable in map.
            return assignment.get(variable); // return the value.
        } else if (variable.equals("e")) { // assign for e.
            return Math.E;
        } else if (variable.equals("Pi")) { // assign for Pi.
            return Math.PI;
        } else {
            throw new Exception("variable doesn't exists in map");
        }
    }
    /**
     *  A convenience method. Like the `evaluate(assignment)` method above,
     *   but uses an empty assignment.
     * @throws Exception exp
     * @return double
     */
    public double evaluate() throws Exception {
        throw new Exception("variable doesn't exists, no map supplied");
    }
    /**
     * Returns a list of the variables in the expression.
     * @return List<String>
     */
    public List<String> getVariables() {
        List<String> ls = new LinkedList<String>();
        ls.add(variable);
        return ls;
    }
    /**
     * Returns a nice string representation of the expression.
     * @return String
     */
    public String toString() {
        return variable;
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
        if (this.variable.equals(var)) {
            return expression;
        }
        return this;
    }
    /**
     *  Returns the expression tree resulting from differentiating
     *  the current expression relative to variable `var`.
     * @param var the variable for differentiate with.
     * @return Expression
     */
    public Expression differentiate(String var) {
        if (var.equals(this.variable)) {
            return new Num(1);
        }
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
