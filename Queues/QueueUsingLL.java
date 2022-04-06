package Queues;

public class QueueUsingLL {

	int size;
	ListNode front, rear;

	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if (size == 0)
			front = rear = node;
		else {
			rear.next = node;
			rear = node;
		}
		size++;
	}

	public int deQueue() throws Exception {
		if (size == 0)
			throw new Exception("Queue is Empty");
		else {
			ListNode node = front;
			front = front.next;
			size--;
			return node.data;
		}
	}

	public int getFirst() throws Exception {
		if (size == 0)
			throw new Exception("Queue is Empty");
		else
			return front.data;
	}

	private class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}

	public void display() {
		ListNode temp = front;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QueueUsingLL q = new QueueUsingLL();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.enQueue(7);
		q.enQueue(8);
		q.display();
		System.out.println();
		System.out.println(q.deQueue());
		System.out.println(q.getFirst());

	}

}
