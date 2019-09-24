package org.algoritham;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;

public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		 // Let us create binary tree shown in above diagram 
	       /*               1 
	                   /     \ 
	                  2       3 
	                /   \       \ 
	               4     5       6 
	        */
	          
	        Node root = new Node(1); 
	        root.left = new Node(2); 
	        root.right = new Node(3); 
	        root.left.left = new Node(4); 
	        root.left.right = new Node(5); 
	        root.right.right = new Node(6); 
	        
	       // levelOrderTravel(root);
	       // flatternTree(root);
	        
	        flatten(root);
	        print(root);
	}
	
	// Function to convert binary tree into 
	// linked list by altering the right node 
	// and making left node point to NULL 
	private static void flatten(Node root) {
		 if (root == null || root.left == null && 
                 root.right == null) { 
               return; 
          }
		 
		 if (root.left != null) { 
			 flatten(root.left);
			 
			 Node temp = root.right;
			 root.right = root.left;
			 root.left = null;
			 
			 Node node = root.right;
			 while(node.right !=null) {
				 node = node.right;
			 }
			 node.right = temp;
		 }
		 flatten(root.right); 
	}

	private static void flatternTree(Node root) {
	
		Queue<Node> stack  = new LinkedList<>();
		travel(root, stack);
		if(stack.isEmpty())
			return ;
		Node parent = stack.remove();
		parent.left = null;
		Node next = parent;
		while(!stack.isEmpty()) {
		    Node node =	stack.remove();
		    next.right = node;
		    next = node;
		    node.left =null;
		}
		next.right = null;
		Node travel = parent;
		 print(travel);
	}

	private static void print(Node travel) {
		while(travel != null) {
			System.out.print(travel.data);
			travel = travel.right;
		}
	}
	
	static void travel(Node root, Queue<Node> stack) {
		if(root == null)
			return;
		
		stack.add(root);
		travel(root.left, stack);
		travel(root.right, stack);
		
	}
      

	public static void levelOrderTravel(Node root) {
		
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			while(size > 0) {
			
				Node node =  queue.poll();
				
				System.out.print(node.data);
				if(node.left != null) {
					queue.add(node.left)	;
				}
				
				if(node.right != null) {
					queue.add(node.right)	;
				}
				size--;
			}
			
			System.out.println();
			
		}
		
	}

}
