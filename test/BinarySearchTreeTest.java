import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    // Test insertion into an empty tree
    @Test
    void testInsertIntoEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);

        // Check the tree by in-order traversal
        assertEquals("10", bst.inOrderTraversal());  // Tree should have one value: "10"
    }

    // Test insertion into a non-empty tree
    @Test
    void testInsertIntoNonEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // In-order traversal should return values in sorted order
        assertEquals("5, 10, 15", bst.inOrderTraversal());  // In-order should return "5, 10, 15"
    }

    // Test insertion of larger values (right side of BST)
    @Test
    void testInsertLargerValues() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);

        // In-order traversal should return values in sorted order
        assertEquals("10, 15, 20", bst.inOrderTraversal());  // In-order should return "10, 15, 20"
    }

    // Test insertion of smaller values (left side of BST)
    @Test
    void testInsertSmallerValues() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);

        // In-order traversal should return values in sorted order
        assertEquals("3, 5, 10", bst.inOrderTraversal());  // In-order should return "3, 5, 10"
    }

    // Test the height of the tree (max depth)
    @Test
    void testHeight() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        // Height is 2 (longest path from root to leaf)
        assertEquals(3, bst.height());
    }

    // Test searching for an existing value
    @Test
    void testSearchExistingValue() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // Search for an existing value
        assertTrue(bst.search(5));  // Value 5 should exist in the tree
        assertTrue(bst.search(10)); // Value 10 should exist in the tree
        assertTrue(bst.search(15)); // Value 15 should exist in the tree
    }

    // Test searching for a non-existing value
    @Test
    void testSearchNonExistingValue() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // Search for a non-existing value
        assertFalse(bst.search(100));  // Value 100 should not exist in the tree
    }

    // Test finding the minimum value in the tree
    @Test
    void testMinValue() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        // The minimum value should be 3
        assertEquals(3, bst.findMin());
    }

    // Test finding the maximum value in the tree
    @Test
    void testMaxValue() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(20);
        // The maximum value should be 20
        assertEquals(20, bst.findMax());
    }

//    // Test that the in-order traversal returns sorted values
    @Test
    void testInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        // In-order traversal should return sorted values: "3, 5, 10, 15"
        assertEquals("3, 5, 10, 15", bst.inOrderTraversal());
    }

    @Test
    void testDeleteLeafNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        // Deleting a leaf node (3)
        bst.delete(3);

        // After deletion, 3 should be gone and the tree should look like:
        //        10
        //       /  \
        //      5    15
        //       \
        //        7
        assertFalse(bst.search(3));  // 3 should not be found
        assertTrue(bst.search(7));   // 7 should still be in the tree
    }

    @Test
    void testDeleteNodeWithOneChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);

        // Deleting a node with one child (5 has one child, 7)
        bst.delete(5);

        assertFalse(bst.search(5));  // 5 should not be found
        assertTrue(bst.search(7));   // 7 should now be a direct child of 10
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        // Deleting a node with two children (10 has two children: 5 and 15)
        bst.delete(5);

        // After deletion, 10 should be replaced by its in-order successor (15 in this case),
        // so the tree should look like:
        //        15
        //       /
        //      5
        //     / \
        //    3   7
        assertFalse(bst.search(5));  // 10 should not be found
        assertTrue(bst.search(15));   // 15 should now be the root
        assertTrue(bst.search(7));
    }

    @Test
    void testDeleteRootNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // Deleting the root node (10)
        bst.delete(10);

        // After deletion, 10 should be removed and the tree should look like:
        //        5
        //         \
        //         15
        assertFalse(bst.search(10));  // 10 should not be found
        assertTrue(bst.search(5));    // 5 should now be the root
        assertTrue(bst.search(15));   // 15 should still be present
    }

    @Test
    void testDeleteNonExistentNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // Try deleting a node that doesn't exist (20)
        bst.delete(20);

        // After attempting to delete 20, the tree should remain unchanged:
        assertTrue(bst.search(10));   // 10 should still be present
        assertTrue(bst.search(5));    // 5 should still be present
        assertTrue(bst.search(15));   // 15 should still be present
    }

    @Test
    void testIsEmptyOnNewTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.isEmpty()); // A new tree should be empty
    }

    @Test
    void testIsEmptyAfterInsertion() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        assertFalse(bst.isEmpty()); // Tree should not be empty after insertion
    }

    @Test
    void testIsEmptyAfterDeletion() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.delete(10);
        assertTrue(bst.isEmpty()); // Tree should be empty after deleting the only element
    }

    @Test
    void testSizeOnNewTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals(0, bst.size()); // New tree should have size 0
    }

    @Test
    void testSizeAfterInsertions() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        assertEquals(3, bst.size()); // Three nodes inserted
    }

    @Test
    void testSizeAfterDeletion() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.delete(5);
        assertEquals(2, bst.size()); // One node deleted, so size should be 2
    }

    @Test
    void testSizeAfterDeletingAll() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.delete(10);
        bst.delete(5);
        assertEquals(0, bst.size()); // All nodes deleted, size should be 0
    }

}
