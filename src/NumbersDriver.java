import java.util.List;

public class NumbersDriver {

    public static void main(String[] args){

        String inputFileName = parseFilenameFromArgs(args);
        //ErrorHandler.setupErrorLog(DEFAULT_LOG_FILEPATH);

        NumbersDriver driver = new NumbersDriver();
        String result = driver.runNumbersAnalysis(inputFileName);

        System.out.println(result);
    }

    private static String parseFilenameFromArgs(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException("Must provide exactly one argument");
        }
        return args[0];
    }

    private String runNumbersAnalysis(String inputFileName) throws NumbersException {
        NumbersReader reader = new NumbersReader();
        List<String> lines = reader.readInputFile(inputFileName);
    }
}
