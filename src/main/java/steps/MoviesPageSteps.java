package steps;

import pages.MoviesPage;

public class MoviesPageSteps extends MoviesPage {

    public MoviesPageSteps clickOnPopCornButton() {
        popCornButton.click();

        return this;
    }
}
