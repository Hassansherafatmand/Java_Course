import java.util.Scanner;

public class Parentheses {
    public static void main(String[] args) {
        Stack<String> symbols = new Stack<String>();
        
        boolean flag = true;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string with symbols (), {}, []: ");
        String line = input.nextLine();
        input.close();
        
//        char fchar = line.charAt(0); System.out.println(fchar); // first character of a string
//        String x = String.valueOf(fchar); System.out.println(x);  // convert the char to string
        

        // check the each character in the string
        for (int i = 0; i < line.length(); i++) {
  
            char c = line.charAt(i);
            String s = String.valueOf(c);
            

            if (s.equals("(") || s.equals("[") || s.equals("{")) {
                symbols.push(s);
            } 
            else if (s.equals(")") || s.equals("]") || s.equals("}")) {
                if (symbols.isEmpty()) {
                    flag = false;
                    break;
                }

                String open = symbols.pop();

                if ((s.equals(")") && !open.equals("(")) ||
                    (s.equals("]") && !open.equals("[")) ||
                    (s.equals("}") && !open.equals("{"))) {
                    flag = false;
                    break;
                }
            }
        }

        if (!symbols.isEmpty()) flag = false;

        System.out.println(flag);
        
        
    }
}
