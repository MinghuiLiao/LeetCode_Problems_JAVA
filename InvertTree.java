//226. Invert Binary Tree
/**
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author liaominghui
 *
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
