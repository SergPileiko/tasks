package by.training.stringtask.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.stringtask.domain.bin.Word;

public class WordInText {

    public static void FindWordInText(String[] strArray, List<String> wordList, List<Word> listWord) {
        int count = 0;
        int sentence = 0;
        if (strArray != null && wordList != null && listWord != null) {
            int total;
            Word wordObj;
            for (int j = 0; j < wordList.size(); j++) {
                total = 0;
                String word = wordList.get(j);
                wordObj = new Word(word);
                Pattern pattern = Pattern.compile(word.replace("+", "\\u002B"));
                sentence = 0;
                for (String str : strArray) {
                    count = 0;
                    Matcher matcher = pattern.matcher(str);
                    while (matcher.find()) {
                        count++;
                    }
                    wordObj.setCountOccurrence(sentence, count);
                    total = total + count;
                    sentence++;
                }
                wordObj.setTotal(total);
                listWord.add(wordObj);
            }
        }
    }
}
