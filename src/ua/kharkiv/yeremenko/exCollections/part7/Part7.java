package ua.kharkiv.yeremenko.exCollections.part7;

import java.util.Iterator;

public class Part7 {
	private static final int N = 3;
	private static final int M = 10;
	public static void main(String[] args) {
		Range range = new Range(N, M, true);
		Iterator it = range.iterator();
		while (it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
		Range range2 = new Range(N, M, false);
		Iterator it2 = range2.iterator();
		while (it2.hasNext()){
			System.out.print(it2.next() + " ");
		}
	}

}
