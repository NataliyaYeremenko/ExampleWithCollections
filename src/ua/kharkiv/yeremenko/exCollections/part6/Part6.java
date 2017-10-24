package ua.kharkiv.yeremenko.exCollections.part6;

import ua.kharkiv.yeremenko.exCollections.part1.Word;
import ua.kharkiv.yeremenko.exCollections.part1.WordContainer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
	private static final String REGEXP_STRING = "(?iU)([a-zа-яA-ZА-Я]{1,})(\\s+)";
	private static final String FILE_NAME = "src\\ua\\kharkiv\\yeremenko\\exCollections\\part6\\input.txt";
	private static final String ENCODING = "UTF8";
	private static ArrayList<String> wordsArray = new ArrayList<>();
	private static UniqueWords uniqueWords = new UniqueWords();
	private static WordContainer wordContainer = new WordContainer(){
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for (Word word:wordsAr) {
				if (i < 2){
					sb.append(word.getWord()).append(" ==> ").append(word.getFrequency()).append(System.lineSeparator());
				}
				else{
					sb.append(word.getWord()).append(" ==> ").append(word.getFrequency());
					break;
				}
				i++;
			}
			return sb.toString();
		}
	};

	private static String read(String path, String csn) throws IOException {
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), csn));
		StringBuilder lineBuf = new StringBuilder();
		String line;
		while ((line = bufReader.readLine()) != null) {
			if (line != null) lineBuf.append(line);
		}
		bufReader.close();
		return lineBuf.toString();
	}

	private static void maxLength(Set<Word> wordsAr){
		for (Word word: wordsAr) {
			wordsArray.add(word.getWord());
		}
		wordsArray.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.length() - str1.length();
			}
		});
		for (int i = 0; i < 3; i++){
			System.out.println(wordsArray.get(i) + " ==> " + wordsArray.get(i).length());
		}
	}

	private static String getRepeatWords(ArrayList<String> arr){
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (String str: arr) {
			for (Word w:wordContainer.getWordsAr()) {
				if ((count<3)&&(str.equals(w.getWord()))&&(w.getFrequency()>1)){
					sb.append(str.toUpperCase());
					sb.reverse();
					if (count!= 2) sb.append(System.lineSeparator());
					count++;
					break;
				}
			}
			if (count == 3){
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String line = read(FILE_NAME, ENCODING);
		Pattern pattern = Pattern.compile(REGEXP_STRING);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String someWord = matcher.group(1);
			uniqueWords.putWord(someWord);
			Word word = new Word(someWord);
			wordContainer.putWord(word);
		}
		System.out.println(wordContainer.toString());
		System.out.println();
		maxLength(wordContainer.getWordsAr());
		System.out.println();
		System.out.println(getRepeatWords(uniqueWords.getWordsAr()));
	}

}
