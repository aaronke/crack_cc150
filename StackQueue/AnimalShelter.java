// Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
// out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
// that type). They cannot select which specific animal they would like. Create the data structures to
// maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
// and dequeueCat. You may use the built-in Linked List data structure.


public class AnimalShelter {

	private static class Animal {
		private Date adoptedDate;
		private String type;
		public Animal(Date date, String type){
			adoptedDate = date;
			this.type = type;
		}
	}
	private LinkedList<Animal> animals;
	private Animal start;

	public AnimalShelter() {
		animals = new LinkedList<>();
	}

	public void enqueue(Animal animal) {
		if (start == null) {
			start = animal;
		} else {
			start.next = animal;
		}
	}

	public Animal dequeueAny() {
		if (start == null) throw new EmptyQueueException();
		Animal animal = start;
		start = start.next;
		return animal;
	}

	public Animal dequeueCat() {
		if (start == null) throw new EmptyQueueException();
		Animal animal = start;
		Stack<Animal> stack = new Stack<>();
		while (animal != null && !animal.type.equals("cat")) {
			stack.push(animals.pop());
		}
		while (!stack.isEmpty()) {
			animals.add(stack.pop());
		}
		if (animal == null) {
			throw new NoCatInQueueException();
		}
		return animal;
	}

	public Animal dequeueDog() {
		if (start == null) throw new EmptyQueueException();
		Animal animal = start;
		Stack<Animal> stack = new Stack<>();
		while (animal != null && !animal.type.equals("dog")) {
			stack.push(animals.pop());
		}
		while (!stack.isEmpty()) {
			animals.add(stack.pop());
		}
		if (animal == null) {
			throw new NoDogInQueueException();
		}
		return animal;
	}
}