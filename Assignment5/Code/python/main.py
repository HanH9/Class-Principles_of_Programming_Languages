import random

from BST import BST

# Create an array of 20 integers that is filled with Random numbers from 1-100
numbers = []
for i in range(20):
    numbers.append(random.randint(1, 100) + 1)

# Add the elements from the array into a Binary Search tree
bst = BST(numbers)

# Output the tree in inorder, show nodes and children clearly, identify root
bst.inOrderTraverse(bst.root)
print()

# Select a node that is not a leaf node and delete it from the tree
print("Select a node that is not a leaf to delete:")
leaf = int(input())
bst.delete(bst.root, leaf)
bst.inOrderTraverse(bst.root)
print()

# Add a node to the tree with a random value
newValue = random.randint(1, 100) + 1
bst.insert(newValue)
print("After adding", newValue,  "into BST:")
bst.inOrderTraverse(bst.root)
