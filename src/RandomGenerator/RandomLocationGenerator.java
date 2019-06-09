package RandomGenerator;

public class RandomLocationGenerator {
    private static RandomLocationGenerator ourInstance = new RandomLocationGenerator();

    public static RandomLocationGenerator getInstance() {
        return ourInstance;
    }

    private RandomLocationGenerator() {
    }
}
