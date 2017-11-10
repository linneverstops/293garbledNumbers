import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *         segment0
 *             _
 *   segment1 |_| segment3   segment2(in the middle)
 *   segment4 |_| segment6
 *         segment5
 *
 */
class Digit {

    private List<String> segments;

    Digit(List<String> segments){
        this.segments = segments;
    }

    List<String> getSegments() {
        return this.segments;
    }

    private static String stringRepresentation(List<String> segments) {
        StringBuilder builder = new StringBuilder();
        for(String segment : segments) {
            builder.append(segment);
        }
        return builder.toString();
    }

    Integer matchingNumber() {
        String representation = Digit.stringRepresentation(this.segments);
        for(Number number : Number.values()) {
            if(representation.equals(Digit.stringRepresentation(number.toSegmentsList())))
                return number.getNumber();
        }
        return null;
    }

    enum Number {
        ONE(1, " ", " ", " ", "|", " ", " ", "|"),
        TWO(2, "_", " ", "_", "|", "|", "_", " "),
        THREE(3, "_", " ", "_", "|", " ", "_", "|"),
        FOUR(4, " ", "|", "_", "|", " ", " ", "|"),
        FIVE(5, "_", "|", "_", " ", " ", "_", "|"),
        SIX(6, "_", "|", "_", " ", "|", "_", "|"),
        SEVEN(7, "_", " ", " ", "|", " ", " ", "|"),
        EIGHT(8, "_", "|", "_", "|", "|", "_", "|"),
        NINE(9, "_", "|", "_", "|", " ", "_", "|"),
        ZERO(0, "_", "|", " ", "|", "|", "_", "|");

        private final Integer number;

        private final String[] segments;

        Number(Integer number, String... segments) {
            this.number = number;
            this.segments = segments;
        }

        public Integer getNumber() {
            return number;
        }

        public List<String> toSegmentsList() {
            return new ArrayList<>(Arrays.asList(segments));
        }
    }
}
