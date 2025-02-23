package Utils.Playnide;

import Utils.Playnide.Enums.BrowserType;

import java.util.List;

public class PlaywrightConfiguration {
    public static BrowserType browserType = BrowserType.CHROME;
    public static boolean headless = false;
    public static List<String> args = List.of("--start-maximized");
}
