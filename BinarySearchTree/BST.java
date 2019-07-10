class BST {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // root node
    static Node root = null;

    static Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    static void inorderRec(Node root){
        if(root != null)
        {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    static void inorder(){
        inorderRec(root);
    }

    static void insert(int key) {
        root = insertRec(root, key);
    }
    public static  Node search(Node root, int key){
        if(root == null || root.key == key) return root;
        else if(root.key > key) return search(root.left, key);
        else return search(root.right, key);
    }
    static void deleteKey(int key){root = deleteRec(root, key);}
    static Node deleteRec(Node root, int key){
        if(root == null) return root;// if the tree is empty.
        else if(key > root.key) root.right = deleteRec(root.right, key); // otherwise
        else if(key < root.key)root.left = deleteRec(root.left, key);
        else{// node with only one child or no child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            // node with two children : get the inorder successor in right subtree.
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    static int maxDepth(Node root){
	    if(root == null) return 0;
	    else{
		    int lDepth = maxDepth(root.left);
		    int rDepth = maxDepth(root.right);
		    if(lDepth > rDepth) return lDepth+1;
		    else return rDepht+1;
	    }
    }
    static int minValue(Node root){
        int minv = root.key;
        while(root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String args[]){
        insert(50);
        insert(20);
        insert(30);
        insert(500);
        insert(45);
        inorder();
        Node n = search(root, 501);
        if(n != null)
        {
            System.out.println(n.key);
        }
    }
}
