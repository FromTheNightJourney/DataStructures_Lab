class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    public static int sumBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumBinaryTree(root.left) + sumBinaryTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int sum = sumBinaryTree(root);
        System.out.println(sum);
    }
}