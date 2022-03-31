package Stacks;

public class StackUsingDynamicArray {
	public static final int MINCAPACITY = 2;
	int[] stack;
	int capacity;
	int top = -1;

	public StackUsingDynamicArray(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public int size() {
		return top + 1;
	}

	public int top() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is Empty");
		return stack[top];
	}

	public void push(int data) {
		if (size() == capacity)
			expand();
		stack[++top] = data;
	}

	public void expand() {
		int length = size();
		int[] newStack = new int[length << 1];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		capacity = this.capacity << 1;
	}

	public int pop() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is Empty");
		else {
			int data = stack[top];
			stack[top--] = Integer.MIN_VALUE;
			shrink();
			return data;
		}
	}

	public void shrink() {
		int length = top + 1;
		if (length <= MINCAPACITY || top << 2 >= length)
			return;
		length = length + (top << 1);
		if (top < MINCAPACITY)
			length = MINCAPACITY;
		int[] newStack = new int[length];
		System.arraycopy(stack, 0, newStack, 0, top - 1);
		stack = newStack;
		this.capacity = length;
	}

	public void display() {
		for (int i = 0; i < size(); i++)
			System.out.print(stack[i] + "->");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingDynamicArray stack = new StackUsingDynamicArray(6);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.display();
		System.out.println();
		System.out.println(stack.capacity);

	}

}
