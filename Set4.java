
/*
 * File: Set.java Date: 7/12/17 Author: Sid Chopra Purpose: This is the solution for HW 03 Problem
 * B.3
 */

package hw3;


public class Set implements Setish {

  private int SIZE = 10; // length of the array

  private int[] S; // array holding the set

  private int next; // pointer to next available slot in array


  public Set() {
    S = new int[SIZE]; // initializing constructor
    next = 0; // initializing the pointer
  }

  public Set(int[] A) {
    S = new int[SIZE]; // putting elements of S in A
    for (int i = 0; i < A.length; i++) {
      S[i] = A[i];
    }
    next = A.length;
  }

  public Set clone() {
    Set copy = new Set(); // created a new set
    for (int i = 0; i < next; i++) {
      copy.insert(S[i]);
    }
    return copy;
  }


  // This method reallocates the array S to twice as big and copies all the elements over.
  // It is called only by insert.

  private void resize() {
    int[] T = new int[SIZE * 2];
    for (int i = 0; i < S.length; ++i) {
      T[i] = S[i];
    }
    SIZE = SIZE * 2;
    S = T;
  }

  public String toString() {
    String s = "[";
    if (next != 0) {
      s = s + S[0];
    }
    for (int i = 1; i < next; i++) {
      s = s + "," + S[i];
    }
    s = s + "]";
    return s;
  }

  public int size() {
    return next;
  }

  public boolean isEmpty() {
    if (next != 0) {
      return false;
    }
    return true;
  }

  public boolean member(int k) {
    for (int i = 0; i <= next; i++) {
      if (S[i] == k) {
        return true;
      }
    }
    return false;
  }



  public boolean subset(Set T) {
    // if(T.length < next){
    // return false; }
    // else {
    for (int i = 0; i < next; i++) {
      if (member(i) == false) {
        return false;
      }
    }
    return true;
  }

  public boolean equal(Set T) {
    if ((subset(T) == true) && (T.subset(this) == true)) {
      return true;
    } else {
      return false;
    }
  }


  public void insert(int k) {
    if (member(k) != true) {
      if (next == S.length) {
        resize();
        next += 1;
      } else {
        S[next] = k;
        next += 1;
      }
    } else {
      if (k == 0) {
        S[next] = k;
        next = next + 1;
      }

    }
  }


  public void delete(int k) {
    if (member(k) != true) {
      ;
    } else {
      int place = 0;
      for (int i = 0; i < next; i++) {
        if (S[i] == k) {
          place = i;
          break;
        }
      }
      for (int j = place; j < next - 1; j++) {
        S[j] = S[j + 1];
      }
      next = next - 1;

    }
  }

  public Set union(Set T) {
    Set newc = new Set();
    Set copy = T.clone();
    for(int j = 0 ; j< next; j++) {
      newc.insert(S[j]);
      copy.delete(S[j]); 
    }  
     for(int k = 0; k<copy.next; k++) {
       if(newc.isFull() != true ) {
         newc.insert(S[i]);
       }
       else {
         ;
       }
    }
    return newc; 
    }

  public Set intersection(Set T) {
    Set newc = new Set(next);
    for(int i = 0; i<next; i++) {
      if(member(S[i]) == true) {
        newc.insert(S[i]);
      }
      else {
        ;
      } 
    }
    return newc; 
  }

  public Set setdifference(Set T) {
    Set newc = new Set(next);
    for(int i = 0; i<next; i++) {
      if(member(S[i]) == false ) {
        newc.insert(S[i]);
      }
      else {
        ;
      }
    }
    return newc; // just to get it to compile; replace null with something appropriate
  }

