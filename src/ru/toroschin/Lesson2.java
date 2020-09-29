package src.ru.toroschin;

public class Lesson2 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] range = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                range[i] = 1;
            } else if (range[i] == 1) {
                range[i] = 0;
            }
        }
    }
}
