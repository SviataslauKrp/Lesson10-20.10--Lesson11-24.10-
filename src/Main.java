import exeptions.ContainsABCException;
import exeptions.StartsWithFivesException;
import exeptions.WrongTerminalSequenceException;

public class Main {

    public static void main(String[] args) {

        System.out.println("The main task");

        String docNumber = StringWorker.docNumberGenerator();
        System.out.println("Source: " + docNumber);

        StringWorker.numExtract(docNumber);

        StringWorker.letterReplacer(docNumber);

        StringWorker.letterExtractor(docNumber);
        StringWorker.letterExtractorUC(docNumber);

        try {
            StringWorker.checkSequence(docNumber);
        } catch (ContainsABCException e) {
            System.out.println(e.getMessage());
        }
        try {
            StringWorker.startsWithFives(docNumber);
        } catch (StartsWithFivesException e) {
            System.out.println(e.getMessage());
        }
        try {
            StringWorker.endsWithSeq(docNumber);
        } catch (WrongTerminalSequenceException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("The additional task");


        AdditionalTask.shortestAndLongest();

        AdditionalTask.doubler(docNumber);

    }
}