  public static void main(String[] args) {

    System.out.println("\nUnit Test for Set: note that your answers, when they are");
    System.out.println("  sets, could be in a different order (since order does");
    System.out.println("  not matter), this is the meaning of \"same set as...\"\n");

    Set A = new Set();
    Set B = new Set(new int[] {5});
    Set C = new Set(new int[] {5, 3, 7, 4, 1});
    Set D = new Set(new int[] {4, 3, -3, 10, 8});
    Set E = new Set(new int[] {8, 4, 10});
    Set F = new Set(new int[] {10, 8, 4});

    System.out.println("Test 01: Should be\n[]");
    System.out.println(A);
    System.out.println();

    System.out.println("Test 02: Should be\n[5]");
    System.out.println(B);
    System.out.println();

    System.out.println("Test 03: Should be same set as\n[5,3,7,4,1]");
    System.out.println(C);
    System.out.println();

    System.out.println("Test 04: Should be\n[]");
    System.out.println(A.clone());
    System.out.println();

    System.out.println("Test 05: Should be same set as\n[5,3,7,4,1]");
    System.out.println(C.clone());
    System.out.println();

    System.out.println("Test 06: Should be\n0");
    System.out.println(A.size());
    System.out.println();

    System.out.println("Test 07: Should be\n5");
    System.out.println(D.size());
    System.out.println();

    System.out.println("Test 08: Should be\ntrue");
    System.out.println(A.isEmpty());
    System.out.println();

    System.out.println("Test 09: Should be\nfalse");
    System.out.println(F.isEmpty());
    System.out.println();

    System.out.println("Test 10: Should be\nfalse");
    System.out.println(A.member(4));
    System.out.println();

    System.out.println("Test 11: Should be\ntrue");
    System.out.println(C.member(1));
    System.out.println();

    System.out.println("Test 12: Should be\nfalse");
    System.out.println(D.member(1));
    System.out.println();

    System.out.println("Test 13: Should be\ntrue");
    System.out.println(A.subset(D));
    System.out.println();

    System.out.println("Test 14: Should be\nfalse");
    System.out.println(D.subset(C));
    System.out.println();

    System.out.println("Test 15: Should be\ntrue");
    System.out.println(E.subset(D));
    System.out.println();

    System.out.println("Test 16: Should be\nfalse");
    System.out.println(D.subset(E));
    System.out.println();

    System.out.println("Test 17: Should be\nfalse");
    System.out.println(D.equal(E));
    System.out.println();

    System.out.println("Test 18: Should be\ntrue");
    System.out.println(E.equal(F));
    System.out.println();

    System.out.println("Test 19: Should be\ntrue");
    System.out.println(F.equal(E));
    System.out.println();

    System.out.println("Test 20: Should be\ntrue");
    System.out.println(A.equal(A));
    System.out.println();

    System.out.println("Test 21: Should be same set as\n[4,6]");
    Set A1 = A.clone();
    A1.insert(4);
    A1.insert(6);
    A1.insert(4);
    System.out.println(A1);
    System.out.println();

    System.out.println("Test 22: Should be same set as\n[10,8,4,5]");
    Set F1 = F.clone();
    F1.insert(5);
    F1.insert(4);
    System.out.println(F1);
    System.out.println();

    System.out.println("Test 23: Should be same set as\n[8,4,10]");
    Set E1 = E.clone();
    E1.insert(10);
    System.out.println(E1);
    System.out.println();

    System.out.println("Test 24: Should be\n[]");
    A1 = A.clone();
    A1.delete(5);
    System.out.println(A1);
    System.out.println();

    System.out.println("Test 25: Should be\n[]");
    Set B1 = B.clone();
    B1.delete(5);
    System.out.println(B1);
    System.out.println();

    System.out.println("Test 26: Should be same set as\n[8,4,10]");
    E1 = E.clone();
    E1.delete(5);
    System.out.println(E1);
    System.out.println();

    System.out.println("Test 27: Should be same set as\n[4,10]");
    E1 = E.clone();
    E1.delete(8);
    System.out.println(E1);
    System.out.println();

    System.out.println("Test 28: Should be same set as\n[3,4]");
    System.out.println(C.intersection(D));
    System.out.println();

    System.out.println("Test 29: Should be\n[8,4,10]");
    System.out.println(E.intersection(F));
    System.out.println();

    System.out.println("Test 30: Should be same set as\n[]");
    System.out.println(A.intersection(F));
    System.out.println();

    System.out.println("Test 31: Should be same set as\n[]");
    System.out.println(B.intersection(F));
    System.out.println();

    System.out.println("Test 32: Should be same set as\n[4,3,-3,10,8,5,7,1]");
    System.out.println(C.union(D));
    System.out.println();

    System.out.println("Test 33: Should be same set as\n[10,8,4]");
    System.out.println(E.union(F));
    System.out.println();

    System.out.println("Test 34: Should be same set as\n[10,8,4]");
    System.out.println(A.union(F));
    System.out.println();

    System.out.println("Test 35: Should be same set as\n[5,3,7,4,1]");
    System.out.println(C.union(B));
    System.out.println();

    System.out.println("Test 36: Should be same set as\n[5,7,1]");
    System.out.println(C.setdifference(D));
    System.out.println();

    System.out.println("Test 37: Should be same set as\n[]");
    System.out.println(E.setdifference(F));
    System.out.println();

    System.out.println("Test 38: Should be same set as\n[5,3,7,4,1]");
    System.out.println(C.setdifference(A));
    System.out.println();

    System.out.println("Test 39: Should be same set as\n[]");
    System.out.println(C.setdifference(C));
    System.out.println();

    System.out.println(
        "Test 40: Should be same set as\n[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]");
    Set G = new Set();
    for (int i = 0; i < 32; ++i) {
      G.insert(i);
    }
    System.out.println(G);
    System.out.println();

  }
}

