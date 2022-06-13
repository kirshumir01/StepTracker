import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter(75, 50);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int command = scanner.nextInt();

        while(true) {
            if (command == 1) {
                // ввести количество шагов за определённый день
                System.out.println("Введите номер месяца от 0 до 11, где:");
                System.out.println("0 - январь; 1 - февраль; 2 - март; 3 - апрель;\n4 - май; 5 - июнь; " +
                        "6 - июль; 7 - август;\n8 - сентябрь; 9 - октябрь; 10 - ноябрь; 11 - декабрь.");
                int monthNumber = scanner.nextInt();

                System.out.println("Введите номер дня от 1 до 30:");
                int dayNumber = scanner.nextInt();

                System.out.println("Введите количество пройденных шагов:");
                int stepsNumber = scanner.nextInt();

                stepTracker.saveStepsNumberByDay(monthNumber, dayNumber, stepsNumber);

            } else if (command == 2) {
                // вывести статистику за определённый месяц
                // ввести номер месяца
                System.out.println("Введите номер месяца от 0 до 11, где:");
                System.out.println("0 - январь; 1 - февраль; 2 - март; 3 - апрель;\n4 - май; 5 - июнь; " +
                        "6 - июль; 7 - август;\n8 - сентябрь; 9 - октябрь; 10 - ноябрь; 11 - декабрь.");
                // ввести номер месяца
                int monthNumber = scanner.nextInt();

                // проверить выход за границу вводимых пользователем значения
                if ((monthNumber < 0) || (monthNumber > 11)) {
                    System.out.println("Введено неверное значение! Номер месяца должен быть от 0 до 11.");
                } else {
                    // количество пройденных шагов за каждый день месяца
                    stepTracker.printStepsNumberByDays(monthNumber);

                    // общее количество шагов за месяц
                    System.out.println("Общее количество пройденных шагов: "
                            + stepTracker.printStepsNumberSum(monthNumber));

                    // максимально пройденное количество шагов в месяце
                    System.out.println("Максимальное количество пройденных шагов: "
                            + stepTracker.findMaxStepsNumber(monthNumber));

                    // среднее количество шагов, пройденных за месяц
                    System.out.println("Среднее количество пройденных шагов: "
                            + stepTracker.printAverageStepsNumber(monthNumber));

                    // объявить переменную stepsNumberSum
                    int stepsNumberSum = stepTracker.printStepsNumberSum(monthNumber);

                    // дистанция, пройденная за месяц (км)
                    System.out.println("Дистанция, пройденная за месяц: " + converter.calculateDistance(stepsNumberSum)
                            + " км");

                    // количество потраченных калорий за месяц (ккал)
                    System.out.println("Количество сожженных калорий: " + converter.calculateCalories(stepsNumberSum)
                            + " ккал");

                    // лучшая серия: максимальное количество подряд идущих дней,
                    // в течение которых количество шагов за день было равно или выше целевого
                    System.out.println("Максимальное количество подряд идущих дней: "
                            + stepTracker.findTheBestSeries(monthNumber));
                }

            } else if (command == 3) {
                // изменить цель по количеству шагов в день
                System.out.println("Введите новую цель по количеству шагов в день:");
                int newStepsByDayTarget = scanner.nextInt();
                stepTracker.changeStepsByDayTarget(newStepsByDayTarget);
            } else if (command == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды не существует");
            }
            printMenu();
            command = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}