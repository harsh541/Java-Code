/* File: IntStack.java
 * Date: 9/27/16
 * Author:  Wayne Snyder (waysnyder@gmail.com)
 * Class: CS 112, Fall 2016
 * Purpose: Example of Stack to hold integers; resizes if overflow would occur
 */

package hw4; 

public class BigIntStack {
    
    private final int INITIAL_LENGTH = 10;
    private BigInt[] S = new BigInt[INITIAL_LENGTH];     // array holding the stack, bottom at 0
    private int next = 0;                          // next available slot in the array
    
    // Insert a new element on the top of the stack
    // If stack is full, resizes
    
    public void push(BigInt n) {
        if(next == S.length) {
            resize();
        }
        S[next] = n;
        ++next;
    }
    
    // Remove and return the top element of stack
    // Note: Does not check for underflow
    
    public BigInt pop() {
        --next;
        return S[next];
    }
    
    // Return top element of stack without removing it
    // Note: Does not check for underflow
    
    public BigInt peek() {
        return S[next-1];
    }
    
    // Return the number of integers in the stack
    
    public int size() {
        return next;
    }
    
    // Return true iff there are no elements in the stack
    
    public boolean isEmpty() {
        return next == 0;
    }
    
    // replace S by array twice as big, but with same elements
    
    private void resize() {
        BigInt[] T = new BigInt[ S.length * 2 ];
        for (int i = 0; i < S.length; ++i) {
            T[i] = S[i];
        }
        S = T;
    }
    
    // Unit test Main
    
    public static void main(String[] args) {
        BigIntStack S = new BigIntStack();
        
        System.out.println("Unit Test for IntStack");
   S.push(new BigInt ("1"));
   S.push(new BigInt ("2"));
   S.push(new BigInt ("3"));
   System.out.println(S.pop());
   System.out.println(S.peek());
   
  
        
    }
}
    

