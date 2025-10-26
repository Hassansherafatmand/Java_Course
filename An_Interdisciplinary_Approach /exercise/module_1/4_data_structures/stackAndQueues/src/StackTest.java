import java.util.Scanner;
import princetonLibs.StdOut;

public class StackTest {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String word = input.next();
            if (!word.equals("-"))     stack.push(word);
            else if (stack.isEmpty())  StdOut.println("BAD INPUT");
            else                       StdOut.print(stack.pop() + " ");
        }

        System.out.println();
        System.out.println(stack.toString());
    }
}
