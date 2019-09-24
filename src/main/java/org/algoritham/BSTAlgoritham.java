package org.algoritham;

public class BSTAlgoritham {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
		
		Node root = convertToBST(arr, 0, arr.length -1);
		printTree(root);
	}

	private static void printTree(Node root) {
		if(root == null) return;
		
		System.out.println(root.data);
		printTree(root.left);

		printTree(root.right);
		}

	private static Node convertToBST(int[] arr, int l, int h) {
		
		if(l <= h) {
			
		int mid = (l+ h)/2;
		
		Node root = new Node(arr[mid]);
		
		root.left = convertToBST(arr, l, mid-1);
		
		root.right = convertToBST(arr, mid+1, h);
		
		return root;
		}
		
		return null;
	}

}