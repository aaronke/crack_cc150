// Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.

public class MyQueue<T> {
	private Stack<T> addStack; 
	private Stack<T> popStack;
	public MyQueue() {
		addStack = new Stack<>();
		popStack = new Stack<>();
	}
	public void add(T data) {
		addStack.push(data);
	}

	public T pop() {
		if(popStack.isEmpty()) {
			while (!addStack.isEmpty()) {
				popStack.push(addStack.pop());
			}
		}
		T data = popStack.pop();
		return data;
	} 

	public T peek() {
		if(popStack.isEmpty()) {
			while (!addStack.isEmpty()) {
				popStack.push(addStack.pop());
			}
		}
		T data = popStack.peek();
		return data;
	}

	public boolean isEmpty() {
		return popStack.isEmpty() && addStack.isEmpty();
	}
}