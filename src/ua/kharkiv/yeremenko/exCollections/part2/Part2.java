package ua.kharkiv.yeremenko.exCollections.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
	private static List<Human> arrayList = new ArrayList<>();
	private static List<Human> linkedList = new LinkedList<>();
	private static final int N = 10;

	private void removeLinked(List<Human> list){
		long timer = -System.currentTimeMillis();
		int i = 2;
		while (list.size()!=1){
			if (i == list.size()) i = 0;
			list.remove(i);
			i = i + 2;
			if (i >= list.size()) i = i - list.size();
		}
		timer += System.currentTimeMillis();
		System.out.println(list.getClass() + " last Human is " + list.get(0).getName() + " time: " + timer + "ms");
	}


	public static void main(String[] args) {
		for (int i = 0; i < N; i++){
			Human human = new Human("Name " + i);
			arrayList.add(human);
			linkedList.add(human);
		}
		Part2 part2 = new Part2();
		part2.removeLinked(arrayList);
		part2.removeLinked(linkedList);
	}
}

class Human{
	private String name;

	public Human(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}