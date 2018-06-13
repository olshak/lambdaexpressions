public class ElementUtils {
    public static <SomeType> SomeType betterElement(SomeType e1, SomeType e2, TwoElementPredicate<SomeType> predicate) {
        return predicate.verify(e1, e2) ? e1 : e2;
    }

    public static void main(String[] args) {
        System.out.println(
                betterElement(
                        "jestem dluzszy",
                        "krotszy",
                        (s1, s2) -> s1.length() > s2.length()
                ));

        System.out.println(
                betterElement(
                        "pierwszy",
                        "drugi",
                        (s1, s2) -> true)
        );

        System.out.println(
                betterElement(
                        123,
                        321,
                        (s1, s2) -> s1 < s2
                ));

        System.out.println(
                betterElement(
                        123.2,
                        321.2,
                        (s1, s2) -> s1 < s2
                ));
    }
}
