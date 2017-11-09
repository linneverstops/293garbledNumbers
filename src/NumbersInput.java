import java.util.ArrayList;
import java.util.List;

class NumbersInput {

    private final List<Digit> digitList;

    private NumbersInput(List<Digit> digitList) {
        this.digitList = digitList;
    }

    List<Digit> getDigitList() {
        return this.digitList;
    }

    static NumbersInput inputOf(List<String> inputLines) {
        //check if
        String firstLine = inputLines.get(0);
        String secondLine = inputLines.get(1);
        String thirdLine = inputLines.get(2);
        //check if each line's length is 27
        List<Digit> digitsList = buildListOfDigits(firstLine, secondLine, thirdLine);
        return new NumbersInput(digitsList);
    }

    private static List<Digit> buildListOfDigits(String firstLine, String secondLine, String thirdLine) {
        List<Digit> digitsList = new ArrayList<>();
        //might cause null pointer/array out of bounds
        for(int i=0; i<firstLine.length(); i+=3) {
            List<String> segments = new ArrayList<>();
            String topPortion = firstLine.substring(i, i+3);
            segments.add(topPortion.substring(1, 2));
            String middlePortion = secondLine.substring(i, i+3);
            segments.add(middlePortion.substring(0, 1));
            segments.add(middlePortion.substring(1, 2));
            segments.add(middlePortion.substring(2, 3));
            String bottomPortion = thirdLine.substring(i, i+3);
            segments.add(bottomPortion.substring(0, 1));
            segments.add(bottomPortion.substring(1, 2));
            segments.add(bottomPortion.substring(2, 3));
            Digit digit = new Digit(segments);
            digitsList.add(digit);
        }
        return digitsList;
    }



}
