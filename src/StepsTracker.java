public class StepsTracker {
    int stepsByDayTarget = 10000;
    MonthData[] monthToData;
    MonthData monthData;

    public StepsTracker() {
        monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public static class MonthData {
        int[] steps;

        public MonthData() {
            steps = new int[30];
        }
    }

    public void saveStepsNumberByDay(int monthNumber, int dayNumber, int stepsNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Номер месяца должен быть от 1 до 12! Введено значение: " + monthNumber);
            return;
        }
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Номер дня должен быть от 1 до 30! Введено значение: " + dayNumber);
            return;
        }
        if (stepsNumber < 0) {
            System.out.println("Количество шагов не может быть отрицательным! Введено значение: " + stepsNumber);
            return;
        }
        monthData = monthToData[monthNumber - 1];
        monthData.steps[dayNumber - 1] = stepsNumber;
    }

    public void printStepsNumberByDays(int monthNumber) {
        monthNumberValidation(monthNumber);

        monthData = monthToData[monthNumber - 1];
        int[] steps = monthData.steps;

        System.out.print("Количество пройденных шагов за каждый день " + monthNumber + " месяца:\n");

        for (int i = 1; i <= 30; i++) {
            System.out.print((i) + " день: " + steps[i - 1] + ",\n");
        }
    }

    public int printStepsNumberSum(int monthNumber) {
        monthNumberValidation(monthNumber);

        monthData = monthToData[monthNumber - 1];
        int[] steps = monthData.steps;

        int stepsNumberSum = 0;

        for (int i = 0; i < steps.length; i++) {
            stepsNumberSum = stepsNumberSum + steps[i];
        }

        return stepsNumberSum;
    }

    public int findMaxStepsNumber(int monthNumber) {
        monthNumberValidation(monthNumber);

        monthData = monthToData[monthNumber - 1];
        int[] steps = monthData.steps;

        int maxStepsNumber = 0;

        for (int i = 0; i < steps.length; i++) {
            if (steps[i] > maxStepsNumber) {
                maxStepsNumber = steps[i];
            }
        }
        return maxStepsNumber;
    }

    public int printAverageStepsNumber(int monthNumber) {
        monthNumberValidation(monthNumber);

        monthData = monthToData[monthNumber - 1];
        int[] steps = monthData.steps;

        return printStepsNumberSum(monthNumber) / steps.length;
    }

    public int findTheBestSeries(int monthNumber) {
        monthNumberValidation(monthNumber);

        monthData = monthToData[monthNumber - 1];
        int[] steps = monthData.steps;

        int currentSeries = 0;
        int maxSeries = 0;

        for (int i = 0; i < steps.length; i++) {
            if ((steps[i] >= stepsByDayTarget)) {
                currentSeries++;
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return maxSeries;
    }

    public void changeStepsByDayTarget(int newStepsByDayTarget) {
        if (newStepsByDayTarget >= 0) {
            stepsByDayTarget = newStepsByDayTarget;
            System.out.println("Новая цель по количеству шагов в день: " + newStepsByDayTarget + " шагов.");
        } else {
            System.out.println("Введенное значение не может быть отрицательным!");
        }
    }

    private void monthNumberValidation(int monthNumber) {
        if ((monthNumber < 1) || (monthNumber > 12)) {
            System.out.println("Номер месяца должен быть от 1 до 12! Введено значение: " + monthNumber);
        }
    }
}