package priv.ifan.tsai;

/*
 * 用数组结构实现大小固定的队列和栈
 */
public class ArrayToStakAndQueue {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	static class ArrayStack {
		private int[] arr;
		private int size = 0; // 表示栈的大小,同时又指向栈顶的下一个元素
		
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("Stack size must be more than 0");
			}
			arr = new int[initSize];
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public void push(int obj) {
			if (size == arr.length) {
				throw new IndexOutOfBoundsException("The stack is full");
			}
			arr[size++] = obj;
		}
		
		public int pop() {
			if (size == 0) {
				throw new IndexOutOfBoundsException("The stack is empty");
			}
			return arr[--size];
		}
		
		public int peek() {
			if (size == 0) {
				throw new IndexOutOfBoundsException("The stack is empty");
			}
			return arr[size - 1];
		}
	}
	
	static class ArrayQueue {
		private int[] arr;
		private int size = 0;   // 表示队列的大小,并将队首和队尾指针解耦,即实际不用考虑它们两的位置关系
		private int first = 0;  // 指向队首的指针,出队后++,大于数组长度后回到0
		private int last = 0;   // 指向队尾的下一个的指针,入队后++,大于数组长度后回到0
		
		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("Queue size must be more than 0");
			}
			arr = new int[initSize];
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public void add(int obj) {
			if (size == arr.length) {
				throw new IndexOutOfBoundsException("The queue is full");
			}
			arr[last] = obj;
			last = (last + 1) % arr.length;
			size++;
		}
		
		public int poll() {
			if (size == 0) {
				throw new IndexOutOfBoundsException("The queue is empty");
			}
			int t = first;
			first = (first + 1) % arr.length;
			size--;
			return arr[t];
		}
		
		public int peek() {
			if (size == 0) {
				throw new IndexOutOfBoundsException("The queue is empty");
			}
			return arr[first];
		}
	}

}
