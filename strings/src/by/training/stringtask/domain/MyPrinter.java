package by.training.stringtask.domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map.Entry;

import by.training.stringtask.domain.bin.Word;

public class MyPrinter {

    private static MyPrinter instance;

    private MyPrinter() {
    }

    public static MyPrinter getInstance() {
        if (instance == null) {
            instance = new MyPrinter();
        }
        return instance;
    }

    public void printInFile(String nameFileForRecord, List<Word> listWord) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(nameFileForRecord))) {
            if (listWord != null) {
                for (Word word : listWord) {
                    pw.append("Слово " + "\"" + word.getWordName() + "\"" + " встречается :" + "\n");
                    for (Entry<?, ?> entry : word.getCountOccurrence().entrySet()) {
                        pw.append("в предложении N: " + entry.getKey() + " - " + entry.getValue() + " раз" + "\n");
                    }
                    pw.append("Всего слово " + "\"" + word.getWordName() + "\"" + " встречается в тексте: "
                            + word.getTotal() + " раз. \n" + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void printConsoleAboutWord(List<Word> listWord) {
        if (listWord != null) {
            for (Word word : listWord) {
                printConsole("Слово " + "\"" + word.getWordName() + "\"" + " встречается в тексте: " + word.getTotal()
                        + " раз.");
            }
            printConsole("*подробная информация о каждом слове в файле out.txt.");
        }
    }

    public void printConsole(String str) {
        System.out.println(str);
    }
}
