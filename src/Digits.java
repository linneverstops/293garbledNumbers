import java.util.List;

public class Digits {

    public enum Digit {
        ONE("1", false, false, false, true, false, false, true),
        TWO("2", true, false, true, true, true, false, true),
        THREE("3", true, false, true, true, false, true, true),
        FOUR("4", false, true, true, true, false, false, true),
        FIVE("5", true, true, true, false, false, true, true),
        SIX("6", true, true, true, false, true, true, true),
        SEVEN("7", true, false, false, true, false, false, true),
        EIGHT("8", true, true, true, true, true, true, true),
        NINE("9", true, true, true, true, false, true, true),
        ZERO("0", true, true, false, true, true, false, true);

        private final String representation;

        private final boolean segment0;

        private final boolean segment1;

        private final boolean segment2;

        private final boolean segment3;

        private final boolean segment4;

        private final boolean segment5;

        private final boolean segment6;

        Digit(String representation, boolean segment0, boolean segment1, boolean segment2,
              boolean segment3, boolean segment4, boolean segment5,
              boolean segment6) {
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
    }

    Digits(Digit digit) {

    }

    String matchingDigit(List<Boolean> segments) {

    }
}

