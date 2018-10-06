// Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
// an additional temporary stack, but you may not copy the elements into any other data structure
// (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

public class SortStack {
	private Stack<int> stack;
	private Stack<int> tempStack;
	public  SortStack() {
		stack = new Stack<>();
		tempStack = new Stack<>();
	}

	private void insert(int data) {
		while (!stack.isEmpty() && stack.peek() < data) {
			tempStack.push(stack.pop());
		}
		stack.push(data);
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public void push(int data) {
		if(stack.isEmpty()) {
			stack.push(data);
		} else {
			if (stack.peek() >= data) {
				stack.push(data);
			} else {
				insert(data);
			}
		}
	}

	public int pop() {
		if (stack.isEmpty()) throw new EmptyStackException();
		return stack.pop();
	}

	public int peek() {
		if (stack.isEmpty()) throw new EmptyStackException();
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
}