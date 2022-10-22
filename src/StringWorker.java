import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWorker {

    private static final String DELIMITER = "==================================";

    static void endsWithSeq(String docNumber) {

        System.out.println(DELIMITER);
        System.out.println("- Проверить заканчивается ли номер документа на\n" +
                "последовательность 1a2b: ");

        docNumber = "0857-cro-2348-sid-1a2b";

        boolean isEnds = docNumber.endsWith("1a2b");

        System.out.println("Номер документа: " + docNumber);

        if (isEnds) {
            System.out.println("Номер документа закачнивается на \"1a2b\"");
        } else {
            System.out.println("Номер документа не закачнивается на \"1a2b\"");
        }
        System.out.println(DELIMITER);
    }

    static void startsWithFives(String docNumber) {

        System.out.println(DELIMITER);

        System.out.println("- Проверить начинается ли номер документа с последовательности 555: ");

        boolean isStartsWithFives = docNumber.startsWith("555");
        if (isStartsWithFives) {
            System.out.println("Номер документа начинается с 555");
        } else {
            System.out.println("Номер документа не начинается с 555");
        }

    }

    static void checkSequence(String docNumber) {

        System.out.println(DELIMITER);

        System.out.println("""
                - Проверить содержит ли номер документа последовательность abc и
                вывети сообщение содержит или нет(причем, abc и ABC считается
                одинаковой последовательностью).""");

        //для проверки корректности
        docNumber = "0642-abc-8170-gor-1t8j";
        System.out.println("Номер документа: " + docNumber);
        final String pattern = "abc";

        String[] arr = docNumber.split("[\\d-]+");

        boolean isMatched = false;

        for (String elem : arr) {
            if (elem.equalsIgnoreCase(pattern)) {
                System.out.println("Последовательность найдена");
                isMatched = true;
                break;
            }
        }

        if (!isMatched) {
            System.out.println("Последовательность не найдена");
        }
    }

    static void letterExtractorUC(String docNumber) {

        System.out.println("\n" + DELIMITER);

        System.out.println("""
                - Вывести на экран буквы из номера документа в формате
                "Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью
                класса StringBuilder):\s""");

        String[] arr = docNumber.split("[\\d-]+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (!arr[i].equals("")) {
                if (j == arr.length - 1) {
                    sb.append(arr[i]);
                } else {
                    sb.append(arr[i]).append("/");
                }
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }

    static void letterExtractor(String docNumber) {

        System.out.println(DELIMITER);

        System.out.println("- Вывести на экран только одни буквы из номера документа в формате\n" +
                "yyy/yyy/y/y в нижнем регистре: ");

        String[] arr = docNumber.split("[\\d-]+");

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (!arr[i].equals("")) {
                if (j == arr.length - 1) {
                    System.out.print(arr[i].toLowerCase());
                } else {
                    System.out.print(arr[i].toLowerCase() + "/");
                }
            }
        }
    }

    static void letterReplacer(String docNumber) {

        System.out.println(DELIMITER);

        String replaceString = docNumber.replaceAll("[a-z]{3}", "***");

        System.out.println("- Вывести на экран номер документа, но блоки из трех букв заменить\n" +
                "на *** (каждая буква заменятся на *): " + replaceString);
    }

    static void numExtract(String docNumber) {

        System.out.println(DELIMITER);

        String[] arr = docNumber.split("-");

        Pattern pattern = Pattern.compile("\\d{4}");
        StringBuilder result = new StringBuilder();
        int counter = 0;

        for (String s : arr) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                result.append(s).append(" ");
                counter++;
                if (counter == 2) break;
            }
        }

        result = new StringBuilder(result.toString().trim());
        if (result.length() > 0) {
            System.out.println("- Вывести на экран в одну строку два первых блока по 4 цифры: " + result);
            ;
        } else {
            System.out.println("В данной строке нет искомой последовательности");
        }
    }

    static String docNumberGenerator() {
        String lets = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";

        char[] letters = lets.toCharArray();
        char[] numbers = nums.toCharArray();

        //xxxx-yyy-xxxx-yyy-xyxy

        StringBuilder result = new StringBuilder();

        addGen(letters, numbers, result);
        addGen(letters, numbers, result);

        Random random = new Random();

        result.append(numbers[random.nextInt(numbers.length)]);
        result.append(letters[random.nextInt(letters.length)]);
        result.append(numbers[random.nextInt(numbers.length)]);
        result.append(letters[random.nextInt(letters.length)]);

        return result.toString();
    }

    private static void addGen(char[] letters, char[] numbers, StringBuilder result) {
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int index = random.nextInt(numbers.length);

            result.append(numbers[index]);
        }
        result.append("-");

        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int index = random.nextInt(letters.length);

            result.append(letters[index]);
        }
        result.append("-");

    }

}
