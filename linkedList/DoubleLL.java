package linkedList;

public class DoubleLL {
	Node head, tail;
	int size;

	public DoubleLL() {
		size = 0;
	}

	private class Node {
		int data;
		Node next, prev;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public void insertAtFirst(int data) {
		if (head == null) {
			head = new Node(data, null, null);
			tail = head;
		} else {
			Node temp = new Node(data, null, head);
			head.prev = temp;
			head = temp;
		}
		size++;
	}

	public void insertAtEnd(int data) {
		if (tail == null) {
			tail = new Node(data, null, null);
			head = tail;
		} else {
			Node temp = new Node(data);
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
		size++;
	}

	public void insertAtIndex(int data, int pos) {
		if (pos <= 1)
			insertAtFirst(data);
		else if (pos >= size)
			insertAtEnd(data);
		else {
			Node temp = head;
			for (int i = 1; i < pos - 1; i++)
				temp = temp.next;

			Node node = new Node(data, temp, temp.next);
			temp.next.prev = node;
			temp.next = node;
			size++;
		}
	}

	public int deleteAtFirst() {
		int result = head.data;
		head = head.next;
		size--;
		if (head == null)
			head = tail = null;
		else
			head.prev = null;
		return result;
	}

	public int deleteAtLast() {
		int result = tail.data;
		Node node = tail.prev;
		if (node == null)
			head = tail = null;
		else {
			node.next = null;
			tail = node;
		}
		return result;
	}

	public int deleteAtIndex(int pos) {
		if (pos <= 1)
			return deleteAtFirst();
		else if (pos >= size)
			return deleteAtLast();
		else {
			Node temp = head;
			for (int i = 1; i < pos; i++)
				temp = temp.next;
			int result = temp.data;
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			return result;
		}
	}

	public void display() {
		Node temp = tail.next;
		
		do {
			System.out.print(temp.data + "- > ");
			temp = temp.next;
		}
		while (temp != tail) ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLL list = new DoubleLL();
		list.insertAtFirst(1);
		list.insertAtFirst(2);
		list.insertAtFirst(3);
		list.insertAtFirst(4);
		list.insertAtFirst(5);
		list.display();
		System.out.println();
		System.out.println(list.deleteAtIndex(2));
		list.display();
	}

}
