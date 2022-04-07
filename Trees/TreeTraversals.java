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

	}

}
