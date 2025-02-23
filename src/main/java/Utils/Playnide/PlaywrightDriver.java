package Utils.Playnide;

import Utils.Playnide.Interfaces.LocatorStrategy;
import com.microsoft.playwright.*;

import java.util.LinkedList;

public class PlaywrightDriver {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    public static Page page;
    private static final LinkedList<Page> openTabs = new LinkedList<>();
    private static Page previousTab = null;

    public static void setUp() {
        if (playwright == null) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel(PlaywrightConfiguration.browserType.getChannel())
                    .setHeadless(PlaywrightConfiguration.headless)
                    .setArgs(PlaywrightConfiguration.args)
            );

            context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            page = context.newPage();
            openTabs.add(page); // Add the initial tab to the list
        }
    }

    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    public Page getPage() {
        return page;
    }

    public static void open(String url) {
        if (page == null) {
            setUp();
        }
        page.navigate(url);
    }

    public static PlaywrightElement $(String selector) {
        if (page == null) {
            setUp();
        }
        return new PlaywrightElement(page, page.locator(selector));
    }

    public static PlaywrightElement $(LocatorStrategy locatorStrategy) {
        if (page == null) {
            setUp();
        }
        return new PlaywrightElement(page, locatorStrategy.getLocator(page));
    }

    public static PlaywrightElementsCollection $$(String selector) {
        if (page == null) {
            setUp();
        }
        return new PlaywrightElementsCollection(page, selector);
    }

    public static void switchToNewTab() {
        page.waitForTimeout(3000);
        if (context == null) {
            setUp();
        }
        previousTab = page;
        Page newTab = context.newPage();
        openTabs.add(newTab);
        page = newTab;
    }

    public static void switchToNewTab(String url) {
        switchToNewTab();
        page.navigate(url);
    }

    public static void closeCurrentTab() {
        page.waitForTimeout(3000);
        if (openTabs.size() > 1) {
            page.close();
            openTabs.remove(page);
            page = openTabs.getLast();
        } else {
            System.out.println("Cannot close the last remaining tab.");
        }
    }

    public static void switchToPreviousTab() {
        closeCurrentTab();
        if (previousTab != null) {
            page = previousTab;
            previousTab = null;
        } else {
            System.out.println("No previous tab to switch to.");
        }
    }

}
