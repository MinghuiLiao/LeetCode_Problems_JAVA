import java.util.LinkedList;
import java.util.List;

/*617. Merge Two Binary Trees*/

/*
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. 
 The merge rule is that if two nodes overlap, 
 then sum node values up as the new value of the merged node. 
 Otherwise, the NOT null node will be used as the node of new tree.
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class MergeTwoBinaryTrees {
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode t3 = new TreeNode(val);
		t3.left = mergeTrees(t1.left, t2.left);
		t3.right = mergeTrees(t1.right, t2.right);

		/*
		 * t1.left.val = t1.left.val + t2.left.val;
		 * 
		 * mergeTrees(t1.right, t2.right); if (t1.right == null) t1.right.val =
		 * 0; if (t2.right == null) t2.right.val = 0; t1.right.val =
		 * t1.right.val + t2.right.val;
		 */

		return t3;
	}

	public static void PrintFunction(TreeNode root) {
		if (root == null)
			return;

		List<TreeNode> list1 = new LinkedList<>();
		List<TreeNode> list2 = new LinkedList<>();

		TreeNode node;

		int line = 0;
		list1.add(root); // 把根节点放入root中
		while (list1.size() > 0) {
			node = list1.remove(0);
			System.out.printf("%-3d", node.val);
			if (line == 0) {
				if (node.left != null) {
					list2.add(node.left);
				}

				if (node.right != null) {
					list2.add(node.right);
				}
			} else {
				if (node.left != null) {
					list2.add(node.left);
				}

				if (node.right != null) {
					list2.add(node.right);
				}
			}

			if (list1.size() == 0) {
				line = 1 - line;
				List<TreeNode> tmp = list1;
				list1 = list2; // node每次打印都是list1，所以需要调换list1和list2并分别输出
				list2 = tmp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// MergeTwoBinaryTrees t1 = new MergeTwoBinaryTrees();
		MergeTwoBinaryTrees mergeTrees = new MergeTwoBinaryTrees();
		TreeNode t1 = new TreeNode(1);
		TreeNode t1_node2 = new TreeNode(3);
		t1.left = t1_node2;
		TreeNode t1_node3 = new TreeNode(2);
		t1.right = t1_node3;
		TreeNode t1_node4 = new TreeNode(5);
		t1.left.left = t1_node4;
		mergeTrees.PrintFunction(t1);
		System.out.println("--------------------");

		TreeNode t2 = new TreeNode(2);
		TreeNode t2_node2 = new TreeNode(1);
		t2.left = t2_node2;
		TreeNode t2_node3 = new TreeNode(3);
		t2.right = t2_node3;
		TreeNode t2_node4 = new TreeNode(4);
		t2.left.right = t2_node4;
		TreeNode t2_node5 = new TreeNode(7);
		t2.right.right = t2_node5;
		mergeTrees.PrintFunction(t2);
		System.out.println("--------------------");

		TreeNode t3 = mergeTrees.mergeTrees(t1, t2);
		// mergeTrees.PrintFunction(t3);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
	}

	TreeNode root = null;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
}
