import Utils.Config.BaseTest;
import org.testng.annotations.Test;
import steps.GooglePageSteps;
import steps.HomePageSteps;
import steps.MoviesPageSteps;

import static Utils.Playnide.PlaywrightDriver.*;

public class ScenarioTest extends BaseTest {
    HomePageSteps homePageSteps = new HomePageSteps();
    MoviesPageSteps moviesPageSteps = new MoviesPageSteps();
    GooglePageSteps googlePageSteps = new GooglePageSteps();

    @Test
    public void stepOne() {
        open("https://www.swoop.ge/");

        homePageSteps.clickOnMovieLink();
        moviesPageSteps.clickOnPopCornButton();

        switchToNewTab("https://www.google.com/");
        System.out.println("Switched to Google Tab. Current URL: " + page.url());

        page.locator("textarea[name='q']").fill("test");

        switchToPreviousTab();
        System.out.println("Switched back to the original tab. Current URL: " + page.url());

        homePageSteps.clickOnMovieLink();
        page.waitForTimeout(30000);
    }
}
