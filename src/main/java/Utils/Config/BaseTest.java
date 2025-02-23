package Utils.Config;

import Utils.Playnide.Enums.BrowserType;
import Utils.Playnide.PlaywrightConfiguration;
import Utils.Playnide.PlaywrightDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    private PlaywrightDriver playwrightDriver;

    @BeforeClass
    public void setUp() {
        PlaywrightConfiguration.browserType = BrowserType.CHROME;
        PlaywrightConfiguration.headless = true;

        playwrightDriver = new PlaywrightDriver();
        PlaywrightDriver.setUp();
    }

    @AfterClass
    public void tearDown() {
        if (playwrightDriver != null) {
            playwrightDriver.tearDown();
        }
    }

}
