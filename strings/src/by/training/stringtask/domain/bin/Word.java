package by.training.stringtask.domain.bin;

import java.util.Map;
import java.util.TreeMap;

public class Word implements Comparable<Word> {
    private String wordName;
    private Map<Integer, Integer> countOccurrence;
    private int total;

    public Word(String wordName) {
        super();
        this.wordName = wordName;
        countOccurrence = new TreeMap<>();
    }

    public Map<Integer, Integer> getCountOccurrence() {
        return countOccurrence;
    }

    public void setCountOccurrence(int numberSentence, int countWords) {
        this.countOccurrence.put(Integer.valueOf(numberSentence), Integer.valueOf(countWords));
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getWordName() {
        return wordName;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public int compareTo(Word o) {
        return o.total - this.total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((countOccurrence == null) ? 0 : countOccurrence.hashCode());
        result = prime * result + total;
        result = prime * result + ((wordName == null) ? 0 : wordName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (countOccurrence == null) {
            if (other.countOccurrence != null)
                return false;
        } else if (!countOccurrence.equals(other.countOccurrence))
            return false;
        if (total != other.total)
            return false;
        if (wordName == null) {
            if (other.wordName != null)
                return false;
        } else if (!wordName.equals(other.wordName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Word [wordName=" + wordName + ", countOccurrence=" + countOccurrence + ", total=" + total + "]";
    }

}
