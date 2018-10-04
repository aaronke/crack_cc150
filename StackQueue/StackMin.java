// Stack Min: How would you design a stack which, in addition to push and pop, has a function min
// which returns the minimum element? Push, pop and min should all operate in 0(1) time.
// pop()
// push()
// peek()
// min()
// isEmpty()

public class MyMinStack<T> {
	private static StackNode<T> {
		private T data;
		private T min;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;
	public T pop() {
		if(top == null) throw new EmptyStackExcpetion();
		T data = top.data;
		top = top.next;
		return data;
	}

	public void push(T item) {
		StackNode<T> node = new StackNode(item);
		if (top == null) {
			node.min = item;
		} else {
			if(top.min > node.item) {
				node.min = item;
			} else {
				node.min = top.min;
			}
			node.next = top;
		}
		top = node;
	}

	public T min() {
		if (top == null) throw new EmptyStackExcpetion;
		return top.min;
	}

	public T peek() {
		if (top == null) throw new EmptyStackExcpetion;
		return top.item;
	}

	public boolean isEmpty() {
		return top == null;
	}
}