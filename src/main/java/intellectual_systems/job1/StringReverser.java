package intellectual_systems.job1;

public class StringReverser {

    public static String reverse(String source) {
        var builder = new StringBuilder();
        source.chars().forEach(
                x -> builder.insert(0, (char) x)
        );

        return builder.toString();
    }
}
