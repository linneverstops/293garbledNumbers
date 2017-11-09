import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersDriver {

    private final static int REQUIRED_NUM_OF_DIGITS = 9;

    public static void main(String[] args){
        List<String> inputLines = new ArrayList<>();
        System.out.println("Please enter 3 lines of String, each with a length of 27");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++)
            inputLines.add(sc.nextLine());
        NumbersDriver driver = new NumbersDriver();
        try {
            System.out.println(driver.result(inputLines));
        }
        catch (NumbersException ne) {
            System.err.println(ne.toString());
        }
    }

    private String result(List<String> inputLines) throws NumbersException {
        NumbersInput numbersInput = new NumbersInput();
        List<Digit> digitList = numbersInput.inputLinesToListOfDigits(inputLines);
        //input does not contain exactly 9 digits
        if(digitList.size() != REQUIRED_NUM_OF_DIGITS)
            throw new NumbersException(NumbersException.errorCode.FAILURE, "The number does not contain exactly 9 digits (Assumption 1 does not hold)");
        List<Integer> numberList = NumbersAnalyzer.toNumbers(digitList);
        int garbledDigitIndex = NumbersAnalyzer.garbledDigitIndex(numberList);
        //if the garbledDigitIndex method outputs -1, it means that the numberList already represent a correct valid 9 digit number
        //we can return the number without further analyzing
        if(garbledDigitIndex == -1)
            return numberListToString(numberList);
        NumbersAnalyzer analyzer = new NumbersAnalyzer(digitList);
        List<Integer> correctNumberList = analyzer.correctNumberList();
        return NumbersDriver.numberListToString(correctNumberList);
    }

    private static String numberListToString(List<Integer> numberList) {
        StringBuilder builder = new StringBuilder();
        for(Integer number :  numberList) {
            builder.append(number);
        }
        return builder.toString();
    }

}
