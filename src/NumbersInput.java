import java.util.List;

public class NumbersInput {

    private final List<String> firstLine;

    private final List<String> secondLine;

    private final List<String> thirdLine;

    private NumbersInput(List<String> firstLine, List<String> secondLine,
                         List<String> thirdLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
    }
    /*
    static NumbersInput inputOf(List<String> inputLines) {
        //validation of various params

        List<String> firstLine = inputLines.subList(0, 26);
        List<String> secondLine = inputLines.subList(27, 53);
        List<String> thirdLine = inputLines.subList(54, 80);
    }
    */
}
