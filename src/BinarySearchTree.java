public class BinarySearchTree {
    Node root;
    int size;
    private static class Node{
        Node left;
        public int val;
        Node right;
        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public BinarySearchTree() {
        root = null;
    }


    public void insert(int val) {
        size++;
        if (root == null) {
            root = new Node(val);
        } else {
            insertH(root, val);
        }
    }

    private Node insertH(Node cand, int val) {
        if (cand == null) {
            return new Node(val);
        }
        if (cand.val <= val) {
            cand.right = insertH(cand.right, val);
        } else {
            cand.left = insertH(cand.left, val);
        }
        return cand;
    }

    public boolean search(int val) {
        return findNode(root,val) != null;
    }

    private Node findNode(Node cand, int val) {
        if (cand == null) {
            return null;
        }
        if (cand.val == val) {
            return cand;
        }
        if (cand.val <= val) {
            return findNode(cand.right, val);
        } else {
            return findNode(cand.left, val);
        }
    }

    public int findMin() {
        if (root == null) {
            return -1;
        }
        return findMinH(root, root.val);
    }

    private int findMinH(Node cand, int curmin) {
        if (cand == null) {
            return -1;
        }
        if (cand.left == null) {
            return curmin;
        }
        curmin = cand.left.val;
        return findMinH(cand.left, curmin);
    }

    public int findMax() {
        if (root == null) {
            return -1;
        }
        return findMaxH(root, root.val);
    }

    private int findMaxH(Node cand, int curmax) {
        if (cand == null) {
            return -1;
        }
        if (cand.right == null) {
            return curmax;
        }
        curmax = cand.right.val;
        return findMaxH(cand.right, curmax);
    }

    public void delete(int val) {
        if (root == null) {
            return;
        }
        deleteH(root, null, val, false);
    }

    private void deleteH(Node cand, Node parent, int val, boolean dirright) {
        //pre-- cand is the node to be deleted
        if (cand == null) {
            return;
        }
        if (cand.val == val) {
            size--;
            handleDel(cand, parent, dirright);
            return;
        }
        if (cand.val <= val) {
            deleteH(cand.right, cand, val, true);
        } else {
            deleteH(cand.left, cand, val, false);
        }
    }

    private void handleDel(Node cand, Node parent, boolean dirright) {
        //leaf node
        if (cand.left == null && cand.right == null) { //leaf node
            if (parent == null) { //removing root node
                root = null;
                return;
            }
            if (dirright) {
                parent.right = null;
            } else {
                parent.left = null;
            }
       } else if (cand.left == null) { //single right child
            if (parent == null) { //removing root node
                root = cand.right;
                return;
            }
            if (dirright) {
                parent.right = cand.right;
            } else {
                parent.left = cand.right;
            }
       } else if (cand.right == null) { //single left child
            if (parent == null) { //removing root node
                root = cand.left;
                return;
            }
            if (dirright) {
                parent.right = cand.right;
            } else {
                parent.left = cand.right;
            }
        } else { //two children, replace the node with the min of right tree. could also do max of left, i believe.
            int min = findMinH(cand.right, cand.right.val);
            cand.val = min;
            deleteH(cand.right, cand, min, true);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public int height() {
        if (root == null) {
            return 0;
        }
        return heightH(root);
    }
    private int heightH(Node cand) {
        if (cand == null) {
            return 0;
        }
        return 1 + Math.max(heightH(cand.left), heightH(cand.right));
    }
    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversalH(root,sb);
        return sb.toString();
    }

    private void inOrderTraversalH(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderTraversalH(node.left, sb);
        if (!sb.isEmpty()) {
            sb.append(", ");
        }
        sb.append(node.val);
        inOrderTraversalH(node.right, sb);
    }

}

