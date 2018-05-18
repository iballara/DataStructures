class MyLinkedList<T> {

	private Node<T> head;
	private int size;

	public MyLinkedList() {
		this.head = new Node(null, null);
		int size = 0;
	}

	public void add(T element) {
		Node<T> current = this.head;
		while (current.next != null)
			current = current.next;
		current.next = new Node(element, null);
		this.size++;
	}

	public void addFirst(T element) {
		Node<T> first = head.next;
		this.head.next = new Node(element, first);
		this.size++;
	}

	public T get(int index) {
		if (index >= this.size) return null;
		Node<T> current = this.head.next;		
		for (int i = 0; i < index; i++)
			current = current.next;
		return current.element;
	}

	public void remove(T element) {
		Node<T> previous = this.head;		
		Node<T> current = previous.next;
		while (current.element != element) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		this.size--;
	}

	public T poll() {
		if (this.isEmpty()) return null;
		Node<T> first = this.head.next;
		Node<T> second = first.next;
		this.head.next = second;
		this.size--;
		return first.element;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	/**
	 * Just for debug.
	 */
	void print() {
		Node<T> current = this.head;
		while(current.next != null) {
			current = current.next;
			System.out.println(current.element);
		}
	}

	private class Node<T> {

		T element;
		Node<T> next;

		Node (T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}
	}
}

class Main {

	public static void main(String[] args) {
	
		final MyLinkedList<String> list = new MyLinkedList<>();

		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String s = list.poll();
			System.out.println(s);
		}
	}
}
