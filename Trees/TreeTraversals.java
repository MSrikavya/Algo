package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TreeTraversals {
	BinaryTreeNode root;

	public class BinaryTreeNode {
		int data;
		BinaryTreeNode right, left;

		public BinaryTreeNode(int data, BinaryTreeNode right, BinaryTreeNode left) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public BinaryTreeNode(int data) {
			this.data = data;
			this.right = this.left = null;
		}
	}

	public BinaryTreeNode insertInorder(int A[], BinaryTreeNode root, int i) {
		if (i < A.length) {
			BinaryTreeNode temp = new BinaryTreeNode(A[i]);
			root = temp;
			root.left = insertInorder(A, root.left, 2 * i + 1);
			root.right = insertInorder(A, root.right, 2 * i + 2);
		}
		return root;
	}

	public void preorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		else {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	public void inorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		else {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public void postorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	public ArrayList<Integer> iterativePreorder(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode temp = root;
		s.push(temp);

		while (!s.isEmpty()) {
			temp = s.pop();
			res.add(temp.data);

			if (temp.right != null)
				s.push(temp.right);
			if (temp.left != null)
				s.push(temp.left);
		}

		return res;
	}

	public ArrayList<Integer> iterativeInorder(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode = root;
		boolean done = false;

		while (!done) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (!s.isEmpty())
					done = true;
				else {
					currentNode = s.pop();
					res.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
		}
		return res;
	}

//Using 2 stacks
	public ArrayList<Integer> iterativePostorder(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		if (root == null)
			return res;
		BinaryTreeNode currentNode = root;
		s1.push(currentNode);
		while (!s1.isEmpty()) {
			currentNode = s1.pop();
			s2.push(currentNode);
			if (currentNode.left != null)
				s1.push(currentNode.left);
			if (currentNode.right != null)
				s1.push(currentNode.right);
		}

		while (!s2.isEmpty())
			res.add(s2.pop().data);

		return res;
	}

//Using 1 stack
	public void iterativePostorderUsing1Stack(BinaryTreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode, prev = null;
		s.push(root);

		while (!s.isEmpty()) {
			currentNode = s.peek();

			if (prev == null || prev.left == currentNode || prev.right == currentNode) {
				if (currentNode.left != null)
					s.push(currentNode.left);
				else if (currentNode.right != null)
					s.push(currentNode.right);
				else {
					res.add(currentNode.data);
					s.pop();
				}
			} else if (currentNode.left == prev) {
				if (currentNode.right != null) {
					s.push(currentNode.right);
				} else {
					res.add(currentNode.data);
					s.pop();
				}
			} else if (currentNode.right == prev) {
				res.add(currentNode.data);
				s.pop();
			}

			prev = currentNode;
		}

		System.out.println(Arrays.asList(res));
	}

	public void levelOrderTraversal(BinaryTreeNode root) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversals p = new TreeTraversals();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		p.root = p.insertInorder(A, p.root, 0);
		p.preorderTraversal(p.root);
		System.out.println();
		p.inorderTraversal(p.root);
		System.out.println();
		p.postorderTraversal(p.root);
		System.out.println();
		System.out.println(Arrays.asList(p.iterativePreorder(p.root)));
		System.out.println(Arrays.asList(p.iterativePostorder(p.root)));
		p.iterativePostorderUsing1Stack(p.root);

	}

}
