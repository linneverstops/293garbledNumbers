import java.util.List;

public class NumbersDriver {

    public static void main(String[] args){

        String inputFileName = parseFilenameFromArgs(args);
        //ErrorHandler.setupErrorLog(DEFAULT_LOG_FILEPATH);

        NumbersDriver driver = new NumbersDriver();
        try {
            System.out.println(driver.runAnalysisAndGenerateResult(inputFileName));
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

    private String runAnalysisAndGenerateResult(String inputFileName) throws NumbersException {
        NumbersReader reader = new NumbersReader();
        List<String> inputLines = reader.readInputFile(inputFileName);
        List<Digit> digitList = NumbersInput.inputOf(inputLines).getDigitList();
        //input does not contain exactly 9 digits
        if(digitList.size() != 9)
            return "failure";
        List<Integer> numberList = NumbersAnalyzer.digitRepresentationToNumbers(digitList);
        if(!numberList.contains(null))
            return convertNumberListToString(numberList);
        int garbledDigitIndex = NumbersAnalyzer.garbledDigitIndexFromNumberList(numberList);
        if(garbledDigitIndex == -1)
            return "failure";
        NumbersAnalyzer analyzer = new NumbersAnalyzer(digitList);
        List<Integer> correctNumberList = analyzer.replaceGarbledDigitWithMatch();
        if(correctNumberList.isEmpty())
            return "ambiguous";
        return NumbersDriver.convertNumberListToString(correctNumberList);
    }

    private static String convertNumberListToString(List<Integer> numberList) {
        StringBuilder builder = new StringBuilder();
        for(Integer number :  numberList) {
            builder.append(number);
        }
        return builder.toString();
    }

}
