package Queues;

import java.util.Stack;

public class QueueUsing2Stacks {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public void enQueue(int data) {
		s1.push(data);
	}

	public int deQueue() {
		if (s2.isEmpty())
			while (!s1.isEmpty())
				s2.push(s1.pop());
		return (int) s2.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsing2Stacks q = new QueueUsing2Stacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.enQueue(7);
		q.enQueue(8);
		System.out.println(q.deQueue());
	}

}
