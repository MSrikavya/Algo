package Queues;

public class QueueUsingArray {

	public static final int CAPACITY = 12;
	int[] queue;
	int size, front, rear;

	public QueueUsingArray() {
		queue = new int[CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}

	public void enQueue(int data) throws NullPointerException, IllegalStateException {
		if (size == CAPACITY)
			throw new IllegalStateException("Queue is full:Overflow");
		else {
			size++;
			queue[rear] = data;
			rear = (rear + 1) % CAPACITY;
		}
	}

	public int deQueue() throws IllegalStateException {
		if (size == 0)
			throw new IllegalStateException("Queue is Empty:Underflow");
		int result = queue[front];
		queue[front] = Integer.MIN_VALUE;
		size--;
		front = (front + 1) % CAPACITY;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == CAPACITY;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println(queue[(front + i) % CAPACITY]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray q = new QueueUsingArray();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.enQueue(7);
		q.enQueue(8);
		q.enQueue(9);
		q.enQueue(10);
		q.enQueue(11);
		q.enQueue(12);
		System.out.println(q.deQueue());
		System.out.println();
		q.display();
	}

}
