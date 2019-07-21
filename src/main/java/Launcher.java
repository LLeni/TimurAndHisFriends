import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {

    // в главном методе происходит получение информации о домах: сколько их, где расположены
    public static void main(String[] args) {
        int N; // количество домов в деревне
        double X[]; // X координаты домов
        double Y[]; // Y координаты домов

        Scanner scanner = new Scanner(System.in);


        //TODO: 0<N<=100
        //TODO: -32000<=Xi Yi <= 32000
        //TODO: тесты
        //TODO: документация
        do {
            System.out.println("Введите количество домов в диапозоне от 1 до 100");
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста введите целое число");
                scanner.next();
            }
            N = scanner.nextInt();
        } while (N > 100 || N <= 0);

        X = new double[N];
        Y = new double[N];
        //ввод координат для каждого дома
        for (int i = 0; i < N; i++) {
            System.out.println("Ввод координат для дома под номером " + (i+1));

            do {
                System.out.println("Введите координату X в диапозоне от -32000 до 32000:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Пожалуйста введите целое число ");
                    scanner.next();
                }
                X[i] = scanner.nextInt();
            } while (X[i] > 32000 || X[i] < -32000);



            do {
                System.out.println("Введите координату Y в диапозоне -32000 до 32000:");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Пожалуйста введите целое число ");
                    scanner.next();
                }
                Y[i] = scanner.nextInt();
            } while (Y[i] > 32000 || Y[i] < -32000);

        }

        // создаем объект деревни, в которой будет храниться вся информация о домах и об их расположении
        Village village = new Village(N, X, Y);
        village.calculateLengths(); // составляем матрицу весов
        village.calculateOstovTree(); // высчитываем требуемый  минимальный размер веревки

        System.out.printf("Требуемый минимальный размер веревки: %12.2f метров", + village.getValueOstovTree());
    }
}
