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
        printOneArray("Задание 1, результат:", range);

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] range2 = new int[8];
        for (int i=0; i<8; i++) {
            range2[i] = i*3;
        }
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
        int size = 6;
        int[][] squareArray = new int[size][size];
        for (int i=0; i<squareArray.length; i++) {
            squareArray[i][i] = 1;
            squareArray[squareArray.length-i-1][i] = 1;
        }
        printTwoArray("Задание 4:", squareArray);

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] range5 = {1, 6, 9, 3, 0, 23, 15, 4, 2};
        int minValue = range5[0];
        int maxValue = range5[0];
        printOneArray("Задание 5, массив:", range5);
        for (int i=0; i<range5.length; i++) {
            if (minValue>range5[i]) {
                minValue = range5[i];
            }
            if (maxValue<range5[i]) {
                maxValue = range5[i];
            }
        }
        System.out.println("Минимальный элемент = "+minValue+"; максимальный элемент = "+maxValue);

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] range6 = {21, 1, 1, 1, 1, 2, 1, 4, 14};
        printOneArray("Задание 6, массив:", range6);
        if (checkBalance(range6)) {
            System.out.println("Есть место равенства!");
        }
        else {
            System.out.println("Нет места равенства!");
        }

        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] range7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printOneArray("Задание 7, начальный массив:", range7);
        displacementElements(range7, -5);
        printOneArray("Задание 7, результат:", range7);
    }

    // метод проверяет есть ли граница на которой сумма левой и правой части массива равны
    private static boolean checkBalance(int[] arr) {
        boolean result = false;
        int sum=0;
        for (int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        int i=0;
        int sum1;
        int sum2;
        while (i<arr.length) {
            sum1=0;
            for (int j=0; j<=i; j++) {
                sum1 += arr[j];
            }
            sum2 = sum-sum1;
            if (sum1==sum2) {
                result = true;
                break;
            }
            i++;
        }
        return result;
    }

    // метод смещает все элементы массива на count позиций
    // если count отрицательное - смещается влево
    // если count положительное - смещается вправо
    private static void displacementElements(int[] arr, int count) {
        int direction;
        int stepCount;
        int element;
        if (count < 0) {
            direction = 1;
            stepCount = count*(-1);
        }
        else {
            direction = -1;
            stepCount = count;
        }
        for (int i=1; i<=stepCount; i++) {
            if (count<0) {
                element = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + direction];
                }
                arr[arr.length-1] = element;
            }
            else {
                element = arr[arr.length-1];
                for (int j = arr.length-1; j > 0; j--) {
                    arr[j] = arr[j + direction];
                }
                arr[0] = element;
            }
        }
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
    }

}
