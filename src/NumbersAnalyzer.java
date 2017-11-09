import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NumbersAnalyzer {

    private List<Integer> numberList;

    private int garbledDigitIndex;

    private GarbledDigit garbledDigit;

    NumbersAnalyzer(List<Digit> digitList) {
        this.numberList = NumbersAnalyzer.digitRepresentationToNumbers(digitList);
        this.garbledDigitIndex = NumbersAnalyzer.garbledDigitIndexFromNumberList(numberList);
        this.garbledDigit = new GarbledDigit(digitList.get(garbledDigitIndex).getSegments());
    }

    static List<Integer> digitRepresentationToNumbers(List<Digit> digitList) {
        List<Integer> numberList = new ArrayList<>();
        for(Digit digit : digitList) {
            Integer number = digit.matchingNumber();
            numberList.add(number);
        }
        return numberList;
    }

    static int garbledDigitIndexFromNumberList(List<Integer> numberList) {
        List<Integer> garbledDigitIndex = new ArrayList<>();
        for(int i=0; i<numberList.size(); i++) {
            if(numberList.get(i) == null) {
                garbledDigitIndex.add(i);
            }
        }
        //if there is more than one garbled digit
        if(garbledDigitIndex.size() > 1)
            return -1;
        return garbledDigitIndex.get(0);
    }

    List<Integer> replaceGarbledDigitWithMatch() {
        List<Integer> correctNumberList = this.numberList;
        Integer matchingInteger = garbledDigit.findMatchingInteger();
        //if more than one matching result
        if(matchingInteger == -1) {
            return Collections.emptyList();
        }
        correctNumberList.remove(garbledDigitIndex);
        correctNumberList.add(garbledDigitIndex, matchingInteger);
        return correctNumberList;
    }

    private class GarbledDigit {

        private List<String> garbledSegments;

        private GarbledDigit(List<String> garbledSegments) {
            this.garbledSegments = garbledSegments;
        }

        private Integer findMatchingInteger() {
            List<Digit.Number> possibleMatches = new ArrayList<>();
            for(Digit.Number number : Digit.Number.values()) {
                Digit.Number matchingNumber = compareGarbledSegmentsToCorrectSegments(number);
                if(matchingNumber != null)
                    possibleMatches.add(matchingNumber);
            }
            //if there is more than one match
            if(possibleMatches.size() > 1)
                return -1;
            return possibleMatches.get(0).getNumber();
        }

        private Digit.Number compareGarbledSegmentsToCorrectSegments(Digit.Number number) {
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
