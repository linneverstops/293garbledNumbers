import java.util.ArrayList;
import java.util.List;
/**
 * for this class, line 76 is never reached because I have checked for extra segments in
 * line 32 of NumbersInput and since the digit 8 contains all other digit, it will always
 * have a match.
 */
class NumbersAnalyzer {

    private final static int REQUIRED_NUM_OF_DIGITS = 9;

    private List<Integer> numberList;

    private int garbledDigitIndex;

    private GarbledDigit garbledDigit;

    NumbersAnalyzer(List<Digit> digitList) throws NumbersException {
        this.numberList = NumbersAnalyzer.toNumbers(digitList);
        this.garbledDigitIndex = NumbersAnalyzer.garbledDigitIndex(numberList);
        this.garbledDigit = new GarbledDigit(digitList.get(garbledDigitIndex).getSegments());
    }

    List<Integer> correctNumberList() throws NumbersException {
        List<Integer> correctNumberList = new ArrayList<>(this.numberList);
        Integer matchingInteger = garbledDigit.matchingInteger();
        correctNumberList.remove(garbledDigitIndex);
        correctNumberList.add(garbledDigitIndex, matchingInteger);
        return correctNumberList;
    }

    static List<Integer> toNumbers(List<Digit> digitList) throws NumbersException {
        //precondition: digitList has a length of 9
        //always satisfied because the length of 27 per line has been checked and
        //9 digits will be chopped off
        List<Integer> numberList = new ArrayList<>();
        for(Digit digit : digitList) {
            Integer number = digit.matchingNumber();
            numberList.add(number);
        }
        return numberList;
    }

    static int garbledDigitIndex(List<Integer> numberList) throws NumbersException {
        //Guard Clause
        //if there is no garbled digit in the numberList, return a -1 to indicate that the input already represent a valid nine-digit number
        if(!numberList.contains(null))
            return -1;
        List<Integer> garbledDigitIndex = new ArrayList<>();
        for(int i=0; i<numberList.size(); i++) {
            if(numberList.get(i) == null) {
                garbledDigitIndex.add(i);
            }
        }
        //if there is more than one garbled digit
        if(garbledDigitIndex.size() > 1)
            throw new NumbersException(NumbersException.errorCode.failure, "More than one digit is garbled (Assumption 3 does not hold)");
        return garbledDigitIndex.get(0);
    }

    private class GarbledDigit {

        private List<String> garbledSegments;

        private GarbledDigit(List<String> garbledSegments) {
            this.garbledSegments = garbledSegments;
        }

        private Integer matchingInteger() throws NumbersException {
            List<Digit.Number> possibleMatches = new ArrayList<>();
            for(Digit.Number number : Digit.Number.values()) {
                Digit.Number matchingNumber = bestNumberMatch(number);
                if(matchingNumber != null)
                    possibleMatches.add(matchingNumber);
            }
            //if there is more than one match
            if(possibleMatches.size() > 1)
                throw new NumbersException(NumbersException.errorCode.ambiguous, "More than one solution was found");
            if(possibleMatches.size() == 0)
                throw new NumbersException(NumbersException.errorCode.failure, "No matching was found");
            return possibleMatches.get(0).getNumber();
        }

        private Digit.Number bestNumberMatch(Digit.Number number) {
            List<String> correctSegments = number.toSegmentsList();
            for(int i=0; i<this.garbledSegments.size(); i++) {
                if(!(garbledSegments.get(i).equals(correctSegments.get(i))) && !garbledSegments.get(i).equals(" ")) {
                    return null;
                }
            }
            return number;
        }


    }


}
