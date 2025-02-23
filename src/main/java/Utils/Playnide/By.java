package Utils.Playnide;

import Utils.Playnide.Interfaces.LocatorStrategy;

public class By {

    public static LocatorStrategy byClassName(String className) {
        return (page) -> page.locator("." + className).first();
    }

    public static LocatorStrategy byText(String text) {
        return (page) -> page.locator("text=" + text).first();
    }

    public static LocatorStrategy byLinkText(String linkText) {
        return (page) -> page.locator("text=" + linkText).first();
    }

    public static LocatorStrategy byId(String id) {
        return (page) -> page.locator("#" + id);
    }

    public static LocatorStrategy byTagName(String tagName) {
        return (page) -> page.locator(tagName).first();
    }

}
