package singleton;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Просим пользователя ввести входные данные для списка");

            System.out.println("Введите размер списка");
            int size = scanner.nextInt();

            System.out.println("Введите верхнюю границу для значений");
            int maxValue = scanner.nextInt();

            List<Integer> integers = getRandomList(size, maxValue);
            printList(integers, "Вот случайный список: ");

            logger.log("Просим пользователя ввести входные данные для фильтрации");

            System.out.println("Введите порог для фильтра");
            int f = scanner.nextInt();

            printOut(new Filter(f).filterOut(integers));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.log("Завершаем программу");
        }

    }

    private static void printList(List<Integer> integers, String head) {

        System.out.print(head);
        integers.stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println();

    }

    private static void printOut(List<Integer> filterOut) {

        Logger.getInstance().log("Выводим результат на экран");
        printList(filterOut,"Отфильтрованный список: ");

    }

    private static List<Integer> getRandomList(int count, int maxValue) {

        Logger.getInstance().log("Создаём и наполняем список");

        Random random = new Random();
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(maxValue));
        }

        return list;

    }

}

