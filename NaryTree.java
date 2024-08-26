import java.util.*;

class Node {
    int val;
    List<Node> children;

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>(); 
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class NaryTree {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node node, List<Integer> list) {
        if (node == null) return;
        for (Node child : node.children) {
            dfs(child, list);
        }
        list.add(node.val);
    }

    public static void main(String[] args) {
        NaryTree naryTree = new NaryTree();
        Node root = new Node(1);
        root.children = Arrays.asList(new Node(3), new Node(2), new Node(4));
        root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

        List<Integer> result = naryTree.postorder(root);
        System.out.println(result); 
    }
}
