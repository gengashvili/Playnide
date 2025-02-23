package Utils.Playnide.Interfaces;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public interface LocatorStrategy {
    Locator getLocator(Page page);
}