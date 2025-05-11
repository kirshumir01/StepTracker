public class Converter {
    int distance;
    int calories;

    Converter (int distance, int calories) {
        this.distance = distance;
        this.calories = calories;
    }

    public int calculateDistance(int stepsNumberSum) {
        return stepsNumberSum * distance / 100000;
    }

    public int calculateCalories(int stepsNumberSum) {
        return stepsNumberSum * calories / 1000;
    }
}