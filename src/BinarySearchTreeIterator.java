/**
 * Created by jixiaoqiang on 2017/6/1.
 */
public class BinarySearchTreeIterator {
    /**
     * Definition for binary tree
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode root;

    /**
     * 中序遍历
     * @param root
     */
    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return 1;
    }
}

