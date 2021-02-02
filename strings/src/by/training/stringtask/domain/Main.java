package by.training.stringtask.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.training.stringtask.domain.bin.Word;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileToReadText;
        File fileToReadWords;
        List<String> wordsForFind;
        String[] arrayFromText;
        List<Word> wordList;

        MyReader myReader = MyReader.getInstance();
        MyPrinter myPrinter = MyPrinter.getInstance();

        fileToReadText = new File("text.txt");
        fileToReadWords = new File("words.txt");
        wordsForFind = myReader.listWordFromText(fileToReadWords);
        arrayFromText = myReader.stringArrayFromText(fileToReadText);
        wordList = new ArrayList<Word>();

        WordInText.FindWordInText(arrayFromText, wordsForFind, wordList);
        Collections.sort(wordList);
        myPrinter.printInFile("out.txt", wordList);
        myPrinter.printConsoleAboutWord(wordList);

    }
}
