package hw6;

/* File: RecursiveLinkedLists.java
 * Author: Sid Chopra (sidc96@bu.edu)
 * Date: JUL 24 2017
 * Purpose: This is the solution for Problem 2 in HW 06 in CS 112, Summer 2, 2017.  
 */

public class RecursiveLinkedLists {

    public static Node copy( Node p ) {
        if( p == null ) {
            return null;
        } 
        else {
            return new Node(p.item, copy( p.next )); 
        }
    } 
    
    public static Node arrayToLinkedList(int[] A) {
        return atlhelper(A,0);
    }
    
    private static Node atlhelper(int [] A, int i) {
      if(i>=A.length) {
        return null;
      }
      else {
        return new Node((A[i]), atlhelper(A, (i+1)));
      }   
    }
    
    public static int count(int n, Node p) {
        if( p == null)  
          return 0 ;
        else if (n == p.item) {
       return count(n,p.next) + 1 ; 
        }
        else {
          return count(n,p.next) ; 
    }}

    public static double mean(Node p) {
    return meanhelper(p,0,0);
       
    }
   private static double meanhelper( Node p, int sum, int c) {
     if(p == null)
       return (double)sum/c;
    else 
       return meanhelper(p.next, sum + p.item, c + 1); 
}
    
    
    public static Node deleteNth(Node p, int n ) {
        if( p == null)                     // if the list is ordered use:  ( p == null || p.item > k )
           return p; 
        else if ( n == 0 ) 
           return p.next;               // if you want to delete all instances, use:  return deleteItem( k, p.next );  
        else {
           p.next = deleteNth(p.next,n-1 ); 
           return p; 
        }}
       
    // Problem B.2.E
    
    public static Node everyOther(Node p) {
      if( p == null)                     // if the list is ordered use:  ( p == null || p.item > k )
        return null; 
     else if ( p.next == null ) 
        return p;               // if you want to delete all instances, use:  return deleteItem( k, p.next );  
     else {
     p.next = everyOther(p.next.next) ;
    return p;
    }}
    
    // Problem B.2.F
    
    public static boolean equalLists(Node p,Node q) {
      if(p == null && q == null) 
        return true;
      else if (p==null || q==null)
        return false;
      else if (p.item!=q.item)
        return false;
      else 
         return equalLists(p.next,q.next);     
    }    
    
    // Problem B.2.G
    
    public static boolean prefix(Node p, Node q)  {
      if(p == null && q == null) 
        return true;
      else if(p == null) 
        return true;
      else if(q==null)
        return false;
      else if(p.item != q.item)
        return false;
      else 
       return prefix(p.next,q.next);
    }
    
    // Problem B.2.H
    
    public static boolean sublist(Node p, Node q)  {
        if (p==null)
          return true;
        else if (q==null)
          return false;
        else if(prefix(p,q))
          return true;
          else
           return sublist(p,q.next);     
    }
    
    
    // Problem B.2.I
    
    public static Node splice(int n, Node p, Node q)  {
        if(p==null)
          return q;
        if(q==null)
          return p;
        else if(n == 0) {
          q.next = splice(0, p, q.next);
          return q;}
          else {
            p.next = splice(n-1, p.next, q);
            return p;
        }
    }     
    
    public static Node intersection(Node p,Node q) {
       if(p == null || q == null) 
         return null;
       else if(p.item < q.item)
         return intersection(p.next,q);
       else if(p.item > q.item)
         return intersection(p,q.next);
       else
         return new Node(p.item,intersection(p.next,q.next));
    }
    
    
    
    public static void main(String [] arg) {
        
         Node head = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );
         
         // Sample tests just to show how toString() prints out lists (note that empty lists are null,
         // so there is no toString() to call on a null pointer, and it just prints "null")
         
         System.out.println("\nTest x:  should print out:\n -> 3 -> 6 -> 9 -> 12 -> null");
         System.out.println(head); 
         
         head = null; 
         System.out.println("\nTest xx:  should print out:\nnull");
         System.out.println(head); 
         
        // your tests here 
         int[] B = {2,5,4,6,2};
         Node b = arrayToLinkedList(B);
         System.out.println(count(2,b));
         
         System.out.println(mean(b));
         
         int[] A = {2,5,4,6,2,9};
         Node a = arrayToLinkedList(A);
         System.out.println("\nTest 09  deleteNth:  should print out:\n -> 2 -> 5 -> 6 -> 2 -> 9 -> null");
         System.out.println(deleteNth(copy(a),2));

         System.out.println(everyOther(a));
         
         
         int[] S  = {5,9,1};
         int[] D  = {5,9,1};
         int[] F  = {5,9};
         int[] G  = {1,6,6};
         int[] H  = {};
         Node s = arrayToLinkedList(S);
         Node d = arrayToLinkedList(D);
         Node f = arrayToLinkedList(F);
         Node g = arrayToLinkedList(G);
         Node h = arrayToLinkedList(H);
         
         System.out.println(equalLists(s,d));
         System.out.println(equalLists(s,f));
         
      
         
         System.out.println("\nTest 10  prefix:  should print out: \ntrue");
         System.out.println(prefix(s,d));
         System.out.println("\nTest 11  prefix:  should print out: \ntrue");
         System.out.println(prefix(f,d));
         System.out.println("\nTest 12  prefix:  should print out: \nfalse");
         System.out.println(prefix(s,f));
         System.out.println("\nTest 13  prefix:  should print out: \ntrue");
         System.out.println(prefix(h,a));
         System.out.println("\nTest 14  prefix:  should print out: \nfalse");
         System.out.println(prefix(g,h));
         System.out.println("\nTest 15  prefix:  should print out: \ntrue");
         System.out.println(prefix(h,null));
         
         System.out.println(sublist(f,s));
         System.out.println(sublist(d,s));
         System.out.println(sublist(g,s));
         System.out.println(splice(1,copy(g),copy(f)));
         
         int[] C  = {1,2,3};
         int[] V  = {2,3,4};
         Node c= arrayToLinkedList(C);
         Node v = arrayToLinkedList(V);
         System.out.println("\ntest20 " + intersection(c,v));
         
    }
    
}

// This is the Node class used in the code above; it is visible anywhere in 
// the current package (directory)

class Node {
        int item;
        Node next;

        public Node(int n, Node p) {
            item = n; next = p;
        }

        public String toString() {
            if (this.next == null) {
                return " -> " + this.item + " -> null";
            }
            else {
                return " -> " + this.item + next;
            }
        }
    }


