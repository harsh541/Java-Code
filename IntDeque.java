/*
 * File: LinkedListPractice.java 
 * Author: Harsh Patel
 * Date: July 18th, 2017 
 * Purpose: This is the solution for HW 05, Problem B.2.
 */



public class IntDeque {

	private int SIZE = 10;
	private int[] A = new int[SIZE];
	private int front = 0;
	private int next = 0;
	private int counter = 0;

	
	

	// return the number of ints currenting being stored in the queue
	public int size() {
		return counter;
	}
	
	public void resize() {
		int count = 0;
		int[] array = new int[SIZE * 2]; // make array twice as long as A
		for (int a = 0, b = front; a < SIZE; ++a, b = nextSlot(b)) {
			count++;
			array[a] = A[b];

			if (count == 10) {
				count++; // double count count

			} else { //do nothing.

			}

		}

		front = 0;
		next = counter;
		SIZE = SIZE * 2;
		A = array; // Switch A with array

	}
	public int nextSlot(int a) {
		return ((a + 1) % SIZE);
	}

	public int previousSlot(int a) {
		if (a == 0) {
			return SIZE - 1;
		}
		return a - 1;
	}

	// Places new int at front of queue
	public void enqueueFront(int a) {
		int i = 0;
		if(counter == SIZE) {
			i++;
		}
		if (counter >= SIZE) {
			resize();
		} else {
			;
		}
		front = previousSlot(front);
		A[front] = a;
		++counter;
	}

	// Takes off the int at the front of the queue and return it
	public int dequeueFront() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue Underflew!");
		} else {
			;
		}
		int value = A[front];
		front = nextSlot(front);
		--counter;
		return value;
	}

	// place a new int at the rear of the queue
	public void enqueueRear(int k) {
		int countt = 0;
		if (counter >= SIZE) {
			resize();
		} else {
			countt++;
		}
		A[next] = k;
		next = nextSlot(next);
		++counter;
	}

	
	// return true if the size is 0, and false otherwise
	public boolean isEmpty() {
		if (counter != 0) {
			return false;
		}
		return true;
	}
	
	// Take out the int at the back of the queue and return it
		public int dequeueRear() throws QueueUnderflowException {
			if (isEmpty()) {
				int count = 0;
			} else {
				;
			}
			if (isEmpty()) {
				throw new QueueUnderflowException("Queue Underflew!");
			}
			next = previousSlot(next);
			int z = A[next];
			--counter;
			return z;
		}

	// Return a string of dequeue.
	public String toString() {
		String bracket = "]";
		for (int a = 0; a < SIZE; a++) {
			if (a == 0) {
				bracket = A[a] + bracket;
			} else {
				bracket = A[a] + ", " + bracket;
			}

		}
		bracket = "[" + bracket;
		bracket = bracket;
		bracket = bracket + "  length: " + A.length + "  size: " + counter + "  front: " + front + "  next: " + next;
		return bracket;
	}

	class QueueUnderflowException extends Exception {
		public String text;
		

		public QueueUnderflowException(String text) {
			this.text = text;
		}
	}



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

			// Write some temporary tests to make sure that previousSlot(...) works
			// properly; test it
			// especially
			// to make sure that it returns the correct value when you call previousSlot( 0
			// ).
			// Delete these test after you are sure that this method works.

			// Test 9: Test enqueue front by inserting several numbers in front and printing
			// out the queue
			System.out.println("\n[9] Test enqueueFront .... Should print out:"
					+ " \n[10, 9, 8, 7, 6, 5, 4, 9, 8, 7]  length: 10  size: 3  front: 0  next: 3");
			
			D.enqueueFront(9);
			
			D.enqueueFront(8);
			
			D.enqueueFront(7);
			//this will print out the rest of the test 9.
			System.out.println(D);

			// Test 10: Test the size and isempty again

			System.out.println("\n[10] Test size and isEmpty.... Should print out: \n3 false");
			System.out.println(D.counter + " " + D.isEmpty());

			// Test 11: Test dequeue rear by removing some elements, printing them out, and
			// printing the
			// queue

			System.out.println("\n[11] Test dequeueRear.... Should print out: \nn = 9 m = 7");

			n = D.dequeueRear();
			D.dequeueRear();
			m = D.dequeueRear();

			System.out.println("n = " + n + " m = " + m);

			// Test 12: test wrap-around of enqueue rear and dequeue front by enqueueing
			// several elements
			// in
			// rear until it goes past gap between ends of the array.

			System.out.println("\n[12] Test wrap around of enqueueRear and dequeueFront... Should print out:"
					+ "\n[6, 9, 8, 7, 6, 5, 4, 3, 4, 5]  length: 10  size: 4  front: 9  next: 3");

			D.enqueueRear(1);
			D.dequeueFront();
			D.enqueueRear(2);
			D.dequeueFront();
			D.enqueueRear(3);

			D.enqueueFront(4);
			D.enqueueFront(5);
			D.enqueueFront(6);
			System.out.println(D);

			// Test 13: Test all four methods together by alternately removing and adding
			// from both ends
			// and print out the queue to make sure it worked.

			System.out.println("\n[13] Test all four methods together... Should print out:" + "\n10 2 16");

			D.enqueueRear(5);
			D.enqueueFront(4);
			D.enqueueRear(16);
			D.enqueueFront(3);
			D.enqueueRear(10);
			D.enqueueFront(2);
			System.out.print(D.dequeueRear() + " ");
			System.out.print(D.dequeueFront() + " ");
			System.out.println(D.dequeueRear() + " ");

			// Test 14: Test size to make sure it works with all four

			System.out.println("\n[14] Test size... Should print out:" + "\n7");
			System.out.println(D.counter + " ");

			// Test 15: test resizing by inserting enough elements to trigger a resize to

			System.out.println("\n[15] Test resize... Should print out:"
					+ "\n[4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 4, 5, 6, 4, 3, 1, 2, 3]  length: 20  size: 11  front: 19  next: 10");

			D.enqueueFront(1);
			D.enqueueFront(2);
			D.enqueueFront(3);
			D.enqueueFront(4);
			System.out.println(D);

			// Test 16: test that enqueue and dequeue (all four) work after resize by
	

			System.out.println("\n[16] Test all four methods together... Should print out:"
					+ "\n[4, 8, 6, 0, 0, 0, 0, 0, 7, 9, 5, 3, 4, 5, 6, 4, 3, 1, 2, 3]  length: 20  size: 12  front: 18  next: 10");

			D.enqueueRear(9);
			D.enqueueFront(8);
			D.enqueueRear(7);
			D.enqueueFront(6);
			D.dequeueRear();
			D.dequeueFront();
			D.dequeueRear();
			System.out.println(D);

			// Test 17: Test size to make sure it works after the resize

			System.out.println("\n[17] Test size... Should print out:" + "\n12");
			System.out.println(D.counter + " ");

			// Test 18: Test exceptions by removing all elements from queue and then doing


			System.out.println("\n[18] Test exceptions... Should print out: Q Underflew!");

			for (int a = 0; a < 12; ++a) {
				D.dequeueRear();
			}
			D.dequeueRear();
		} catch (QueueUnderflowException e) {
			System.out.println(e.text);
		}

		// Test 19: Do the same for dequeueFront

		System.out.println("\n[19] Test exceptions... Should print out: Q Underflew!");
		try {
			D.dequeueFront();
		} catch (QueueUnderflowException e) {
			System.out.println(e.text);
		}
	}
}
