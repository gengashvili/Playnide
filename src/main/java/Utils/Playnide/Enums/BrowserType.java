package Utils.Playnide.Enums;

public enum BrowserType {
    CHROMIUM("chromium"),
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String channel;

    BrowserType(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return this.channel;
    }
}
