import SingleLinkedList.SingleLinkedListNodes;
/*
 * This class executes all packages.

 */

public class main {

	public static void main(String[] args) {
		SingleLinkedListNodes<Integer> head = new SingleLinkedListNodes<Integer>(new Integer[] {1,2,3,4,5,6,76,88});
		head.peekAt(2);
		System.out.println(head.toString());
		head.addNodeAt(4, 63);
		System.out.println(head.toString());


	}

}