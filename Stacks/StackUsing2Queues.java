package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(int data) {
		if (q2.isEmpty())
			q1.offer(data);
		else
			q2.offer(data);
	}

	public int pop() {
		int i = 0, size;
		if (q2.isEmpty()) {
			size = q1.size();
			while (i < size - 1) {
				q2.offer(q1.poll());
				i++;
			}
			return q1.poll();
		} else {

			size = q2.size();
			while (i < size - 1) {
				q1.offer(q2.poll());
				i++;
			}
			return q2.poll();

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackUsing2Queues s = new StackUsing2Queues();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
