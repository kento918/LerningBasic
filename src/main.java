import SingleLinkedList.SingleLinkedListNodes;
import SingleLinkedList.useSingleLinkedListArgo;

/*
 * This class executes all packages.

 */

public class main {

	public static void main(String[] args) {
//		useSingleLinkedListArgo<Integer> head = new useSingleLinkedListArgo<Integer>(new Integer[] {1,2,3,4,5,6,76,88});
//		head.getRoot().peekAt(2);
//		System.out.println(head.getRoot().toString());
//		head.getRoot().addNodeAt(4, 63);
//		System.out.println(head.getRoot().toString());
//		
		SingleLinkedListNodes<Integer> head1 = new SingleLinkedListNodes<>(new Integer[] {1,3});
		SingleLinkedListNodes<Integer> head2 = new SingleLinkedListNodes<>(new Integer[] {2,4});
		
		useSingleLinkedListArgo<Integer> meargeHead = new useSingleLinkedListArgo<>(null);
		meargeHead.setRoot(meargeHead.mergeTwoSortedLinkedLists(head1,head2));
		meargeHead.printRoot();
		
		javaGoldPractis.innerClassrenshuu.innerUser();
		

	}

}