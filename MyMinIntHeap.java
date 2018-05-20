import java.util.Arrays;

class MyMinIntHeap {
	
	private final static int DEFAULT_CAPACITY = 8;

	private int[] array;
	private int size;
	private int capacity;

	public MyMinIntHeap() {
		array = new int[DEFAULT_CAPACITY];
		this.capacity = this.DEFAULT_CAPACITY;	
		this.size = 0;
	}

	public MyMinIntHeap(int initialCapacity) {
		array = new int[initialCapacity];
		this.capacity = initialCapacity;
		this.size = 0;
	}

	public int peek() {
		if (!isEmpty()) return this.array[0];
		else throw new IllegalStateException();
	}

	public int poll() {
		if (this.isEmpty()) throw new IllegalStateException();
		int value = this.array[0];
		this.array[0] = this.array[size - 1];
		this.size--;
		siftDown();
		return value;
	}

	public void insert(int value) {
		this.checkArrayIsFull();
		array[size] = value;
		this.size++;
		siftUp();
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private void siftUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > array[index]) {			
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}	
	}

	private void siftDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallestChildIndex = getSmallestChildIndex(index);
			if(array[index] >= array[smallestChildIndex]) 
				swap(index, smallestChildIndex);
			else 
				return;			
			index = smallestChildIndex;
		}
	}

	/**
	 * Helper methods.
	 */
	
	private int getParentIndex(int index) { return (index-2)/2; }
	private int getLeftIndex(int index) { return index*2 + 1; }
	private int getRightIndex(int index) { return index*2 + 2; }

	private boolean hasParent(int index) { return this.getParentIndex(index) >= 0; }
	private boolean hasLeftChild(int index) { return getLeftIndex(index) < this.size; }
	private boolean hasRightChild(int index) { return getRightIndex(index) < size; }

	private int getParent(int index) { return array[getParentIndex(index)]; }
	private int getLeft(int index) { return array[getLeftIndex(index)]; }
	private int getRight(int index) { return array[getRightIndex(index)]; }

	private int getSmallestChildIndex(int index) {
		if(hasLeftChild(index)) {
			if (hasRightChild(index) && getRight(index) < getLeft(index))
				return getRightIndex(index);
			else
				return getLeftIndex(index);
		}
		return -1;
	}

	private void swap(int index_a, int index_b) {
		int aux = array[index_a];
		array[index_a] = array[index_b];
		array[index_b] = aux;
	}

	private void checkArrayIsFull() {
		if (this.size == this.capacity) {
			this.array = Arrays.copyOf(this.array, capacity*2);
			this.capacity *= 2;
		}
	}
}
