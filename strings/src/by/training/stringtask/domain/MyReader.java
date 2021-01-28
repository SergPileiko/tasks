package by.training.stringtask.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyReader {

    private static MyReader instance;

    private MyReader() {
    }

    public static MyReader getInstance() {
        if (instance == null) {
            instance = new MyReader();
        }
        return instance;
    }

    public String[] stringArrayFromText(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuffer.append(line + " ");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String str = "\\s+";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(stringBuffer);
        String s = matcher.replaceAll(" ");
        String[] arrayString = s.split("[\\.!\\?]\\s");
        return arrayString;
    }

    public List<String> listWordFromText(File file) {
        String regEx = "(\\b[a-zA-Zа-яА-Я]+\\b)|(\\u002B\\d{3}\\(\\d{2}\\)\\d{3}\\-\\d{2}\\-\\d{2})|"
                + "(\\b[a-zA-Z]+\\d*\\u002E*\\u005F*[a-zA-Z]*@([a-zA-Z]+\\u002E[a-zA-Z]{1,4})\\b)";
        Pattern pattern2 = Pattern.compile(regEx);
        Matcher matcher2;
        StringBuffer sb2 = new StringBuffer();
        List<String> words = new ArrayList<String>();
        try (BufferedReader bf2 = new BufferedReader(new FileReader(file))) {
            String line;
            try {
                while ((line = bf2.readLine()) != null) {
                    sb2.append(line + " ");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            matcher2 = pattern2.matcher(sb2);
            while (matcher2.find()) {
                words.add(matcher2.group(0));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return words;
    }
}
