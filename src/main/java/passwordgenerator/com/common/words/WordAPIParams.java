package passwordgenerator.com.common.words;

import org.springframework.web.util.UriComponentsBuilder;

public record WordAPIParams(int length, String soundsLike, String similarTo, String startingLetter) {

    private static final String URI_BASE = "https://api.datamuse.com/words?";

    public String buildURL() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_BASE);

        if (startingLetter.isEmpty()) {
            builder.queryParam("sp", "?".repeat(length));
        } else {
            builder.queryParam("sp", startingLetter + "?".repeat(length - 1));
        }

        if (soundsLike() != null && !soundsLike().isEmpty()) {
            builder.queryParam("sl", soundsLike());
        }
        if (similarTo() != null && !similarTo().isEmpty()) {
            builder.queryParam("ml", similarTo());
        }

        return builder.build().toString();
    }

    public static class Builder {
        private int length;
        private String soundsLike = "";
        private String similarTo = "";
        private String startingLetter = "";

        public Builder() {
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder soundsLike(String soundsLike) {
            this.soundsLike = soundsLike;
            return this;
        }

        public Builder similarTo(String similarTo) {
            this.similarTo = similarTo;
            return this;
        }

        public Builder startingLetter(String startingLetter) {
            this.startingLetter = startingLetter;
            return this;
        }

        public WordAPIParams build() {
            return new WordAPIParams(length, soundsLike, similarTo, startingLetter);
        }
    }
}
