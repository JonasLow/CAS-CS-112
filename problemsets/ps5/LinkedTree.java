public class LinkedTree {
    private class Node {
        private int item;
        private String data;
        private Node leftChild;
        private Node rightChild;
        
        private Node(int i, String data) {
            this.item = i;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private Node root;
    private int height = 0;
    
    public LinkedTree() {
		root = null;
	}

    public int sumKeysTo(int key) {
        boolean containsKey = false;
        Node parent = root;
        int currentSum = 0;

        while (parent != null && !containsKey) {
            currentSum += parent.item;

            if (parent.item == key) {
                containsKey = true;
            } else if (key < parent.item) {
                parent = parent.leftChild;
            } else {
                parent = parent.rightChild;
            }
        }
        
        if (containsKey) {
            return currentSum;
        } else {
            return 0;
        }
    }

    public void insertKeys(int[] keys) {
        for (int key: keys) {
            String data = "Key " + key;
            Node newNode = new Node(key, data);
            if (root == null) {
                root = newNode;
                height = 0;
                continue;
            }

            Node parent = root;
            Node trail = null;
            int currentHeight = 0;

            while (parent != null) {
                trail = parent;
                if (key < parent.item) {
                    parent = parent.leftChild;
                } else if (key > parent.item) {
                    parent = parent.rightChild;
                } else {
                    parent.data = data;
                    break;
                }
                currentHeight++;
            }
            
            if (key < trail.item) {
                trail.leftChild = newNode;
            } else {
                trail.rightChild = newNode;
            }

            if (currentHeight > height) {
                height = currentHeight;
            }
        }
    }

    /*
     * COUNTERS for levelOrderPrint():
     * i - Total CURRENT nodes, including hypothetical nulls
     * j - Maximum nodes, which is 2**(n + 1) - 1 for each level (sum of 2^n)
     * k - Total nulls, including hypothetical nulls
     * l - Next increment for maximum nodes (2^n)
     */
    public void levelOrderPrint() {
        if (root == null) {
            return;
        }

        int numNodes = (int) Math.pow(2, height + 1) - 1;
        ArrayQueue<Node> queue = new ArrayQueue<>(numNodes);
        queue.insert(root);
        int i = 1;
        int j = 3;
        int k = 0;
        int l = 4;

        while (!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(current.item + " ");

            if (current.leftChild != null) {
                queue.insert(current.leftChild);
                i++;
            } else {
                i++;
                k++;
            }
            if (current.rightChild != null) {
                queue.insert(current.rightChild);
                i++;
            } else {
                i++;
                k++;
            }

            if (i >= j) {
                i += k *2;
                j += l;
                l *= 2;
                System.out.println();
            }
        }
        System.out.println();
    }

    public void preorderPrint() {
        preorderPrintHelper(root);
        System.out.println();
    }

    private void preorderPrintHelper(Node node) {
        if (node != null) {
            System.out.print(node.item + " ");
            preorderPrintHelper(node.leftChild);
            preorderPrintHelper(node.rightChild);
        }
    }

    public void inorderPrint() {
        inorderPrintHelper(root);
        System.out.println();
    }

    private void inorderPrintHelper(Node node) {
        if (node != null) {
            inorderPrintHelper(node.leftChild);
            System.out.print(node.item + " ");
            inorderPrintHelper(node.rightChild);
        }
    }

    private static int numLeafNodesInTree(Node start) {
        if (start == null) {
            return 0;
        } else if (start.leftChild == null && start.rightChild == null) {
            return 1;
        } else {
            return numLeafNodesInTree(start.leftChild) + numLeafNodesInTree(start.rightChild);
        }
    }

    public int numLeafNodes() {
        return numLeafNodesInTree(root);
    }

    public int deleteSmallest() {
        if (root == null) {
            return -1;
        }

        Node trailNode = null;
        Node currentNode = root;

        while (currentNode.leftChild != null) {
            trailNode = currentNode;
            currentNode = currentNode.leftChild;
        }

        int finalVal = currentNode.item;
        
        if (currentNode.rightChild != null) {
            if (trailNode == null) {
                root = currentNode.rightChild;
            } else {
                trailNode.leftChild = currentNode.rightChild;
            }
        } else {
            if (trailNode == null) {
                root = null;
            } else {
                trailNode.leftChild = null;
            }
        }

        return finalVal;
    } 

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();
    
        // ----- Tests for sumKeysTo(int key) -----
        System.out.println("----- Testing sumKeysTo -----");
    
        // Test 1: Empty tree
        System.out.print("Test 1 (empty tree, sumKeysTo 13): ");
        int result1 = tree.sumKeysTo(13);
        System.out.println(result1 == 0 ? "Passed" : "Failed");
    
        // Insert keys into the tree
        int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        tree.insertKeys(keys);
    
        // Test 2: Sum keys to an existing key (13)
        System.out.print("Test 2 (sumKeysTo 13): ");
        int expectedSum2 = 76;
        int result2 = tree.sumKeysTo(13);
        System.out.println(result2 == expectedSum2 ? "Passed" : "Failed");
    
        // Test 3: Sum keys to an existing key (56)
        System.out.print("Test 3 (sumKeysTo 56): ");
        int expectedSum3 = 135;
        int result3 = tree.sumKeysTo(56);
        System.out.println(result3 == expectedSum3 ? "Passed" : "Failed");
    
        // Test 4: Sum keys to a non-existing key (50)
        System.out.print("Test 4 (sumKeysTo 50): ");
        int result4 = tree.sumKeysTo(37);
        System.out.println(result4 == 37 ? "Passed" : "Failed");
    
        // Test 5: Sum keys to the root key (37)
        System.out.print("Test 5 (sumKeysTo 37): ");
        int result5 = tree.sumKeysTo(50);
        System.out.println(result5 == 0 ? "Passed" : "Failed");
    
        System.out.println();
        // ----- Tests for numLeafNodes() -----
        System.out.println("----- Testing numLeafNodes -----");
    
        // Test 6: Leaf nodes count in a non-empty tree
        System.out.print("Test 6 (non-empty tree): ");
        int expectedLeafCount1 = 4; // Leaf nodes: 13, 30, 47, 70
        int resultLeafCount1 = tree.numLeafNodes();
        System.out.println(resultLeafCount1 == expectedLeafCount1 ? "Passed" : "Failed");
    
        // Test 7: Leaf nodes count in an empty tree
        LinkedTree emptyTree = new LinkedTree();
        System.out.print("Test 7 (empty tree): ");
        int resultLeafCount2 = emptyTree.numLeafNodes();
        System.out.println(resultLeafCount2 == 0 ? "Passed" : "Failed");
    
        // Test 8: Leaf nodes count in a tree with only one node
        LinkedTree singleNodeTree = new LinkedTree();
        singleNodeTree.insertKeys(new int[]{10});
        System.out.print("Test 8 (single node tree): ");
        int resultLeafCount3 = singleNodeTree.numLeafNodes();
        System.out.println(resultLeafCount3 == 1 ? "Passed" : "Failed");
    
        System.out.println();
        // ----- Tests for deleteSmallest() -----
        System.out.println("----- Testing deleteSmallest -----");
    
        // Test 9: Deleting smallest from a non-empty tree
        System.out.print("Test 9 (first deletion): ");
        int expectedDeletedValue1 = 13;
        int resultDeletedValue1 = tree.deleteSmallest();
        System.out.println(resultDeletedValue1 == expectedDeletedValue1 ? "Passed" : "Failed");
        System.out.println("Tree after first deletion:");
        tree.levelOrderPrint();
        System.out.println();
    
        // Test 10: Deleting the next smallest from the tree
        System.out.print("Test 10 (second deletion): ");
        int expectedDeletedValue2 = 26;
        int resultDeletedValue2 = tree.deleteSmallest();
        System.out.println(resultDeletedValue2 == expectedDeletedValue2 ? "Passed" : "Failed");
        System.out.println("Tree after second deletion:");
        tree.levelOrderPrint();
        System.out.println();
    
        // Test 11: Deleting smallest from an empty tree
        System.out.print("Test 11 (empty tree): ");
        int resultDeletedValue3 = emptyTree.deleteSmallest();
        System.out.println(resultDeletedValue3 == -1 ? "Passed" : "Failed");
    
        // Test 12: Deleting smallest from a single-node tree
        System.out.print("Test 12 (single node tree): ");
        int expectedDeletedValue4 = 10;
        int resultDeletedValue4 = singleNodeTree.deleteSmallest();
        System.out.println(resultDeletedValue4 == expectedDeletedValue4 ? "Passed" : "Failed");
    }    
}
