import java.util.Objects;

class BinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private class Node {
        public Key key;
        public Value val;
        public int size; // tamanho da subárvore enraizada em Node
        public Node leftSubtree;
        public Node rightSubtree;

        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.size = 1;
        }
    }

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    public void put(Key key, Value val) {
        root = put(key, val, root);
        updateSize(key, root);
    }

    public Node put(Key key, Value val, Node node) {
        if (node == null) {
            return new Node(key, val);
        }
        if (key.compareTo(node.key) == 0)
            node.val = val;
        else if (key.compareTo(node.key) < 0)
            node.leftSubtree = put(key, val, node.leftSubtree);
        else
            node.rightSubtree = put(key, val, node.rightSubtree);
        return node;
    }

    public void updateSize(Key key, Node node) {
        if (key.compareTo(node.key) < 0) {
            updateSize(key, node.leftSubtree);
        } else if (key.compareTo(node.key) > 0) {
            updateSize(key, node.rightSubtree);
        }
        node.size = (node.leftSubtree == null ? 0 : node.leftSubtree.size)
                + (node.rightSubtree == null ? 0 : node.rightSubtree.size)
                + 1;
    }

    public int size() {
        if (root == null) return 0;
        else return root.size;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node){
        if (node.val == null)
            return null;
        if (!hasLeftSubtree(node))
            return node;
        return min(node.leftSubtree);
    }


    @Override
    public void deleteMin() {
        if (root == null)
            return;
        if (root.key.compareTo(min()) == 0){
            root = root.rightSubtree;
            return;
        }
        deleteNodeFromKey(root, min());
        root.size--;
    }

    private Node deleteNodeFromKey(Node node, Key key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.leftSubtree = deleteNodeFromKey(node.leftSubtree, key);
            return node;
        }

        if (key.compareTo(node.key) > 0){
            node.rightSubtree = deleteNodeFromKey(node.rightSubtree, key);
            return node;
        }

        if (!hasRightSubtree(node))
            return node.leftSubtree;

        if (!hasLeftSubtree(node))
            return node.rightSubtree;

        Node replace = min(node.rightSubtree);
        delete(Objects.requireNonNull(min(node.rightSubtree)).key);
        root.size--;
        return replace;
    }

    private boolean hasRightSubtree(Node node){
        if (node.rightSubtree != null)
            return node.rightSubtree.val != null;
        return false;
    }

    private boolean hasLeftSubtree(Node node){
        if (node.leftSubtree != null)
            return node.leftSubtree.val != null;
        return false;
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node){
        if (node.val == null)
            return null;
        if (!hasRightSubtree(node))
            return node;
        return max(node.rightSubtree);
    }

    @Override
    public Key floor(Key ref) {
        Node floor = floor(root, ref, null);
        if (floor != null)
            return floor.key;
        return null;
    }

    private Node floor(Node node, Key ref, Node tempFloor){
        if (node == null)
            return tempFloor;

        if (node.key == null)
            return tempFloor;

        if (node.key.compareTo(ref) == 0)
            return node;

        if (node.key.compareTo(ref) < 0)
            return floor(node.rightSubtree, ref, node);

        return floor(node.leftSubtree, ref, tempFloor);
    }

    @Override
    public Key ceil(Key ref) {
        Node ceil = ceil(root, ref, null);
        if (ceil != null)
            return ceil.key;
        return null;
    }

    private Node ceil(Node node, Key ref, Node tempCeil) {
        if (node == null)
            return tempCeil;

        if (node.key == null)
            return tempCeil;

        if (node.key.compareTo(ref) == 0)
            return node;

        if (node.key.compareTo(ref) < 0)
            return ceil(node.rightSubtree, ref, node);

        return ceil(node.leftSubtree, ref, tempCeil);
    }

    @Override
    public Key select(int n) {
        return select(root, n).key;
    }

    private Node select(Node node, int n){
        int k;
        if (node == null)
            return null;
        if (node.key == null)
            return null;
        if (!hasLeftSubtree(node))
            k = 0;
        else
            k = node.leftSubtree.size;
        if (k == n)
            return node;
        if (k > n)
            return select(node.leftSubtree, n);
        return select(node.rightSubtree, n-k-1);
    }

    @Override
    public int rank(Key key) {
        //TODO
        return 0;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    public Value get(Key key, Node node) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node.val;
        else if (key.compareTo(node.key) < 0)
            return get(key, node.leftSubtree);
        else
            return get(key, node.rightSubtree);
    }

    private Node getNodeFromKey(Node node, Key key){
        if (node == null)
            return null;
        if (node.key.compareTo(key) == 0)
            return node;

        if (node.key.compareTo(key)<0)
            return getNodeFromKey(node.rightSubtree, key);
        return getNodeFromKey(node.leftSubtree, key);
    }
}