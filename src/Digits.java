public class Digits {

    public enum Digit {
        ONE("1", false, false, true, false, false, true, false),
        TWO("2", true, false, true, true, true, false, true),
        THREE("3", true, false, true, true, false, true, true),
        FOUR("4", false, true, true, true, false, true, false),
        FIVE("5", true, true, false, true, false, true, true),
        SIX("6", true, true, false, true, true, true, true),
        SEVEN("7", true, false, true, false, false, true, false),
        EIGHT("8", true, true, true, true, true, true, true),
        NINE("9", true, true, true, true, false, true, true),
        ZERO("0", true, true, true, false, true, true, false);

        private final String representation;

        private final boolean segment1;

        private final boolean segment2;

        private final boolean segment3;

        private final boolean segment4;

        private final boolean segment5;

        private final boolean segment6;

        private final boolean segment7;

        Digit(String representation, boolean segment1, boolean segment2,
              boolean segment3, boolean segment4, boolean segment5,
              boolean segment6, boolean segment7) {
            this.representation = representation;
            this.segment1 = segment1;
            this.segment2 = segment2;
            this.segment3 = segment3;
            this.segment4 = segment4;
            this.segment5 = segment5;
            this.segment6 = segment6;
            this.segment7 = segment7;
        }
    }
}
