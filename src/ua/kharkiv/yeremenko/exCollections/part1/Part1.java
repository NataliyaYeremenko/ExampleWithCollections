package ua.kharkiv.yeremenko.exCollections.part1;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		WordContainer wordContainer = new WordContainer();
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] words = line.split(" ");
		for (String str:words) {
			Word word = new Word(str);
			wordContainer.putWord(word);
		}
		System.out.println(wordContainer.toString());

	}

}
