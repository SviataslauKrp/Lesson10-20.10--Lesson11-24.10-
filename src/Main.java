
public class Main {

    public static void main(String[] args) {

        System.out.println("The main task");

        String docNumber = StringWorker.docNumberGenerator();
        System.out.println("Source: " + docNumber);

        StringWorker.numExtract(docNumber);

        StringWorker.letterReplacer(docNumber);

        StringWorker.letterExtractor(docNumber);
        StringWorker.letterExtractorUC(docNumber);

        StringWorker.checkSequence(docNumber);

        StringWorker.startsWithFives(docNumber);

        StringWorker.endsWithSeq(docNumber);

        System.out.println("The additional task");


        AdditionalTask.shortestAndLongest();

        AdditionalTask.doubler(docNumber);

    }
}