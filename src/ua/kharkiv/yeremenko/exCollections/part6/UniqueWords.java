package ua.kharkiv.yeremenko.exCollections.part6;

import java.util.ArrayList;

public class UniqueWords {
    public static ArrayList<String> wordsAr = new ArrayList<>();

    public static ArrayList<String> getWordsAr() {
        return wordsAr;
    }

    public void putWord(String word) {
        if (!containWord(word)) {
            wordsAr.add(word);
        }
    }

    public boolean containWord(String word) {
        for (String someWord : wordsAr) {
            if (someWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String word:wordsAr) {
            sb.append(word).append(" ==> ").append(System.lineSeparator());
            i++;
            if (i == 3) break;
        }
        return sb.toString();
    }
}
