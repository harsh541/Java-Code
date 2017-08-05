package hw5;

/*
 * File: IntDeque.java Date: Jul 19, 2017 Author: Sid Chopra Class: CS 112, Summer 2, 2017 Purpose:
 * This is a solution for HW 05, Problem B.2.
 */

public class IntDeque {

  private int SIZE = 10;
  private int[] A = new int[SIZE];
  private int next = 0;
  private int front = 0;
  private int size = 0;


  public void resize() {
    int[] B = new int[SIZE * 2]; // allocate an array B twice as big as A
    for (int i = 0; i < SIZE; i++) {
      B[i] = dequeueFront();
    }

    front = 0;
    next = SIZE;
    size = SIZE;
    SIZE = SIZE * 2;
    A = B; // replacing A with B

  }

  public int size() {
    return size;
  }

  public int nextSlot(int k) {
    return ((k + 1) % SIZE);
  }

  public int previousSlot(int k) {
    if (k == 0) {
      return SIZE - 1;
    }
    return k - 1;
  }

 
  public void enqueueFront(int k) {
    if (size >= SIZE) {
      resize();
    }
    front = previousSlot(front);
    A[front] = k;
    size++;
  }

  public int dequeueFront() throws QueueUnderflowException{
    if( isEmpty() ) {
      throw new QueueUnderflowException("Q Underflew!");
    }
    int z = A[front];
    front = nextSlot(front);
    size--;
    return z;
  }

  public void enqueueRear(int k) {
    if (size >= SIZE) {
      resize();
    }
    A[next] = k;
    next = nextSlot(next);
    size++;
  }

  public int dequeueRear() throws QueueUnderflowException{
    if( isEmpty() ) {
      throw new QueueUnderflowException("Q Underflew!");
    }
    next = previousSlot(next);
    int z = A[next];
    size--;
    return z;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public String toString() {
    String t = "]";
    for (int i = 0; i < SIZE; i++) {
      if (i == 0) {
        t = A[i] + t;
      } else {
        t = A[i] + ", " + t ;
      }


    }
    t = "[" + t;
    t = t + "  length: " + A.length + "  size: " + size + "  front: " + front + "  next: " + next;
    return t;
  }

  class QueueUnderflowException extends Exception {
    public String text;
    public QueueUnderflowException(String text) {
    this.text = text; 
    }
  }
  
  // Unit Test (you must complete this with additional tests as indicated)

  public static void main(String[] args) {

    IntDeque D = new IntDeque();

    System.out.println("\n[1] First test toString on empty dequeue... Should print out:");
    System.out.println("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]  length: 10  size: 0  front: 0  next: 0");
    System.out.println(D);

    System.out.println("\n[2] Test size and isEmpty... Should print out:\n0  true");
    System.out.println(D.size() + "  " + D.isEmpty());

    System.out.println("\n[3] Test enqueueRear.... Should print out:"
        + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 4  front: 0  next: 4");
    D.enqueueRear(1);
    D.enqueueRear(2);
    D.enqueueRear(3);
    D.enqueueRear(4);

    System.out.println(D);

    System.out.println("\n[4] Test size and isEmpty again... Should print out:\n4  false");
    System.out.println(D.size() + "  " + D.isEmpty());

    System.out.println("\n[5] Test dequeueFront.... Should print out:" + "\nn = 1  m = 3");
    try {
    int n = D.dequeueFront();
    D.dequeueFront();
    int m = D.dequeueFront();    
    System.out.println("n = " + n + "  m = " + m);
    
    


    System.out.println("\n[6] And should print out:"
        + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 1  front: 3  next: 4");
    System.out.println(D);


    System.out.println("\n[7] Test wrap-around of enqueueRear .... Should print out:"
        + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 10  front: 3  next: 3");

    for (int i = 5; i < 14; ++i)
      D.enqueueRear(i);

    System.out.println(D);

    System.out.println("\n[8] Test wrap-around of dequeueFront .... Should print out:"
        + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 0  front: 3  next: 3  m = 13");

    for (int i = 0; i < 9; ++i)
      D.dequeueFront();
    m = D.dequeueFront();
    System.out.println(D + "  m = " + m);


    // Write some temporary tests to make sure that previousSlot(...) works properly; test it
    // especially
    // to make sure that it returns the correct value when you call previousSlot( 0 ).
    // Delete these test after you are sure that this method works.

    // Test 9: Test enqueue front by inserting several numbers in front and printing out the queue
    System.out.println("\n[9] Test enqueueFront .... Should print out:" 
    + " \n[10, 9, 8, 7, 6, 5, 4, 1, 2, 3]  length: 10  size: 3  front: 0  next: 3") ; 
        D.enqueueFront(1);
        D.enqueueFront(2);
        D.enqueueFront(3);
   System.out.println(D);     
       
    // Test 10: Test the size and isempty again
   
   System.out.println("\n[10] Test size and isEmpty.... Should print out: \n3 false");
   System.out.println(D.size + " " + D.isEmpty());

   // Test 11: Test dequeue rear by removing some elements, printing them out, and printing the
   // queue
  
   System.out.println("\n[11] Test dequeueRear.... Should print out: \nn = 1 m = 3");
  
   n = D.dequeueRear();
   D.dequeueRear();
   m = D.dequeueRear();
   
   System.out.println("n = " + n + " m = " + m);
   
   
    // Test 12: test wrap-around of enqueue rear and dequeue front by enqueueing several elements in
    // rear until it goes past gap between ends of the array.

   System.out.println("\n[12] should print out:"
       +"\n[13, 9, 8, 7, 6, 5, 4, 6, 11, 12]  length: 10  size: 0  front: 0  next: 0");

       D.enqueueRear(5);
       D.dequeueFront();
       D.enqueueRear(7);
       D.dequeueFront();
       D.enqueueRear(6);
       
       D.enqueueFront(11);
       D.enqueueFront(12);
       D.enqueueFront(13);
       System.out.println(D); 
      
    // Test 13: Test all four methods together by alternately removing and adding from both ends
    // and print out the queue to make sure it worked.

    // Test 14: Test size to make sure it works with all four

    // Test 15: test resizing by inserting enough elements to trigger a resize to size 20 and print
    // out

    // Test 16: test that enqueue and dequeue (all four) work after resize by alternately removing
    // and adding from both ends
    // and print out the queue to make sure it worked.

    // Test 17: Test size to make sure it works after the resize

    // Test 18: Test exceptions by removing all elements from queue and then doing one more
    // dequeueRear and showing how it prints out a message

    // Test 19: Do the same for dequeueFront

    // Strong suggestion for tests 18 and 19: Put a try block around the whole main method
    // up to and including test 18, and then you can make sure that test 18 is correct; then
    // put a separate try block around test 19. It is important to test each of these separately
    // and you can't do that if you use only one try block for the whole main method.
    }
       catch( QueueUnderflowException e ) { 
         System.out.println(e.text); 
       }

  }
}
