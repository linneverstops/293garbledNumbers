import java.util.ArrayList;
import java.util.List;

class NumbersInput {

    private final static int REQUIRED_LINE_LENGTH = 27;

    private final static int REQUIRED_NUMBER_OF_LINES = 3;

    List<Digit> inputLinesToListOfDigits(List<String> inputLines) throws NumbersException {
        //check if there is exactly 3 lines
        NumbersInput.checkNumberOfLines(inputLines);
        String firstLine = inputLines.get(0);
        String secondLine = inputLines.get(1);
        String thirdLine = inputLines.get(2);
        //check if each line's length is 27
        NumbersInput.checkLineLength(firstLine);
        NumbersInput.checkLineLength(secondLine);
        NumbersInput.checkLineLength(thirdLine);
        return listOfDigits(firstLine, secondLine, thirdLine);
    }

    private List<Digit> listOfDigits(String firstLine, String secondLine, String thirdLine) throws NumbersException {
        List<Digit> digitsList = new ArrayList<>();
        for(int i=0; i<firstLine.length(); i+=3) {
            List<String> segments = new ArrayList<>();
            addPortionToSegments(segments, firstLine, i);
            addPortionToSegments(segments, secondLine, i);
            addPortionToSegments(segments, thirdLine, i);
            //check if the digit has extra segments in the top left and right corners(should be empty in a normal digit)
            if(!segments.get(0).equals(" ") || !segments.get(2).equals(" "))
                throw new NumbersException(NumbersException.errorCode.failure, "Digit has segment in the wrong spot (Assumption 5 does not hold)");
            //remove the top left and right corner if they are empty
            segments.remove(0);
            segments.remove(1);
            Digit digit = new Digit(segments);
            digitsList.add(digit);
        }
        return digitsList;
    }

    private void addPortionToSegments(List<String> segments, String line, int startIndex) {
        String portion = line.substring(startIndex, startIndex + 3);
        segments.add(portion.substring(0, 1));
        segments.add(portion.substring(1, 2));
        segments.add(portion.substring(2, 3));
    }

    private static void checkNumberOfLines(List<String> inputLines) throws NumbersException {
        if(inputLines.size() != REQUIRED_NUMBER_OF_LINES) {
            throw new NumbersException(NumbersException.errorCode.failure, "Input file content does not have the correct format of 3 lines of String of length 27");
        }
    }

    private static void checkLineLength(String line) throws NumbersException {
        if(line.length() != REQUIRED_LINE_LENGTH)
            throw new NumbersException(NumbersException.errorCode.failure, "Input lines do not have length 27");
    }
}
