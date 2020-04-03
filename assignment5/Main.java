package eg.edu.alexu.csd.datastructure.stack.cs18010056;
import java.util.Scanner;
public class Main {
    public static void main(final String[] args) {
        ExpressionEvaluator str = new ExpressionEvaluator();
        MyStack st = new MyStack();
        while (true) {
            System.out.println("Choose an action");
            System.out.println("1-Push\n" + "2-Pop\n" + "3-Peek\n" + "4-Get size\n" + "5-Check if empty\n" + "6-InfixToPostfix\n" +"7-Exit\n");
            Scanner scan = new Scanner(System.in);
            int req ; req = scan.nextInt();
            if (req == 1) { System.out.println("Please enter the element\n");st.push(scan.next());
            } else if (req == 2) { System.out.println("the element is:\n");System.out.println(st.pop());
            } else if (req == 3) { System.out.println("the top element is:\n");System.out.println(st.peek());
            } else if (req == 4) { System.out.println("the stack size is:\n");System.out.println(st.size());
            } else if (req == 5) { if (st.isEmpty()) { System.out.println("Stack is empty\n"); } else { System.out.println("Stack is not empty\n"); }
            } else if (req == 6) { System.out.println("Please enter the elements\n") ;str.infixToPostfix(scan.next());break;
            } else if (req == 7) { break;
            } else { System.out.print("ERROR! ,please choose the correct function\n"); }
        }}}