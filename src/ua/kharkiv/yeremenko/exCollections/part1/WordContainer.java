package ua.kharkiv.yeremenko.exCollections.part1;

import java.util.Set;
import java.util.TreeSet;

public class WordContainer {
    public static Set<Word> wordsAr = new TreeSet<>();

    public static Set<Word> getWordsAr() {
        return wordsAr;
    }

    public void putWord(Word word) {
        if (!containWord(word)) {
            wordsAr.add(word);
        }
        else{
            for (Word someWord : wordsAr) {
                if (someWord.getWord().equals(word.getWord())) {
                    int newFrequency = someWord.getFrequency() + 1;
                    String stringWord = someWord.getWord();
                    wordsAr.remove(someWord);
                    wordsAr.add(new Word(stringWord, newFrequency));
                    break;
                }
            }
        }
    }

    public boolean containWord(Word word) {
        for (Word someWord : wordsAr) {
            if (someWord.getWord().equals(word.getWord())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word:wordsAr) {
            sb.append(word.getWord()).append(": ").append(word.getFrequency()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}


