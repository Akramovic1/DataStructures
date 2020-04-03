package eg.edu.alexu.csd.datastructure.stack.cs18010056;
import java.util.Scanner;

public class ExpEvMain {
    public static void main(final String[] args) {
        ExpressionEvaluator str = new ExpressionEvaluator();
        Scanner inputs = new Scanner(System.in);String a;String operation;
        try {
            System.out.println("Please, enter the elements :  ");
            a = inputs.nextLine();
            boolean flag = false;
            int len = a.length();
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) == '/') { flag = true; }
                else {
                    if (flag && a.charAt(i) == '0') { System.out.println("Error");inputs.close(); return; }
                    flag = false; } }
            operation = str.infixToPostfix(a);
            System.out.println(str.evaluate(operation));
            System.out.println(operation);}
        catch (RuntimeException ex) { System.out.println("Error Stack");inputs.close(); }}
}
