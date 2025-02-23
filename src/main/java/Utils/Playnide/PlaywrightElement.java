package Utils.Playnide;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PlaywrightElement {
    private Page page;
    private Locator locator;

    public PlaywrightElement(Page page, Locator locator) {
        this.page = page;
        this.locator = locator;
    }

    public PlaywrightElement(Locator locator) {
        this.locator = locator;
    }

    public void click() {
        locator.click(new Locator.ClickOptions().setTimeout(15000));
    }

    public void setValue(String value) {
        page.waitForTimeout(1000);
        locator.fill(value);
    }

    public String getText() {
        return locator.textContent();
    }

    public boolean isVisible() {
        return locator.isVisible();
    }

    public boolean isEnabled() {
        return locator.isEnabled();
    }

    public PlaywrightElement find(String childSelector) {
        return new PlaywrightElement(locator.locator(childSelector));
    }

}
