public class LevelAdvice {

    enum Level { LOW, MEDIUM, HIGH }

    static String advice(Level level) {
        return switch (level) {   // switch expression, exhaustive
            case LOW    -> "Relax, everything is fine";
            case MEDIUM -> "Keep an eye on things";
            case HIGH   -> "Take immediate action";
        };
    }

    public static void main(String[] args) {
        for (Level level : Level.values()) {
            System.out.printf("%-7s -> %s%n", level, advice(level));
        }
    }
}