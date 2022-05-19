public class LCABST {
    public static void main(String[] args) {
        LCABST tester = new LCABST();
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        root.left = p;
        TreeNode q = new TreeNode(8);
        root.right = q;
        TreeNode ans = tester.lowestCommonAncestor(root, p, q);
        System.out.print(ans.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
            return root;
        }
        if (p.val < root.val && q.val > root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

