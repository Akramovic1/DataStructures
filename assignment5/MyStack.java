package eg.edu.alexu.csd.datastructure.stack.cs18010056;

public class MyStack implements IStack {
    private int size; private Node head; private Node cur;
    public MyStack() {
        head = null;
        cur = head;
        size = 0; }

    public void add(final int a, final Object element) {
        if (a > size || element == null || a < 0) { throw new RuntimeException("Check your inputs");}
        int a1 = size - a;
        Node newElement = new Node(element);
        if (head == null) { head = newElement; }
        else if (a1 == 0) { newElement.next = head; head = newElement; }
        else { cur = head;
            for (int i = 1; i < a1; i++) { cur = cur.next; }
            newElement.next = cur.next;
            cur.next = newElement; }
        size++; }

    @Override
    public Object pop() {
        if (isEmpty()) { throw new RuntimeException("Stack is empty"); }
        Object poped = head.value;
        head = head.next;
        size--;
        return poped; }

    @Override
    public Object peek() {
        if (isEmpty()) { throw new RuntimeException("Stack is Empty");}
        return head.value;}

    @Override
    public void push(final Object element) { add(size, element); }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int size() { return size; }
}
