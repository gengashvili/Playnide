package Utils.Playnide;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class PlaywrightElementsCollection {
    private List<Locator> elements;

    public PlaywrightElementsCollection(Page page, String selector) {
        this.elements = page.locator(selector).all();
    }

    public int count() {
        return elements.size();
    }

    public Locator get(int index) {
        return elements.get(index);
    }

}
