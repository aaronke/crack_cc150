// Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
// Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
// threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
// composed of several stacks and should create a new stack once the previous one exceeds capacity.
// SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
// (that is, pop ( ) should return the same values as it would if there were just a single stack).
// FOLLOW UP
// Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.


public class StackPlates {
	private static class StackNode<T> {
		private ArrayList<T> list;
		private StackNode<T> next;

		public StackNode() {
			list = new ArrayList<>();
		}
	}
	private StackNode<T> top;
	private int capacity = 0;

	public StackPlates(int capacity) {
		this.capacity = capacity;
	}

	public void push(T data) {
		if (top == null) {
			StackNode<T> node = new StackNode();
			node.list.add(data);
			top = node;
		} else {
			top.list.add(data);
		}
		if (top.list.size() >= capacity) {
			StackNode<T> node = new StackNode();
			top = node;
		}
	}

	public T pop() {
		while (top != null && top.list.size() == 0) {
			top = top.next;
		}
		if (top == null || top.list.size() == 0) throw new EmptyStackException();
		T data = top.list.remove(top.list.size() - 1);
		return data;
	}

	public T peek() {
		while (top != null && top.list.size() == 0) {
			top = top.next;
		}
		if (top == null || top.list.size() == 0) throw new EmptyStackException();
		T data = top.list.get(top.list.size() - 1);
		return data;
	}

	public T popAt(int index) {
		StackNode node = top;
		whlie (index >= 0 && node != null) {
			node = node.next;
		}
		if (index != 0) throw new NoSuchSubStackExcpetion();
		if (node.list.size() == 0) throw new EmptySubStackException();
		T data = node.list.remove(node.list.size() - 1);
		return data;
	}

	public boolean isEmpty() {
		while (top != null && top.list.size() == 0) {
			top = top.next;
		}
		if (top == null || top.list.size() == 0) return true;
		else return false;
	}

}