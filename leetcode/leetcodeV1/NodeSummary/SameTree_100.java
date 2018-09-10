package NodeSummary;

public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    //the first 2 lines can be combined into 1 line:
    //if (p == NULL || q == NULL) return (p == q);
}
