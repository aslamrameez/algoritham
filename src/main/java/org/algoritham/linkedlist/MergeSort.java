package org.algoritham.linkedlist;

public class MergeSort {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(4);
        MergeSort mergeSort =  new MergeSort();
        ListNode ans =  mergeSort.mergeSort(node);
        while(ans != null ){
            System.out.print(ans.val+"  " );
            ans = ans.next;
        }
        
    }

    public ListNode mergeSort(ListNode A){
        if(A == null || A.next == null) return A;
        ListNode fast = A, slow = A, temp =A;
         while(fast !=null && fast.next !=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
         }
       temp.next = null;
       ListNode left = mergeSort(A);
       ListNode right = mergeSort(slow);
       ListNode ans = mergeTwoLists(left, right);
       return ans;
     }
 
      public ListNode mergeTwoLists(ListNode A, ListNode B) {
 
         ListNode head = null;
         ListNode p1 = A, p2 = B;
         if(A.val > B.val){
             head = B;
             p2 = p2.next;
         }else{
             head = A;
             p1 = p1.next;
         }
         ListNode tail = head;
         while(p1 != null && p2 != null){
             if(p1.val > p2.val){
                 tail.next = p2;
                 p2 = p2.next;
             }else{
                 tail.next = p1;
                 p1 = p1.next;  
             }
           tail = tail.next;
         }
         if(p1 != null){
             tail.next = p1;
         }
         if(p2 != null){
             tail.next = p2;
         }
 
         return head;
     }
    
}
