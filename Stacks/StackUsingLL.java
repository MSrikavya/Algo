package Stacks;

public class StackUsingLL {

	private ListNode top;
	public int size;

	public StackUsingLL() {
		top = null;
		size = 0;
	}

	public void push(int data) {
		if (top == null)
			top = new ListNode(data);
		else {
			ListNode temp = new ListNode(data);
			temp.next = top;
			top = temp;
		}
		size++;
	}

	public int peek() throws Exception {
		if (top == null)
			throw new Exception("Stack is Empty");
		else
			return top.data;
	}

	public int pop() throws Exception {
		if (top == null)
			throw new Exception("Stack is Empty");
		int data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public void display() {
		ListNode temp = top;
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
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

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingLL list = new StackUsingLL();

		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.push(73);
		System.out.println(list.peek());
		list.pop();
		System.out.println(list.peek());
		list.display();

	}

}
