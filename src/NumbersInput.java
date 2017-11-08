import java.util.ArrayList;
import java.util.List;

public class NumbersInput {

    private final List<Digit> digitList;

    private NumbersInput(List<Digit> digitList) {
        this.digitList = digitList;
    }

    public List<Digit> getDigitList() {
        return this.digitList;
    }

    static NumbersInput inputOf(List<String> inputLines) {
        //validation of various params

        String firstLine = inputLines.get(0);
        String secondLine = inputLines.get(1);
        String thirdLine = inputLines.get(2);
        //check the length of all 3 lines
        List<Digit> digitsList = buildListOfDigits(firstLine, secondLine, thirdLine);
        return new NumbersInput(digitsList);
    }

    private static List<Digit> buildListOfDigits(String firstLine, String secondLine, String thirdLine) {
        List<Digit> digitsList = new ArrayList<>();
        //might cause null pointer/array out of bounds
        for(int i=0; i<firstLine.size(); i+=3) {
            List<String> segments = new ArrayList<>();
            segments.addAll(firstLine.subList(i, i+2));
            segments.addAll(secondLine.subList(i, i+2));
            segments.addAll(thirdLine.subList(i, i+2));
            Digit digit = new Digit(segments);
            digitsList.add(digit);
        }
        return digitsList;
    }

}
