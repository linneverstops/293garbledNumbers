import java.util.List;

public class NumbersDriver {

    public static void main(String[] args){

        String inputFileName = parseFilenameFromArgs(args);
        //ErrorHandler.setupErrorLog(DEFAULT_LOG_FILEPATH);

        NumbersDriver driver = new NumbersDriver();
        try {
            driver.runNumbersAnalysis(inputFileName);
        }
        catch (NumbersException e) {
            System.err.println("error");
        }

        //System.out.println(result);
    }

    private static String parseFilenameFromArgs(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException("Must provide exactly one argument");
        }
        return args[0];
    }

    private void runNumbersAnalysis(String inputFileName) throws NumbersException {
        NumbersReader reader = new NumbersReader();
        List<String> inputLines = reader.readInputFile(inputFileName);
        List<Digit> digitList = NumbersInput.inputOf(inputLines).getDigitList();
        NumbersAnalyzer analyzer = new NumbersAnalyzer(digitList);
        List<Integer> correctNumberList = analyzer.replaceGarbledDigitWithMatch();
        for(Integer number : correctNumberList) {
            System.out.print(number);
        }
        System.out.println("\n");
    }

}
