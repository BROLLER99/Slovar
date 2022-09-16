package dictionary.work.Model;

public class DictionaryType {
    String pattern;
    String description;

    public DictionaryType(String pattern, String description) {
        this.pattern = pattern;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getPattern() {
        return pattern;
    }
}
