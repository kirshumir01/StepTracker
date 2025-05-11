import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter(75, 50);
        StepsTracker stepsTracker = new StepsTracker();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Ввести количество шагов за определённый день");
            System.out.println("2 - Вывести статистику по шагам за определённый месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выход");

            int command = scanner.nextInt();
            int monthNumber;
            int dayNumber;
            int stepsNumber;

            switch (command) {
                case 1:
                    printMonthHelp();

                    monthNumber = scanner.nextInt();

                    System.out.println("Введите номер дня от 1 до 30:");
                    dayNumber = scanner.nextInt();

                    System.out.println("Введите количество пройденных шагов:");
                    stepsNumber = scanner.nextInt();

                    stepsTracker.saveStepsNumberByDay(monthNumber, dayNumber, stepsNumber);
                    break;
                case 2:
                    printMonthHelp();

                    monthNumber = scanner.nextInt();

                    stepsTracker.printStepsNumberByDays(monthNumber);

                    System.out.println("Общее количество пройденных шагов: " + stepsTracker.printStepsNumberSum(monthNumber));

                    System.out.println("Максимальное количество пройденных шагов: " + stepsTracker.findMaxStepsNumber(monthNumber));

                    System.out.println("Среднее количество шагов в день: " + stepsTracker.printAverageStepsNumber(monthNumber));

                    int stepsNumberSum = stepsTracker.printStepsNumberSum(monthNumber);

                    System.out.println("Дистанция, пройденная за месяц: " + converter.calculateDistance(stepsNumberSum) + " км");

                    System.out.println("Общее количество сожженных калорий: " + converter.calculateCalories(stepsNumberSum) + " ккал");

                    System.out.println("Максимальное количество подряд идущих дней: " + stepsTracker.findTheBestSeries(monthNumber));
                    break;
                case 3:
                    System.out.println("Введите новую цель по количеству шагов в день:");

                    int newStepsByDayTarget = scanner.nextInt();

                    stepsTracker.changeStepsByDayTarget(newStepsByDayTarget);
                    break;
                case 0:
                    System.out.println("Выход из приложения.");
                    return;
                default:
                    System.out.println("Некорректный выбор команды. Попробуйте снова.");
                    command = scanner.nextInt();
            }
        }
    }

    private static void printMonthHelp() {
        System.out.println("Введите номер месяца от 1 до 12, где:");
        System.out.println("1 - январь; 2 - февраль; 3 - март; 4 - апрель;");
        System.out.println("5 - май; 6 - июнь; 7 - июль; 8 - август;");
        System.out.println("9 - сентябрь; 10 - октябрь; 11 - ноябрь; 12 - декабрь.");
    }
}