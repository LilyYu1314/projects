package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree297 {
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    // Generate preorder string
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    // Use queue to simplify position move
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}
