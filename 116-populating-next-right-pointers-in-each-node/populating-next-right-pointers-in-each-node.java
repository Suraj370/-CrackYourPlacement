/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node previousNode = null;

            for (int i = queue.size(); i > 0; --i) {
                Node currentNode = queue.poll();

                if (previousNode != null) {
                    previousNode.next = currentNode;
                }

                previousNode = currentNode;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return root;
    }
}