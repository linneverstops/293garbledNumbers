import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * for this class, the main method is never tested so the code coverage will not
 * cover the main method.
 * Also, in line 45, the assert-fail will never be reached since I never declared a NumbersException
 * with a null errorCode in my code
 */
public class NumbersDriver {

    private static final int MAXIMUM_NUMBER_OF_INPUT_LINES = 3;

    private static final File DEFAULT_LOG_FILEPATH = new File("log/log.txt");

    public static void main(String[] args) throws NumbersException {
        List<String> inputLines = new ArrayList<>();
        System.out.println("Please enter 3 lines of String, each with a length of 27");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<MAXIMUM_NUMBER_OF_INPUT_LINES; i++)
            inputLines.add(sc.nextLine());
        NumbersDriver driver = new NumbersDriver();
        System.out.println(driver.result(inputLines));
    }

    private String result(List<String> inputLines) {
        ErrorLogger.setUpErrorLogFile(DEFAULT_LOG_FILEPATH);
        try {
            NumbersInput numbersInput = new NumbersInput();
            List<Digit> digitList = numbersInput.inputLinesToListOfDigits(inputLines);
            List<Integer> numberList = NumbersAnalyzer.toNumbers(digitList);
            int garbledDigitIndex = NumbersAnalyzer.garbledDigitIndex(numberList);
            //if the garbledDigitIndex method outputs -1, it means that the numberList already represent a correct valid 9 digit number
            //we can return the number without further analyzing
            if (garbledDigitIndex == -1)
                return numberListToString(numberList);
            NumbersAnalyzer analyzer = new NumbersAnalyzer(digitList);
            List<Integer> correctNumberList = analyzer.correctNumberList();
            return NumbersDriver.numberListToString(correctNumberList);
        }
        catch (NumbersException ne) {
            ErrorLogger.logError(ne);
            assert ne.getErrorCode() != null;
            return ne.getErrorCode().toString();
        }
    }

    private static String numberListToString(List<Integer> numberList) {
        StringBuilder builder = new StringBuilder();
        for(Integer number :  numberList) {
            builder.append(number);
        }
        return builder.toString();
    }

    class TestHook {
        String result(NumbersDriver driver, List<String> inputLines) throws NumbersException {
            return driver.result(inputLines);
        }
    }
}
