/**
 * The class for BNT
 */
public class BinarySearchTree
{
    Node root;

    /**
     * Searches a node in tree
     * @param key node's element
     * @return the found node
     */
    public Node search(int key)
    {
        Node cur = root;
        while(cur != null){
            if(cur.element<key){
                cur=cur.right;
            }else if(cur.element==key){
                return cur;
            }else{
                cur=cur.left;
            }
        }
        return null;
    }

    /**
     * Inserts a new node into BNT
     * @param value value of new node
     * @return if the insertion success or not
     */
    public boolean insert(int value)
    {
        if(root == null){
            root=new Node(value);
            return true;
        }

        Node newNode = new Node(value);// new node
        Node cur = root;// point node
        Node parent = null;

        while(cur != null)
        {
            if(cur.element < value)
            {
                parent = cur;
                cur = cur.right;
            }
            else if(cur.element > value)
            {
                parent = cur;
                cur = cur.left;
            }
            else
            {
                return false;
            }
        }
        if(parent.element < value){
            parent.right=newNode;
        }else if(parent.element > value){
            parent.left=newNode;
        }
        return true;
    }

    /**
     * Removes a node from BST
     * @param key the element of deleted node
     */
    public void remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null)
        {
            if(cur.element == key)
            {
                removeNode(cur,parent);
                break;
            }
            else if(cur.element<key)
            {
                parent = cur;
                cur = cur.right;
            }else
                {
                parent =cur;
                cur=cur.left;
            }
        }
    }

    /**
     * Helper function of remove(int)
     * @param cur deleted node
     * @param parent deleted node's parent
     */
    public void removeNode(Node cur,Node parent)
    {
        if(cur.left == null)
        {
            if(cur == root)
            {
                root = cur.right;
            }
            else if(cur == parent.left)
            {
                parent.left = cur.right;
            }
            else if(cur == parent.right)
            {
                parent.right = cur.right;
            }
        }
        else if(cur.right == null)
        {
            if(cur == root)
            {
                root = cur.left;
            }
            else if(cur == parent.left)
            {
                parent.left = cur.left;
            }
            else if(cur == parent.right)
            {
                parent.right = cur.left;
            }
        }
        else
        {
            // find the min in deleted node's right child tree
            Node targetParent = cur;
            Node target = cur.right;
            while(target.left!=null)
            {
                // search in left side
                targetParent=target;
                target=target.left;
            }
            cur.element = target.element;
            if(target == targetParent.left)
            {
                targetParent.left = target.right;
            }
            else if(target == targetParent.right)
            {
                targetParent.right = target.right;
            }
        }
    }

    /**
     * Shows the tree in inorder
     * @param root root of BST
     */
    public void inOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.left);

        if(root == this.root)
        {
            System.out.print("Root-");
        }
        System.out.print("element:" + root.element + ",");
        if(root.left != null)
        {
            System.out.print("left children:" + root.left.element +",");
        }
        else {
            System.out.print("left children:null,");
        }
        if(root.right != null)
        {
            System.out.print("right children:" + root.right.element);
        }
        else {
            System.out.print("right children:null");
        }
        System.out.println();

        inOrder(root.right);
    }
}
