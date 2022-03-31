package Stacks;

public class StackUsingArray {

	int[] stack;
	int capacity;
	int top = -1;

	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public int top() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is Empty");
		return stack[top];
	}

	public void push(int data) throws Exception {
		if (size() == capacity)
			throw new Exception("Stack is full");
		else
			stack[++top] = data;
	}

	public int pop() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is Empty");
		else {
			int data = stack[top];
			stack[top--] = Integer.MIN_VALUE;
			return data;
		}
	}

	public int size() {
		return top + 1;
	}

	public void display() {
		for (int i = 0; i < size(); i++)
			System.out.print(stack[i] + "->");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		StackUsingArray stack = new StackUsingArray(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		stack.display();
	}

}
