package lambda;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

//文字列によって構成される配列と ある条件において 2 つの要素のうちどちらが大きいかを計算するコールバック関数 f を受け取り、
//f の基準に基づいて最大の値を返す maxByCriteria という関数を作成しテストケースを出力してください。

//string maxByCriteria(bool(string), string[])
//2 つの要素のうち、どちらが大きいかを計算するコールバック関数と、文字列の配列を受け取り、最大値を返します。
//
//bool compareLength(string s1, string s2)
//文字列 s1, s2 を受け取って、長さを比較し、s1 >= s2 であれば true を返す関数。
//
//bool compareAsciiTotal(string s1, string s2)
//文字列 s1, s2 を受け取って、Ascii 値の合計値を比較し、s1 >= s2 であれば true を返す関数。

//maxByCriteria(compareLength, ["apple", "yumberry", "grape", "banana","mandarin"]) --> mandarin
//maxByCriteria(compareLength, ["zoomzoom", "choochoo", "beepbeep", "ahhhahhh"]) --> ahhhahhh
//maxByCriteria(compareAsciiTotal, ["apple", "yumberry", "grape", "banana","mandarin"]) --> yumberry
//maxByCriteria(compareAsciiTotal, ["zoom", "choochoo", "beepbeep", "ahhhahhh"]) --> choochoo


public class maxCriteria {

	public static void main(String[] args) {
		BiPredicate<String , String> compareLength = (x , y) -> {
			if(x.length() > y.length()) return true;
			else return false;
		};
		
		BiPredicate<String, String> compareAsciiTotal = (x , y) -> {
			int firstAscii = countAscii(x) , secondAscii = countAscii(y);
			if(firstAscii >= secondAscii) return true;
			else return false;
		};
		
		BiFunction<BiPredicate<String,String>, String[], String> maxByCriteria = (f , list) -> {
			Deque<String> queue = new ArrayDeque<>();
			queue.addLast(list[0]);
			for(int i = 1 ; i < list.length;i++) {
				if(f.test(queue.peekFirst() , list[i])) queue.addLast(list[i]);
				else queue.addFirst(list[i]);
			}
			return queue.peekFirst();
		};
		
		System.out.println(maxByCriteria.apply(compareLength , new String[] {"apple", "yumberry", "grape", "banana","mandarin"}));
		System.out.println(maxByCriteria.apply(compareLength , new String[] {"zoomzoom", "choochoo", "beepbeep", "ahhhahhh"}));
		System.out.println(maxByCriteria.apply(compareAsciiTotal , new String[] {"apple", "yumberry", "grape", "banana","mandarin"}));
		System.out.println(maxByCriteria.apply(compareAsciiTotal , new String[] {"zoom", "choochoo", "beepbeep", "ahhhahhh"}));
		
		
	}
	
	public static int countAscii(String a) {
		int ascii = 0;
		for(int i = 0; i < a.length(); i++) ascii += (int) a.charAt(i);
		return ascii;
	}

}
