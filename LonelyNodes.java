import java.util.*;

public class LonelyNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the tree as a list (e.g., [1, 2, 3, null, 4]):");
        String input = scanner.nextLine().trim();
        
        // Parse the input to create the tree
        TreeNode root = buildTree(input);

        System.out.println("Lonely nodes in the binary tree:");
        findLonelyNodes(root);
        scanner.close();
    }

    // Method to build the binary tree from the input list
    private static TreeNode buildTree(String input) {
        // Remove square brackets and split by commas
        input = input.replaceAll("\\[|\\]", "").trim();
        if (input.isEmpty()) return null;

        String[] nodes = input.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Add left child if not null
            if (i < nodes.length && !nodes[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(current.left);
            }
            i++;

            // Add right child if not null
            if (i < nodes.length && !nodes[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i].trim()));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void findLonelyNodes(TreeNode node) {
        // Base case: If the node is null, return
        if (node == null) {
            return;
        }

        // Check if the node has only one child
        if (node.left != null && node.right == null) {
            System.out.print(node.left.val + " "); // Print lonely left child
        } else if (node.right != null && node.left == null) {
            System.out.print(node.right.val + " "); // Print lonely right child
        }

        // Recur for left and right subtrees
        findLonelyNodes(node.left);
        findLonelyNodes(node.right);
    }
}
