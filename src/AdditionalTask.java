public class AdditionalTask {

    private static final String DELIMITER = "==================================";

    public static void shortestAndLongest() {

        System.out.println("""
                Дана строка произвольной длины с произвольными словами.
                Найти самое короткое слово в строке и вывести его на экран.
                Найти самое длинное слово в строке и вывести его на экран.
                Если таких слов несколько, то вывести последнее из них.""");

        String str = """
                Дана строка произвольной длины с произвольными словами.
                Найти самое короткое слово в строке и вывести его на экран.
                Найти самое длинное слово в строке и вывести его на экран.
                Если таких слов несколько, то вывести последнее из них.""";

        String[] arr = str.split("[\\p{Punct}\\s]+");

        String theShortestWord = arr[0];
        String theLongestWord = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() >= theLongestWord.length()) {
                theLongestWord = arr[i];
            }
            if (arr[i].length() <= theShortestWord.length()) {
                theShortestWord = arr[i];
            }
        }
        if (theLongestWord.length() == theShortestWord.length()) {
            System.out.println("Все слова одинаковой длины");
        } else {
            System.out.println("The longest word in this phrase: " + theLongestWord + "\n" +
                    "The shortest word in this phrase: " + theShortestWord);
        }

    }

    public static void doubler(String docNumber) {

        System.out.println(DELIMITER);

        System.out.println("Дана произвольная строка.\n" +
                "Вывести на консоль новую строку, которой задублирована каждая буква из\n" +
                "начальной строки.\n" +
                "Например, \"Hello\" -> \"HHeelllloo\"");

        String str = "Дана произвольная строка.";
        str = str.replaceAll("\\p{Punct}", "");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.append(ch).append(ch);
        }
        System.out.println(result);
    }
}
