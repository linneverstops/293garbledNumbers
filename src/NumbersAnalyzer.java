import java.util.ArrayList;
import java.util.List;

public class NumbersAnalyzer {

    static List<String> digitRepresentationToNumbers(List<Digit> digitList) {
        List<String> numberList = new ArrayList<>();
        for(Digit digit : digitList) {
            String type = digit.matchingType();
            numberList.add(type);
        }
        return numberList;
    }

    static List<Integer> garbledDigitIndex(List<String> numberList) {
        List<Integer> garbledDigitIndex = new ArrayList<>();
        for(int i=0; i<numberList.size(); i++) {
            if(numberList.get(i) == null) {
                garbledDigitIndex.add(i);
            }
        }
        return garbledDigitIndex;
    }
}
