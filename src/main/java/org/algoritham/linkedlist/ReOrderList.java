package org.algoritham.linkedlist;

public class ReOrderList {


    public static void main(String[] args) {
        ReOrderList reOrderList =  new ReOrderList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        ListNode list = reOrderList.reorderList(node);
        while(list != null){
          System.out.print(list.val + "  ");
          list = list.next;
        }
    }

    public ListNode reorderList(ListNode A) {
        ListNode slow = A, fast = A;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
       return merge(A, reverseList(slow));
     }

     public ListNode merge(ListNode A, ListNode rl){
        ListNode rh = null, tail = null;
        ListNode p1 = A, p2 = rl;
        boolean reverse = true;
        while(p1 != null && p2 !=null){
           if(reverse){
            if(rh == null){
                rh = p1;
                tail = rh;
            }else{
                tail.next = p1;
                tail = tail.next;
              }
              p1 = p1.next;
           }else{
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
           }
           reverse = !reverse;
        }

        return rh;
     }
 
     public ListNode reverseList(ListNode A){
         ListNode temp = A, rh = null;
         while(temp != null){
           ListNode temp1 = temp.next;
           temp.next = rh;
           rh = temp;
           temp = temp1;
         }
       return rh;
     }
    
}
