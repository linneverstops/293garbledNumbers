import java.util.ArrayList;
import java.util.List;

public class Digit {

    private List<String> segments;

    Digit(List<String> segments){
        this.segments = segments;
    }

    public static void main(String[] args) {
        Number.ONE.printDigitRepresentation();
        Number.TWO.printDigitRepresentation();
        Number.THREE.printDigitRepresentation();
    }

    List<String> getSegments() {
        return this.segments;
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for(String segment : this.segments) {
            builder.append(segment);
        }
        return builder.toString();
    }

    Integer matchingNumber() {
        String representation = stringRepresentation();
        Number[] values = Number.values();
        int i;
        for (i = 0; i < values.length; i++) {
            Number type = values[i];
            if (representation.equals(type.stringRepresentation()))
                return type.getNumber();
        }
        System.err.println("Garbled");
        return null;
    }

    public enum Number {
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

        private final String segment0;

        private final String segment1;

        private final String segment2;

        private final String segment3;

        private final String segment4;

        private final String segment5;

        private final String segment6;

        Number(Integer number, String segment0, String segment1,
             String segment2, String segment3, String segment4,
             String segment5, String segment6) {
            this.number = number;
            this.segment0 = segment0;
            this.segment1 = segment1;
            this.segment2 = segment2;
            this.segment3 = segment3;
            this.segment4 = segment4;
            this.segment5 = segment5;
            this.segment6 = segment6;
        }

        public Integer getNumber() {
            return number;
        }

        public List<String> toSegmentsList() {
            List<String> segments = new ArrayList<>();
            segments.add(segment0);
            segments.add(segment1);
            segments.add(segment2);
            segments.add(segment3);
            segments.add(segment4);
            segments.add(segment5);
            segments.add(segment6);
            return segments;
        }

        public String stringRepresentation() {
            StringBuilder builder = new StringBuilder();
            builder.append(segment0);
            builder.append(segment1);
            builder.append(segment2);
            builder.append(segment3);
            builder.append(segment4);
            builder.append(segment5);
            builder.append(segment6);
            return builder.toString();
        }

        public void printDigitRepresentation() {
            System.out.println(segment0);
            System.out.println(segment1+segment2+segment3);
            System.out.println(segment4+segment5+segment6);
        }
    }





}
