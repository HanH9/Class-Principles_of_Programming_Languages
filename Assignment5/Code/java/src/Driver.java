import java.util.Random;
import java.util.Scanner;

/**
 * Driver class for test
 */
public class Driver
{
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree binarySearchTree=new BinarySearchTree();

        // Add the elements into a Binary Search tree
        for(int i=0;i<20;i++){
            binarySearchTree.insert(random.nextInt(100)+1);
        }

        // Output the tree in inorder, show nodes and children clearly, identify root
        System.out.println("Show binary search tree in inorder:");
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();

        // Select a node that is not a leaf node and delete it from the tree
        System.out.println("Select a node that is not a leaf to delete:");
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        binarySearchTree.remove(node);
        System.out.println("Show binary search tree in inorder again:");
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();

        // Add a node to the tree with a random value
        int randomValue;
        randomValue = random.nextInt(100) + 1;
        binarySearchTree.insert(randomValue);
        System.out.println("The random value is " + randomValue + ", the new tree is:");
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
