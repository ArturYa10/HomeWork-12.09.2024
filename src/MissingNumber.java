public class MissingNumber {

    // Метод для нахождения недостающего числа
    public static int findMissing(int[] arr, int n) {
        // Считаем сумму от 1 до n
        int totalSum = n * (n + 1) / 2;

        // Считаем сумму элементов массива
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        // Недостающее число
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        // Пример 1
        int[] arr1 = {1, 2, 3, 5};
        int n1 = 5;
        System.out.println("Недостающее число: " + findMissing(arr1, n1));  // Вывод: 4

        // Пример 2
        int[] arr2 = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        int n2 = 10;
        System.out.println("Недостающее число: " + findMissing(arr2, n2));  // Вывод: 9
    }
}
