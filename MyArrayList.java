class MyArrayList<T> {

	private static final int DEFAULT_CAPACITY = 4;	

	private Object[] array;
	private int capacity;
	private int size;

	public MyArrayList() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}

	public MyArrayList(int initialCapacity) {
		this.array = new Object[initialCapacity];
		this.capacity = initialCapacity;
		this.size = 0;
	}

	public void add(T element) {
		checkArrayIsFull();
		this.array[size] = element;
		this.size++;
	}

	public void set(T element, int index) {
		checkArrayIsFull();
		for (int i = size - 1; i >= index; i--)	
			array[i+1] = array[i];
		array[index] = element;
		this.size++;	
	}	

	public T get(int index) {
		if (index >= size) return null;
		return (T) array[index];
	}

	public boolean remove(int index) {
		if (index >= size) return false;
		for (int i = index; i < size - 1; i++)
			array[i] = array[i+1];
		this.size--;
		return true;
	}

	public int indexOf(T element) {
		for (int i = 0; i < size; i++)
			if ((T)array[i] == element)
				return i;
		return -1;
	}

	public int lastIndexOf(T element) {
		for (int i = this.size-1; i >= 0; i--)
			if ((T)array[i] == element)
				return i;
		return -1;
	}

	public boolean contains(T element) {
		return indexOf(element) > -1;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private void checkArrayIsFull() {
		if (this.size == this.capacity) {
			Object[] newArray = new Object[capacity*2];
			for (int i = 0; i < size; i++)
				newArray[i] = this.array[i];
			this.capacity = this.capacity * 2;
			this.array = newArray;
		}
	}
}

class Main {

	public static void main(String[] args) {

		final MyArrayList<String> list = new MyArrayList<>(5);
	
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.set("3.5", 3);
		
		int size = list.size();
		for (int i = 0; i < size; i++)	
			System.out.println(list.get(i));
	}
}







