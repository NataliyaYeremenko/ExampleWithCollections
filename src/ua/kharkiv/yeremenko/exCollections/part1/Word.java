package ua.kharkiv.yeremenko.exCollections.part1;

public class Word implements Comparable {
	private String word;
	private int frequency;

	public Word(String word) {
		this.word = word;
		frequency = 1;
	}
	public Word(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}

	public int getFrequency() {
		return frequency;
	}

	public boolean equals(Object obj){
		if (!(obj instanceof Word))
			return false;
		Word entry = (Word)obj;
		return word.equals(entry.word) &&
				frequency == entry.frequency;
	}

	public int hashCode(){
		int hash = 37;
		hash = hash*17 + word.hashCode();
		hash = hash*17 + frequency;
		return hash;
	}

	public int compareTo(Object obj){
		Word entry = (Word)obj;
		int result = entry.frequency - frequency;
		if (result != 0) return (int)(result/Math.abs(result));
		result = word.compareTo(entry.word);
		return result;
	}
}
