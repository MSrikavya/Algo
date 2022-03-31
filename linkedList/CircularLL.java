package linkedList;

public class CircularLL {

	int size;
	Node tail;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public CircularLL() {
		size = 0;
	}

	public void insertFirst(int data) {
		Node node;
		if (tail == null) {
			node = new Node(data);
			tail = node;
			tail.next = tail;
		} else {
			node = new Node(data);
			node.next = tail.next;
			tail.next = node;
		}
		size++;
	}

	public void insertAtTail(int data) {
		insertFirst(data);
		tail = tail.next;
	}

	public int deleteAtFirst() {
		int result;
		if (tail.next == tail) {
			result = tail.data;
			tail = null;
			return result;
		}

		Node node = tail.next;
		result = node.data;
		tail.next = node.next;
		node.next = null;
		size--;
		return result;
	}

	public int deleteAtEnd() {
		int result;
		if (tail.next == tail) {
			result = tail.data;
			tail = null;
			return result;
		}

		Node temp = tail;

		while (temp.next != tail) {
			temp = temp.next;
		}

		temp.next = tail.next;
		tail = temp;
		size--;
		return temp.data;
	}

	public void display() {
		Node temp = tail.next;
		do {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		} while (temp != tail.next);

		System.out.print(temp.data + " -> ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLL list = new CircularLL();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.display();

	}

}
