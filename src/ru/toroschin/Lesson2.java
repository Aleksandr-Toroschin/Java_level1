package src.ru.toroschin;

public class Lesson2 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] range = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        // вывод массива в консоль
        printOneArray("Задание 1, начальный массив:", range);
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                range[i] = 1;
            } else if (range[i] == 1) {
                range[i] = 0;
            }
        }
        // вывод массива в консоль
        printOneArray("Задание 1, результат:", range);

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] range2 = new int[8];
        for (int i=0; i<8; i++) {
            range2[i] = i*3;
        }
        // вывод массива в консоль
        printOneArray("Задание 2:", range2);

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] range3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printOneArray("Задание 3, начальный массив:", range3);
        for (int i=0; i<range3.length; i++) {
            if (range3[i]<6) {
                range3[i] *= 2;
            }
        }
        printOneArray("Задание 3, результат:", range3);

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int size = 5;
        int[][] squareArray = new int[size][size];
        for (int i=0; i<squareArray.length; i++) {
            squareArray[i][i] = 1;
            squareArray[squareArray.length-i-1][i] = 1;
        }
        printTwoArray("Задание 4:", squareArray);

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);


    }

    private static void printOneArray(String heading, int[] arr) {
        System.out.println(heading);
        printOneDimArray(arr);
    }

    private static void printTwoArray(String heading, int[][] arr) {
        System.out.println(heading);
        printTwoDimArray(arr);
    }

    // метод выводит в консоль одномерный массив
    private static void printOneDimArray(int[] arr) {
        System.out.print(arr[0]);
        for (int i=1; i<arr.length; i++) {
            System.out.print(", "+arr[i]);
        }
        System.out.println();
    }

    // метод выводит в консоль двумерный массив
    private static void printTwoDimArray(int[][] arr) {
        for (int[] ints: arr) {
            printOneDimArray(ints);
        }
        System.out.println();
    }

}
