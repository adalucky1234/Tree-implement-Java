/**
This algorithm is to implement in order traversal of tree using one stack.
First, if root != null, then push root into stack.
Then, iteratively check its left child is null, if not, push into stack, update it to its left child, until root reaches null.
When reach a point that a root doesn't have left child, pop stack, mark as tmp, add to list, then see if tmp has right child.
If tmp's right child is not null, then recursively call this function.

The example tree is as following: using this algorithm, we get the expected result: 6 -1 10 2 9 1 7 4 8 3 5 

               1
            /     \
           2       3
         /  \     / \
        6   9    4   5
         \      / \
          10   7   8
          /
         -1
*/

import java.util.*;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(10);
        root.left.left.right.left = new TreeNode(-1);
        root.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        //ArrayList<Integer> list = s.StackList(root);
        solution.inOrderTraversal(root);
        /*while (!solution.s.isEmpty()) {
            TreeNode t = solution.s.pop();
            solution.list.add(t.val);
        }*/
        for (int i = 0 ; i < solution.list.size(); i++) System.out.print(solution.list.get(i) + " ");
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    Stack<TreeNode> s = new Stack<>();
    TreeNode tmp = null;
    ArrayList<Integer> list = new ArrayList<>();

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        s.push(root);   // First, if root != null, then push root into stack.
        while (root.left != null) {  //Then, iteratively check its left child is null,
            s.push(root.left);       //if not, push into stack, update it to its left child, until root reaches null
            root = root.left;
            if (root == null) break;
        }
        while (!s.isEmpty()) {
            tmp = s.pop(); // when root doesn't have left child, pop stack, mark as tmp, add to list
            list.add(tmp.val);
            if (tmp.right != null) {  // If tmp's right child is not null, then recursively call this function.
                inOrderTraversal(tmp.right);
            }
        }
    }
}
