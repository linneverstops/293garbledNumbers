import java.util.ArrayList;
import java.util.List;

public class Digits {

    public static void main(String[] args) {
        Digit.ONE.printDigitRepresentation();
        Digit.TWO.printDigitRepresentation();
        Digit.THREE.printDigitRepresentation();
        Digit.FOUR.printDigitRepresentation();
        Digit.FIVE.printDigitRepresentation();
        Digit.SIX.printDigitRepresentation();
        Digit.SEVEN.printDigitRepresentation();
        Digit.EIGHT.printDigitRepresentation();
        Digit.NINE.printDigitRepresentation();
        Digit.ZERO.printDigitRepresentation();
    }

    public enum Digit {
        ONE("1", " ", " ", " ", "|", " ", " ", "|"),
        TWO("2", "_", " ", "_", "|", "|", "_", " "),
        THREE("3", "_", " ", "_", "|", " ", "_", "|"),
        FOUR("4", " ", "|", "_", "|", " ", " ", "|"),
        FIVE("5", "_", "|", "_", " ", " ", "_", "|"),
        SIX("6", "_", "|", "_", " ", "|", "_", "|"),
        SEVEN("7", "_", " ", " ", "|", " ", " ", "|"),
        EIGHT("8", "_", "|", "_", "|", "|", "_", "|"),
        NINE("9", "_", "|", "_", "|", " ", "_", "|"),
        ZERO("0", "_", "|", " ", "|", "|", "_", "|");

        private final String representation;

        private final String segment0;

        private final String segment1;

        private final String segment2;

        private final String segment3;

        private final String segment4;

        private final String segment5;

        private final String segment6;

        Digit(String representation, String segment0, String segment1,
              String segment2, String segment3, String segment4,
              String segment5, String segment6) {
            this.representation = representation;
            this.segment0 = segment0;
            this.segment1 = segment1;
            this.segment2 = segment2;
            this.segment3 = segment3;
            this.segment4 = segment4;
            this.segment5 = segment5;
            this.segment6 = segment6;
        }

        public String getRepresentation() {
            return representation;
        }

        public void printDigitRepresentation() {
            System.out.println(" " + segment0 + " ");
            System.out.println(segment1+segment2+segment3);
            System.out.println(segment4+segment5+segment6);
        }
    }
    /*
    Digits(Digit digit) {

    }

    String matchingDigit(List<Boolean> segments) {

    }
    */
}

