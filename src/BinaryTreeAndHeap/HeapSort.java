package BinaryTreeAndHeap;

import java.util.ArrayList;
import java.util.Arrays;

class Heap {
	int data;
	Heap left;
	Heap right;

	public Heap(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Heap(int data, Heap left, Heap right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String result = "";

		result += "Data : " + String.format("%4d", data);
		if (left != null)
			result += " Left : " + String.format("%4d", left.data);
		else
			result += " Left : null";
		if (right != null)
			result += " Right : " + String.format("%4d", right.data);
		else
			result += " Right : null";

		return result;

	}
	//配列を貰ってヒープを返す途中でソートがされているかを書きだす部分。無くてもよい
	public static Heap arrayToMaxHeap(ArrayList<Integer> list) {
		System.out.println(list);
		sortMax(list);
		System.out.println(list);

		return createHeapTree(list);
	}

	private static Heap createHeapTree(ArrayList<Integer> list) {
		if (list.size() == 0) return null;

		Heap root = createHeapTreeHellper(list, 0);

		return root;
	}

	private static Heap createHeapTreeHellper(ArrayList<Integer> list, int count) {
		int left = count * 2 + 1;
		int right = count * 2 + 2;
		if (count < list.size()) {
			Heap root = new Heap(list.get(count));
			root.left = createHeapTreeHellper(list, left);
			root.right = createHeapTreeHellper(list, right);
			return root;
		}
		return null;
	}

	//rootから見た左のノードのリストナンバー
	private static int left(int i) {
		return i * 2 + 1;
	}

	private static int right(int i) {
		return i * 2 + 2;
	}

	private static void sortMax(ArrayList<Integer> list) {
		int middle = (list.size() / 2 - 1);

		while (!isMaxHeap(list)) {
			for (int i = middle; i >= 0; i--) {
				int left = left(i);
				int right = right(i);
				if (list.size() > right && list.get(i) < list.get(right) && list.get(left) < list.get(right)) {
					swapList(list, i, right);
				} else if (list.get(i) < list.get(left)) {
					swapList(list, i, left);
				}
			}
		}
	}

	//maxheapの構造をしているかのチェック
	private static boolean isMaxHeap(ArrayList<Integer> list) {
		for (int i = (list.size() / 2 - 1); i >= 0; i--) {
			int left = left(i);
			int right = right(i);

			if (right < list.size() && list.get(i) < list.get(right))
				return false;
			if (list.get(i) < list.get(left))
				return false;

		}

		return true;
	}

	private static void swapList(ArrayList<Integer> list, int root, int target) {
		Integer temp = list.get(root);
		list.set(root, list.get(target));
		list.set(target, temp);
	}

	//printは4桁まで表示可能帰る場合はtoStirng()を変えること。
	public static void printHeap(Heap a) {
		if (a != null) {
			System.out.println(a);
			printHeap(a.left);
			printHeap(a.right);
		}
	}

}

public class HeapSort {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>(
				Arrays.asList(1, 2, 4, 5, 6, 77, 8, 899, 44, 232, 535, 7654, 9999, 43));
		Heap heap1 = Heap.arrayToMaxHeap(list);

		Heap.printHeap(heap1);

	}
}