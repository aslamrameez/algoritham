package org.algoritham.linkedlist;

public class Palindrom {

    public static void main(String[] args) {
        Palindrom p =  new Palindrom();
       
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(1);
        int ans = p.lPalin(node);

        System.out.println("Palindrom " + ans);
        
    }

    public int lPalin(ListNode A) {

        ListNode reverse =  reverseList(A);
        ListNode temp = A;
        while(temp !=null ){
            if(temp.val != reverse.val)return 0;
            temp = temp.next;
            reverse = reverse.next;
        }
 
        return 1;
     }
 
     public ListNode reverseList(ListNode A){
         ListNode rh = null, head = A;
         while(head!=null){
         ListNode ln =  new ListNode(head.val);
          if(rh == null){
            rh = ln;
          }else{
           ln.next = rh;
           rh = ln;
          }
           head = head.next; 
         }
         return rh;
     }
    
}
