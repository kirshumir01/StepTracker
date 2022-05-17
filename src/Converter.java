public class Converter {
    // объявить переменные
    int distance;
    int calories;

    Converter (int distance, int calories) {
        this.distance = distance;
        this.calories = calories;
    }

    // вывести пройденную дистанцию (км)
    public int calculateDistance(int stepsNumberSum) {
        return stepsNumberSum * distance / 1000;
    }

    // вывести количество сожженных калорий (ккал)
    public int calculateCalories(int stepsNumberSum) {
        return stepsNumberSum * calories / 1000;
    }
}