package datastructures;

import animals.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalBinaryTree<T extends RescueAnimal> {
    
    //Internal node class for the binary tree structure
    private class TreeNode {
        T data;              // The animal data
        TreeNode left;      
        TreeNode right;      

        // constructor for tree node
        TreeNode(T animal) {
            this.data = animal;
            this.left = null;
            this.right = null;
        }
    }
    
    private TreeNode root;   // Root of the tree
    private int size;        // Number of animals in the tree
    
    // constructor for empty BT
    public AnimalBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    // inserts animal intro tree
    public void insert(T animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Cannot insert null animal");
        }
        
        root = insertRecursive(root, animal);
        size++;
    }
    
    // recursive helper
    private TreeNode insertRecursive(TreeNode node, T animal) {
        // Base case: found the insertion point
        if (node == null) {
            return new TreeNode(animal);
        }
        
        // Compare animals by name
        int comparison = animal.compareTo(node.data);
        
        if (comparison < 0) {
            // Insert in left subtree
            node.left = insertRecursive(node.left, animal);
        } else {
            // Insert in right subtree 
            node.right = insertRecursive(node.right, animal);
        }
        
        return node;
    }
    
    // searches for animal by name
    public T search(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        return searchRecursive(root, name.trim());
    }
    
    // recursive helper for search by name
    private T searchRecursive(TreeNode node, String name) {
        // Base case: not found
        if (node == null) {
            return null;
        }
        
        // Compare names (case-insensitive)
        int comparison = name.compareToIgnoreCase(node.data.getName());
        
        if (comparison == 0) {
            // Found the animal
            return node.data;
        } else if (comparison < 0) {
            // Search left subtree
            return searchRecursive(node.left, name);
        } else {
            // Search right subtree
            return searchRecursive(node.right, name);
        }
    }
    
    // searches for specific criteria
    public List<T> searchByCriteria(SearchCriteria<T> criteria) {
        List<T> results = new ArrayList<>();
        searchByCriteriaRecursive(root, criteria, results);
        return results;
    }
    
    // recursive helper for specific criteria
    private void searchByCriteriaRecursive(TreeNode node, SearchCriteria<T> criteria, List<T> results) {
        if (node == null) {
            return;
        }
        
        // Check current node
        if (criteria.matches(node.data)) {
            results.add(node.data);
        }
        
        // Recursively search both subtrees
        searchByCriteriaRecursive(node.left, criteria, results);
        searchByCriteriaRecursive(node.right, criteria, results);
    }
    
    // removes animal from tree
    public boolean remove(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        int originalSize = size;
        root = removeRecursive(root, name.trim());
        return size < originalSize; // Returns true if size decreased
    }
    
    // recursive helper for removal
    private TreeNode removeRecursive(TreeNode node, String name) {
        // Base case: animal not found
        if (node == null) {
            return null;
        }
        
        int comparison = name.compareToIgnoreCase(node.data.getName());
        
        if (comparison < 0) {
            // Remove from left subtree
            node.left = removeRecursive(node.left, name);
        } else if (comparison > 0) {
            // Remove from right subtree
            node.right = removeRecursive(node.right, name);
        } else {
            // Found the node to remove
            size--;
            
            // Case 1: Node has no children
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // Case 2: Node has one child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // Case 3: Node has two children
            // Find the inorder successor (smallest node in right subtree)
            TreeNode successor = findMin(node.right);
            
            // Replace node's data with successor's data
            node.data = successor.data;
            
            // Remove the successor
            node.right = removeRecursive(node.right, successor.data.getName());
            size++; // Adjust size since we decremented it above but only removing successor
        }
        
        return node;
    }
    
    // finds leftmost node
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    // gets all animals in tree - sorted
    public List<T> getAllSorted() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }
    
    // Performs in-order traversal to get sorted list
    private void inOrderTraversal(TreeNode node, List<T> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);   // Visit left subtree
            result.add(node.data);                 // Visit current node
            inOrderTraversal(node.right, result);  // Visit right subtree
        }
    }
    
    // gets animals available for service 
    public List<T> getAvailableAnimals() {
        return searchByCriteria(animal -> animal.isAvailable());
    }
    
    // gets animals by training status
    public List<T> getAnimalsByTrainingStatus(RescueAnimal.TrainingStatus status) {
        return searchByCriteria(animal -> animal.getTrainingStatus() == status);
    }
    
    // gets animals by country
    public List<T> getAnimalsByCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return searchByCriteria(animal -> 
            animal.getAcquisitionCountry().equalsIgnoreCase(country.trim()) ||
            animal.getInServiceCountry().equalsIgnoreCase(country.trim())
        );
    }
    
    // gets animals by age
    public List<T> getAnimalsByAgeRange(int minAge, int maxAge) {
        if (minAge < 0 || maxAge < 0 || minAge > maxAge) {
            return new ArrayList<>();
        }
        
        return searchByCriteria(animal -> 
            animal.getAge() >= minAge && animal.getAge() <= maxAge
        );
    }
    
    // checks if tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // gets size of tree
    public int size() {
        return size;
    }
    
    // gets height of tree
    public int getHeight() {
        return getHeightRecursive(root);
    }
    
    // recursive helper for tree height
    private int getHeightRecursive(TreeNode node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }
        
        int leftHeight = getHeightRecursive(node.left);
        int rightHeight = getHeightRecursive(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // clears all animals from tree
    public void clear() {
        root = null;
        size = 0;
    }
    
    // returns string representation
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Animal Tree";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Animal Binary Tree (Size: ").append(size).append(", Height: ").append(getHeight()).append(")\n");
        sb.append("Animals in alphabetical order:\n");
        
        List<T> sorted = getAllSorted();
        for (int i = 0; i < sorted.size(); i++) {
            sb.append(i + 1).append(". ").append(sorted.get(i).getName()).append("\n");
        }
        
        return sb.toString();
    }
    
    // interface for searching
    @FunctionalInterface
    public interface SearchCriteria<T> {
        boolean matches(T animal);
    }
}