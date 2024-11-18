package passwordgenerator.com;

public record PasswordCriteria(int length, int valueOfSpecialSigns) {
    private static final int MAX_LENGTH = 30;
    private static final int MIN_LENGTH = 8;
    private static final int DEFAULT_LENGTH = 10;

    private static final int MAX_VALUE_SPECIAL_SIGN = 27;
    private static final int MIN_VALUE_SPECIAL_SIGN = 1;
    private static final int DEFAULT_VALUE_SPECIAL_SIGN = 1;

    public static final char[] SPECIAL_SIGNS = {
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=',
            '[', ']', '{', '}', ';', '\'', ':', '"', '\\', '|', ',', '.', '<', '>', '/', '?'
    };

    public static final char[] lowercaseString = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public PasswordCriteria {
        if (length < MIN_LENGTH || length > MAX_LENGTH)
            throw new IllegalArgumentException(String.format("Value %d is wrong", length));
    }



    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private int length = DEFAULT_LENGTH;
        private int valueOfSpecialSigns = DEFAULT_VALUE_SPECIAL_SIGN;

        Builder length(int length) {
            this.length = length;
            return this;
        }

        Builder valueOfSpecialSigns(int valueOfSpecialSigns) {
            this.valueOfSpecialSigns = valueOfSpecialSigns;
            return this;
        }

        PasswordCriteria build() {
            return new PasswordCriteria(length, valueOfSpecialSigns);
        }
    }
}
