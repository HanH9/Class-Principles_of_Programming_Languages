from Node import Node


# The class for BNT
class BST:
    def __init__(self, node_list):
        self.root = Node(node_list[0])
        for data in node_list[1:]:
            self.insert(data)

    # Searches a node in tree
    def search(self, node, parent, data):
        if node is None:
            return False, node, parent
        if node.data == data:
            return True, node, parent
        if node.data > data:
            return self.search(node.left, node, data)
        else:
            return self.search(node.right, node, data)

    # Inserts a new node into BNT
    def insert(self, data):
        flag, n, p = self.search(self.root, None, data)
        if not flag:
            new_node = Node(data)
            if data > p.data:
                p.right = new_node
            else:
                p.left = new_node

    # Removes a node from BST
    def delete(self, root, data):
        flag, n, p = self.search(root, root, data)
        if flag is False:
            print("Fail to delete")
        else:
            if n.left is None:
                if n == p.left:
                    p.left = n.right
                else:
                    p.right = n.right
                del p
            elif n.right is None:
                if n == p.left:
                    p.left = n.left
                else:
                    p.right = n.left
                del p
            else:
                pre = n.right
                if pre.left is None:
                    n.data = pre.data
                    n.right = pre.right
                    del pre
                else:
                    while pre.left.left is not None:
                        pre = pre.left
                    n.data = pre.left.data
                    pre.left = pre.left.right

    # Shows the tree in inorder
    def inOrderTraverse(self, node):
        if node is not None:
            self.inOrderTraverse(node.left)
            if node == self.root:
                print("Root-", end="")
            print("element:", node.data, end=",")
            if node.left is None:
                print("left child: None", end=",")
            else:
                print("left child:", node.left.data, end=",")
            if node.right is None:
                print("right child: None")
            else:
                print("right children:", node.right.data)

            self.inOrderTraverse(node.right)
