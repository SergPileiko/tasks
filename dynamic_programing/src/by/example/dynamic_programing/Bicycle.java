package by.example.dynamic_programing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bicycle {

    public static void main(String[] args) {
        int[][] testMas = new int[4][];

        testMas[0] = new int[]{3, 4, 4, 4, 3};
        testMas[1] = new int[]{3, 2, 3, 1, 4};
        testMas[2] = new int[]{4, 2, 3, 3, 3};
        testMas[3] = new int[]{4, 4, 2, 3, 4};

        calculatePath(testMas);
    }

    public static void calculatePath(int[][] map) {
        int[][] matrix = new int[map.length][map[0].length];
        matrix[0][0] = 0;
        matrix[1][0] = Math.abs(map[0][0] - map[1][0]) + 1;
        matrix[0][1] = Math.abs(map[0][0] - map[0][1]) + 1;
        for (int i = 2; i < map.length; i++) {
            matrix[i][0] = Math.abs(map[i - 1][0] - map[i][0]) + matrix[i - 1][0] + 1;
        }
        for (int j = 2; j < map[0].length; j++) {
            matrix[0][j] = Math.abs(map[0][j - 1] - map[0][j]) + matrix[0][j - 1] + 1;
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                matrix[i][j] = min((Math.abs(map[i][j - 1] - map[i][j]) + matrix[i][j - 1]),
                        (Math.abs(map[i - 1][j] - map[i][j]) + matrix[i - 1][j])) + 1;
            }
        }
        findAndWritePath(matrix);
    }

    public static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    public static void findAndWritePath(int[][] matrix) {
        List<String> list = new ArrayList<>();
        list.add("[" + (matrix.length - 1) + "]" + "[" + (matrix[0].length - 1) + "]");

        int i = matrix.length - 1;
        int j = matrix[i].length - 1;

        while (i > 0 || j > 0) {
            if (i != 0 && j != 0) {
                if (matrix[i - 1][j] <= matrix[i][j - 1]) {
                    list.add("[" + (i - 1) + "]" + "[" + j + "]");
                    i--;
                } else {
                    list.add("[" + i + "]" + "[" + (j - 1) + "]");
                    j--;
                }
            } else {
                if (i == 0) {
                    list.add("[" + i + "]" + "[" + (j - 1) + "]");
                    j--;
                } else {
                    list.add("[" + (i - 1) + "]" + "[" + j + "]");
                    i--;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int k = list.size() - 1; k >= 0; k--) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append("->");
            }
            stringBuffer.append(list.get(k));
        }

        try (FileWriter writer = new FileWriter("path-plan.txt", false)) {
            writer.write(stringBuffer.toString());
            writer.append('\n');
            writer.write("steps: " + (list.size() - 1));
            writer.append('\n');
            writer.write("fuel: " + matrix[matrix.length - 1][matrix[i].length - 1]);
            writer.flush();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
