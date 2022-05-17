public class StepTracker {
    int stepsByDayTarget = 10000;
    MonthData[] monthToData;
    MonthData monthData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public static class MonthData {
        int[] steps;

        public MonthData() {
            steps = new int[30];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = 0;
            }
        }
    }

    // сохранить количество шагов, введенное пользователем, за определенный день месяца
    public void saveStepsNumberByDay(int monthNumber, int dayNumber, int stepsNumber) {

        while (true) {
            // проверить выход за границу вводимых пользователем значений
            if (((monthNumber < 0) || (monthNumber > 11)) && ((dayNumber < 0) || (dayNumber > 30))) {
                System.out.println("Введены неверные значения! Номер месяца должен быть от 0 до 11, " +
                        "номер дня должен быть от 1 до 30.");
                break;
            } else if ((monthNumber < 0) || (monthNumber > 11)) {
                System.out.println("Введено неверное значение! Номер месяца должен быть от 0 до 11.");
                break;
            } else {
                if ((dayNumber < 1) || (dayNumber > 30)) {
                    System.out.println("Введено неверное значение! Номер дня должен быть от 1 до 30.");
                    break;
                } else {
                    if (stepsNumber < 0) {
                        System.out.println("Введено неверное значение! Количество шагов не может быть отрицательным.");
                    } else {
                        // записать количество шагов в переменную массива steps[] с индексом i = dayNumber - 1
                        monthData = monthToData[monthNumber];
                        monthData.steps[dayNumber - 1] = stepsNumber;
                        break;
                    }
                }
            }
        }
    }

    // вывести количество шагов по дням за введенный пользователем месяц
    public void printStepsNumberByDays(int monthNumber){
        monthData = monthToData[monthNumber];
        int[] steps = monthData.steps;

        System.out.print("Количество пройденных шагов за каждый день " + monthNumber + " месяца:\n");
        for (int i = 0; i < 29; i++) {
            System.out.print((i + 1) + " день: " + steps[i] + ",\n");
        }
        System.out.print("30 день: " + steps[29] + ".\n");
    }

    // вывести общее количество шагов за введенный пользователем месяц
    public int printStepsNumberSum(int monthNumber){
        monthData = monthToData[monthNumber];
        int[] steps = monthData.steps;

        int stepsNumberSum = 0;
        for (int i = 0; i < steps.length; i++) {
            stepsNumberSum = stepsNumberSum + steps[i];
        }
        return stepsNumberSum;
    }

    // вывести максимально пройденное количество шагов в месяце
    public int findMaxStepsNumber(int monthNumber){
        monthData = monthToData[monthNumber];
        int[] steps = monthData.steps;

        int maxStepsNumber = 0;
        for (int i = 0; i < steps.length; i++) {
            if (steps[i] > maxStepsNumber) {
                maxStepsNumber = steps[i];
            }
        }
        return maxStepsNumber;
    }

    // вывести среднее количество шагов за введенный пользователем месяц
    public int printAverageStepsNumber(int monthNumber){
        monthData = monthToData[monthNumber];
        int[] steps = monthData.steps;

        int averageStepsNumber = printStepsNumberSum(monthNumber) / steps.length;
        return averageStepsNumber;
    }

    // вывести лучшую серию: максимальное количество подряд идущих дней,
    // в течение которых количество шагов за день было равно или выше целевого
    public int findTheBestSeries(int monthNumber){
        monthData = monthToData[monthNumber];
        int[] steps = monthData.steps;

        int countDaysNumber = 0;
        for (int i = 0; i < 29; i++) {
            if ((steps[i] >= stepsByDayTarget) && (steps[i + 1] >= stepsByDayTarget)) {
                countDaysNumber++;
            }
        }
        return countDaysNumber;
    }

    public void changeStepsByDayTarget(int newStepsByDayTarget) {
        if (newStepsByDayTarget >= 0) {
            stepsByDayTarget = newStepsByDayTarget;
            System.out.println("Новая цель по количеству шагов в день: " + newStepsByDayTarget + " шагов.");
        } else {
            System.out.println("Введенное значение не может быть отрицательным!");
        }
    }
}