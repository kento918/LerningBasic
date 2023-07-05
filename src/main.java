import SingleLinkedList.SingleLinkedListNodes;

public class main {

	public static void main(String[] args) {
		SingleLinkedListNodes<Integer> head = new SingleLinkedListNodes<>(new int[] {1,2,3,4,5,6,76,88});
		head.printNodes();
		System.out.println(head.at(4).getData());
	}

}