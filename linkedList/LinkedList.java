package linkedList;

public class LinkedList {
	private ListNode head, tail;
	private int size = 0;

	public LinkedList() {
		size = 0;
	}

	public void insertAtEnd(int data) {
		if (tail == null)
			insertAtFirst(data);
		else {
			ListNode node = new ListNode(data);
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	public void insertAtFirst(int data) {
		ListNode node = new ListNode(data);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = head;
		size++;
	}

	public void insertAtIndex(int data, int pos) {
		if (pos == 0)
			insertAtFirst(data);
		else if (pos == size)
			insertAtEnd(data);
		else {
			ListNode temp = head;
			for (int i = 1; i < pos; i++) {
				temp = temp.getNext();
			}

			ListNode node = new ListNode(data);
			node.setNext(temp.getNext());
			temp.setNext(node);
			size++;
		}
	}

	public void insertUsingRecur(int data, int pos) {
		if (pos == 0) {
			head = insertUsingRecur(data, pos, head);
			size++;
		}
	}

	public ListNode insertUsingRecur(int data, int pos, ListNode node) {
		if (pos == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(node);
			return temp;
		}

		insertUsingRecur(data, pos - 1, node);
		return node;
	}

	public int deleteAtIndex(int pos) {
		ListNode temp = head;
		for (int i = 1; i < pos - 1; i++)
			temp = temp.getNext();

		int result = temp.getNext().getData();

		temp.setNext(temp.getNext().getNext());
		size--;
		return result;
	}

	public int deleteAtFirst() {
		int result = head.getData();
		head = head.getNext();
		if (head == null)
			tail = null;
		size--;
		return result;
	}

	public int deleteAtEnd() {
		ListNode temp;
		if (size <= 1)
			return deleteAtFirst();
		else {
			int result = tail.getData();
			temp = head;
			while (temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(null);
			tail = temp;
			size--;
			return result;
		}
	}

	public ListNode partition(ListNode head, int k) {
		ListNode root = new ListNode(0);
		ListNode pivot = new ListNode(k);
		ListNode rootNext = root, pivotNext = pivot;
		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode next = currentNode.next;
			if (currentNode.data >= k) {
				pivotNext.next = currentNode;
				pivotNext = currentNode;
				pivotNext.next = null;
			} else {
				rootNext.next = currentNode;
				rootNext = currentNode;
			}
			currentNode = next;
		}

		rootNext.next = pivot.next;
		return root.next;
	}

	public int getMiddleValue() {
		ListNode node1, node2;
		node1 = node2 = head;

		while (node1.next != null) {
			node1 = node1.next;
			if (node1.next == null)
				break;
			else {
				node1 = node1.next;
				node2 = node2.next;
			}
		}

		return node2.data;
	}

	public void printFromLast(ListNode node) {
		if (node == null)
			return;
		else
			printFromLast(node.next);
		System.out.print(node.data + " -> ");
	}

	public void evenOrOdd() {
		ListNode node;
		node = head;
		while (node != null) {

			if (node.next == null) {
				System.out.println("Odd");
				break;
			} else if (node.next.next == null) {
				System.out.println("Even");
				break;
			} else
				node = node.next.next;

		}
	}

	public void display() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
	}

	public void display(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
	}

	public ListNode get(int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public void reverse() {
		if (size < 2)
			return;
		ListNode present = head, prev = null, next = head.getNext();
		tail = head;
		while (present != null) {
			present.setNext(prev);
			prev = present;
			present = next;
			if (next != null) {
				next = next.getNext();
			}
		}
		head = prev;
	}

	public void bubbleSort() {
		bubbleSort(size - 1, 0);
	}

	private void bubbleSort(int row, int col) {
		if (row == 0) {
			return;
		}

		if (col < row) {
			ListNode first = get(col);
			ListNode second = get(col + 1);

			if (first.data > second.data) {
				if (first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				} else if (second == tail) {
					ListNode prev = get(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				} else {
					ListNode prev = get(col - 1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			bubbleSort(row, col + 1);
		} else {
			bubbleSort(row - 1, 0);
		}
	}

	public static LinkedList merge(LinkedList first, LinkedList second) {
		ListNode f = first.head;
		ListNode s = second.head;

		LinkedList ans = new LinkedList();

		while (f != null && s != null) {
			if (f.data < s.data) {
				ans.insertAtEnd(f.getData());
				f = f.getNext();
			} else {
				ans.insertAtEnd(s.getData());
				s = s.getNext();
			}
		}

		while (f != null) {
			ans.insertAtEnd(f.getData());
			f = f.next;
		}

		while (s != null) {
			ans.insertAtEnd(s.getData());
			s = s.next;
		}

		return ans;
	}

	private class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
		}

		public int getData() {
			return this.data;
		}

		public ListNode getNext() {
			return this.next;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}

	public static void loopExistsOrNot(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Loop Exists");
			}
		}
		System.out.println("Loop doesn't exists");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();

		list.insertAtFirst(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(73);

		list2.insertAtFirst(35);
		list2.insertAtEnd(4);
		list2.insertAtEnd(13);
		list2.insertAtEnd(14);
		list2.insertAtEnd(80);
		list2.insertAtEnd(16);
		list2.insertAtEnd(19);

		list3.insertAtFirst(1);
		list3.insertAtEnd(4);
		list3.insertAtEnd(3);
		list3.insertAtEnd(2);
		list3.insertAtEnd(6);
		list3.insertAtEnd(5);
		list3.insertAtEnd(2);

//		list2.bubbleSort();
		list3.display();
		System.out.println();

		ListNode temp = list3.partition(list3.head, 3);
		list3.display(temp);
//		LinkedList mergedList = LinkedList.merge(list, list2);
//		mergedList.display();

//		list.deleteAtEnd();
//		list.deleteAtFirst();
//		System.out.println(list.deleteAtIndex(4));
		LinkedList.loopExistsOrNot(list.head);
		System.out.println();
		System.out.println(list.size);
		list.display();
		System.out.println();
//		list.reverse();
		list.display();
		System.out.println();
//		System.out.println(list.getMiddleValue());
		list.printFromLast(list.head);
		System.out.println();
		list.evenOrOdd();
	}
}
