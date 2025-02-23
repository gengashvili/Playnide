package steps;

import pages.HomePage;

public class HomePageSteps extends HomePage {

    public HomePageSteps clickOnMovieLink() {
        movieLink.click();

        return this;
    }
}
