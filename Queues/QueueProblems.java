package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Stacks.StackUsingLL;

public class QueueProblems {

	public static void queueReverse(QueueUsingLL queue) throws Exception {
		StackUsingLL stack = new StackUsingLL();

		while (queue.size != 0)
			stack.push(queue.deQueue());
		while (stack.size != 0)
			queue.enQueue(stack.pop());
	}

	public static boolean checkStackPairwiseOrder(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean isPairWiseOrdered = true;

		while (!s.isEmpty())
			q.add(s.pop());

		while (!q.isEmpty())
			s.push(q.remove());

		while (!s.isEmpty()) {
			int m = s.pop();
			q.add(m);
			if (!s.isEmpty()) {
				int n = s.pop();
				if (Math.abs(m - n) != 1)
					isPairWiseOrdered = false;
				q.add(n);
			}
		}

		while (!q.isEmpty())
			s.push(q.remove());

		return isPairWiseOrdered;
	}

	public static void interLeavingQueue(Queue<Integer> q) {
		if (q.size() % 2 != 0)
			throw new IllegalArgumentException();
		else {
			Stack<Integer> s = new Stack<Integer>();
			int halfsize = q.size() / 2;
			for (int i = 0; i < halfsize; i++)
				s.push(q.remove());

			while (!s.isEmpty())
				q.offer(s.pop());

			for (int i = 0; i < halfsize; i++)
				q.offer(q.remove());

			for (int i = 0; i < halfsize; i++)
				s.push(q.remove());

			while (!s.isEmpty()) {
				q.offer(s.pop());
				q.offer(q.remove());
			}
		}

		while (!q.isEmpty())
			System.out.println(q.remove());
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
		queueReverse(q);
		q.display();

		System.out.println();
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		q1.add(6);
		q1.add(7);
		q1.add(8);
		interLeavingQueue(q1);

		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println(checkStackPairwiseOrder(s));
	}

}
