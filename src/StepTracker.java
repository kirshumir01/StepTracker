public class StepTracker {
    int stepsByDayTarget = 10000;
    MonthData[] monthToData;
    MonthData monthData;

    // создать конструктор StepTracker()
    public StepTracker() {
        // присвоить переменной monthToData класса MonthData массив данных по каждому месяцу
        monthToData = new MonthData[12];
        // сохранить в переменные массива данные за каждый месяц
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public static class MonthData {
        // объявить массив, содержащий данные по количеству шагов за каждый день [i] месяца
        int[] steps;

        // создать конструктор MonthData()
        public MonthData() {
            // сохранить в переменные массива нулевые значения
            steps = new int[30];
        }
    }

    // сохранить количество шагов, введенное пользователем, за определенный день месяца
    public void saveStepsNumberByDay(int monthNumber, int dayNumber, int stepsNumber) {

        while (true) {
            // проверить выход за границу вводимых пользователем значения
            // первая проверка - пользователем введены неверные значения месяца и дня
            // по условию задачи номер месяца начинается с 0
            if (((monthNumber < 0) || (monthNumber > 12)) && ((dayNumber < 1) || (dayNumber > 30))) {
                System.out.println("Введены неверные значения! Номер месяца должен быть от 0 до 11, " +
                        "номер дня должен быть от 1 до 30.");
                break;
                // вторая проверка - пользователем введено только неверное значение месяца
            } else if ((monthNumber < 0) || (monthNumber > 11)) {
                System.out.println("Введено неверное значение! Номер месяца должен быть от 0 до 11.");
                break;
            } else {
                // третья проверка - пользователем введено только неверное значение дня
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

    // далее - объявить методы для подсчета статистики за месяц, введенный пользователем
    // справочно - проверка выхода значений номера месяцев, введенного пользователем, выведена в класс Main
    // с целью читаемости кода

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

        // задать две переменные:
        // count - подсчет количества "соседних" дней с максимальным количеством шагов
        // maxCount - подсчет количества подряд идущих дней (серии) с максимальным количеством шагов

        int count = 0;
        int maxCount = 0;

        for (int i = 1; i < steps.length; i++) {

            // задать условие для подсчета количества "соседних" дней, запись общего количества таких
            if ((steps[i - 1] >= stepsByDayTarget) && (steps[i] >= stepsByDayTarget)) {
                count++;
                maxCount = count;

            // сбросить подсчет количества "соседних" дней, если условие не выполняется
            } else {
                count = 1;
            }
        }
        return maxCount;
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