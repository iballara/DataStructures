class MyStack<T> {
	
	private static final int DEFAULT_CAPACITY = 8;

	private Object[] array;
	private int capacity;
	private int size;

	public MyStack() {
		array = new Object[DEFAULT_CAPACITY];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}

	public MyStack(int capacity) {
		array = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public boolean push(T element) {
		if (arrayIsFull()) return false;
		array[this.size++] = element;
		return true;
	}

	public T pop() {
		final T t = this.peek();
		this.size--;
		return t;
	}

	public T peek() {
		if (isEmpty()) return null;
		return (T) array[this.size - 1];
	}
	
	public int search(T element) {
		if (isEmpty()) return -1;
		for (int i = 0; i < size; i++)
			if ((T)array[i] == element) 
				return i;
		return -1;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private boolean arrayIsFull() {
		return size == capacity;
	}

	/**
	 * Just for DEBUG.
	 */
	void print() {
		int n = this.size();
		for (int i = n - 1; i >= 0; i--)
			System.out.println(array[i]);
	}
}

class Main {

	public static void main(String[] args) {
		
		final MyStack<String> stack = new MyStack<>();

		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		System.out.println("Pop: " + stack.pop());
		stack.push("Four");
		stack.push("Five");
		
		System.out.println("Search 'Two': " + stack.search("Two"));
		System.out.println("=== STACK ===");
		stack.print();

	}
}
