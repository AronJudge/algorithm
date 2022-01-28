package Tree;

public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while ( p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node q = tree;
        while (q != null) {
            if (data > q.data) {
                if (q.right == null) {
                    q.right = new Node(data);
                    return;
                }
                q = q.right;
            } else {
                if (q.left == null) {
                    q.left = new Node(data);
                    return;
                }
                q = q.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p is to delete node
        Node pp = null; // pp is to feather node
        while (p != null && p.data != data) {
             pp = p;
             if (data > p.data) p = p.right;
             else p = p.right;
        }
        if ( p == null) return; // don't find;

        // the node to be deleted has two child nodes.
        if (p.left != null && p.right != null) {
            Node minp = p.right;
            Node minpp = p; // minpp is the feather node of minP
            while (minp.left != null) {
                minpp = minp;
                minp = minp.left;
            }
            p.data = minp.data;
            p = minp;
            pp = minpp;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

         if (pp == null) tree = child;
         else if (pp.left == p) p.left = child;
         else pp.right = child;
   }
}
