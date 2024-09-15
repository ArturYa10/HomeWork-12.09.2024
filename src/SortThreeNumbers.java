import java.util.Scanner;

public class SortThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод чисел a, b и c
        System.out.print("Введите значение a: ");
        int a = scanner.nextInt();

        System.out.print("Введите значение b: ");
        int b = scanner.nextInt();

        System.out.print("Введите значение c: ");
        int c = scanner.nextInt();

        // Сортировка чисел
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Вывод отсортированных чисел
        System.out.println("Возрастающая последовательность: " + a + " " + b + " " + c);
    }
}
