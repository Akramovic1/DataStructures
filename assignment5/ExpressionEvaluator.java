package eg.edu.alexu.csd.datastructure.stack.cs18010056;

public class ExpressionEvaluator implements IExpressionEvaluator {
    private MyStack stack;
    @Override
    public String infixToPostfix(final String infix) {
        String expression = infix;
        stack = new MyStack();
        int operator = 0;int operand = 0;int brackets = 0;
        int size = expression.length();
        StringBuilder oprString = new StringBuilder();
        //Check if there are any un supported sign.
        if (expression.contains("%") || expression.contains("&") || expression.contains("|") || expression.contains("!") || expression.contains("^"))
        { throw new RuntimeException("ERROR!,Wrong Expression"); }
        //Scan the infix expression from left to right.
        for (int i = 0; i < size; i++) {
            switch (expression.charAt(i)) {
                case '(': oprString.append(" ( "); break;
                case ')': oprString.append(" ) "); break;
                case '+': oprString.append(" + "); break;
                case '-': oprString.append(" - "); break;
                case '*': oprString.append(" * "); break;
                case '/': oprString.append(" / "); break;
                default:  oprString.append(expression.charAt(i)); }}
        expression = oprString.toString();
        expression = expression.trim(); //eliminating white spaces
        String[] array = expression.split(" "); //breaking with regex white space
        size = array.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (array[i].equals("")) { continue; }
            //If the character is “(“, then push it onto the operator stack.
            if (array[i].equals("(")) { brackets++; stack.push("("); }
            //If the character is “)”, then “pop out an operator from the stack and add it to the result until the corresponding “(“ is encountered in operator stack. Now just pop out the “(“.
            else if (array[i].equals(")")) { brackets--;
                if (brackets < 0) { throw new RuntimeException("ERROR !!"); }
                while (!stack.peek().equals("(")) { result.append(stack.pop().toString() + " "); }stack.pop(); }
            else if (array[i].equals("*") || array[i].equals("/")) {
                if (!stack.isEmpty()) { if (stack.peek().equals("*") || stack.peek().equals("/")) { result.append(stack.pop() + " "); } }
                stack.push(array[i]);
                operator++;}
            else if (array[i].equals("+") || array[i].equals("-")) {
                if (!stack.isEmpty()) { while (!stack.isEmpty() && !stack.peek().equals("(")) { result.append(stack.pop() + " ");} }
                operator++;
                stack.push(array[i]);}
            else { result.append(array[i] + " "); operand++; } }
        size = stack.size();
        for (int i = 0; i < size - 1; i++) { result.append(stack.pop() + " "); }
        if (!stack.isEmpty()) { result.append(stack.pop()); }
        if (brackets != 0 || operator + 1 != operand) { throw new RuntimeException("ERROR !!");}
        System.out.println(result.toString());
        return result.toString(); }

    @Override
    public int evaluate(final String infix) {
        String expression = infix;
        float FN = 0;float SN = 0; //the 2 no.
        stack = new MyStack();
        expression.trim(); //eliminating white spaces
        String[] array = expression.split(" "); //breaking with regex white space
        int num = array.length;
        //Push the first element in the array.
        stack.push(array[0]);
        for (int i = 1; i < num; i++) {
            switch (array[i]) {
                case "-":  FN = Float.parseFloat(stack.pop().toString()); SN = Float.parseFloat(stack.pop().toString()); stack.push(SN - FN); break;
                case "/":  FN = Float.parseFloat(stack.pop().toString()); SN = Float.parseFloat(stack.pop().toString());
                    if (FN == 0.0) { throw new RuntimeException("ERROR"); } //We can't divide by ZERO.
                    stack.push(SN / FN);break;
                case "+":  FN = Float.parseFloat(stack.pop().toString()); SN = Float.parseFloat(stack.pop().toString()); stack.push(SN + FN); break;
                case "*":  FN = Float.parseFloat(stack.pop().toString()); SN = Float.parseFloat(stack.pop().toString()); stack.push(SN * FN); break;
                default:  stack.push(array[i]); } }
        System.out.println(Float.parseFloat(stack.pop().toString()));
        return (int) Float.parseFloat(stack.pop().toString());
    }}

