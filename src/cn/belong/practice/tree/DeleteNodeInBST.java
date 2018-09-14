package cn.belong.practice.tree;

/**
 * leetcode NO. 450
 *
 * @author shiwen.chen
 * @date 2018-09-14 19:42
 */
public class DeleteNodeInBST {

    /**
     * 删除二分搜索树中的key对应的节点
     *
     * @param root 目标树
     * @param key  待删除的key
     * @return 返回删除后的树的根
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        TreeNode deleteNode = find(root, key);
        if (deleteNode == null)
            return root;

        return remove(root, deleteNode);
    }

    /**
     * 删除节点并返回删除后的子树的根
     *
     * @param root       需要删除的key
     * @param deleteNode 需要删除的元素
     */
    public TreeNode remove(TreeNode root, TreeNode deleteNode) {

        if (root.val == deleteNode.val) {

            if (deleteNode.left == null) {
                TreeNode right = deleteNode.right;
                deleteNode.right = null;
                return right;
            }

            if (deleteNode.right == null) {
                TreeNode left = deleteNode.left;
                deleteNode.left = null;
                return left;
            }

            TreeNode node = findMin(deleteNode.right);
            node.right = removeMin(deleteNode.right);
            node.left = deleteNode.left;
            deleteNode.left = deleteNode.right = null;
            return node;
        }

        if (root.val > deleteNode.val)
            root.left = remove(root.left, deleteNode);
        else
            root.right = remove(root.right, deleteNode);

        return root;
    }

    /**
     * 查找到树中的key对应的节点
     *
     * @param node 目标树
     * @param key  key
     * @return 返回key对应的节点
     */
    private TreeNode find(TreeNode node, int key) {
        if (node == null)
            return null;
        if (node.val == key)
            return node;
        if (node.val > key)
            return find(node.left, key);
        return find(node.right, key);
    }

    /**
     * 删除子树中的最小值对应的节点
     *
     * @return 新的子树的根
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 获取树中的最小节点
     *
     * @return 最小节点
     */
    private TreeNode findMin(TreeNode node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }

}
