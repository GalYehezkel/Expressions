//ID: 315786228
/**
 * expression test.
 */
public class ExpressionsTest {
    /**
     * runs the test.
     * @param args input from user.
     * @throws Exception exp
     */
    public static void main(String[] args) throws Exception {
        try {
            Expression left, middle, right, e, ex, assignXye;
            left = new Mult(new Num(2), new Var("x"));
            middle = new Sin(new Mult(new Num(4), new Var("y")));
            right = new Pow(new Var("e"), new Var("x"));
            e = new Plus(left, new Plus(middle, right)); // create.
            System.out.println(e.toString()); // print the expression.
            assignXye = e.assign("x", new Num(2));
            assignXye = assignXye.assign("y", new Num(0.25));
            assignXye = assignXye.assign("e", new Num(2.71));
            System.out.println(assignXye.evaluate()); // print the value after assigment.
            ex = e.differentiate("x");
            System.out.println(ex.toString()); // print the differentiate of the expression.
            ex = ex.assign("x", new Num(2));
            ex = ex.assign("e", new Num(2.71));
            ex = ex.assign("y", new Num(0.25));
            System.out.println(ex.evaluate()); // print the value after assigment in differentiate.
            ex = e.differentiate("x").simplify();
            System.out.println(ex.toString()); // Print the simplified differentiated expression.
        } catch (Exception exp) {
            exp.printStackTrace();
    }
    }
}
