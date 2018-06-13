public class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate predicate) {
        return predicate.verify(s1, s2) ? s1 : s2;
    }

    public static void main(String[] args) {
        System.out.println(
                betterString(
                        "jestem dluzszy",
                        "krotszy",
                        (s1, s2) -> s1.length() > s2.length()
                ));

        System.out.println(
                betterString(
                        "pierwszy",
                        "drugi",
                        (s1, s2) -> true
                ));
    }
}
