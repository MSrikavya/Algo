package Trees;

import Trees.TreeTraversals.BinaryTreeNode;

public class TreeProblems {

	public int maxElement(BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = maxElement(root.left);
			int rightMax = maxElement(root.right);

			if (leftMax > rightMax)
				maxValue = leftMax;
			else
				maxValue = rightMax;

			if (root.data > maxValue)
				maxValue = root.data;
		}
		return maxValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
