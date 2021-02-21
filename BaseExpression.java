//ID: 315786228

import java.util.HashMap;
/**
 * An expression that represents base expression.
 */
public abstract class BaseExpression implements Expression {
    /**
     *  A convenience method. Like the `evaluate(assignment)` method above,
     *   but uses an empty assignment.
     * @throws Exception exp
     * @return double
     */
    public double evaluate() throws Exception {
        return evaluate(new HashMap<String, Double>());
    }
}
