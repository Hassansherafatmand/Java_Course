import princetonLibs.*;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> operators = new Stack<String>();   // for +, -, *, /, sqrt
        Stack<Double> values    = new Stack<Double>();   // for numbers

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if      (s.equals("("))                     ;  // ignore left parenthesis
            else if (s.equals("+"))    operators.push(s);
            else if (s.equals("-"))    operators.push(s);
            else if (s.equals("*"))    operators.push(s);
            else if (s.equals("/"))    operators.push(s);
            else if (s.equals("sqrt")) operators.push(s);

            else if (s.equals(")")) {
                // pop operator
                String operator = operators.pop();

                // pop one value
                double v = values.pop();

                // apply operator
                if      (operator.equals("+"))    v = values.pop() + v;
                else if (operator.equals("-"))    v = values.pop() - v;
                else if (operator.equals("*"))    v = values.pop() * v;
                else if (operator.equals("/"))    v = values.pop() / v;
                else if (operator.equals("sqrt")) v = Math.sqrt(v);

                // push the result
                values.push(v);
            }

            // if it's a number, push to value stack
            else values.push(Double.parseDouble(s));
        }

        // print the final result
        StdOut.println(values.pop());
    }
}
