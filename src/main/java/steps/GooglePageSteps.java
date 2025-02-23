package steps;

import pages.GooglePage;

public class GooglePageSteps extends GooglePage {

    public GooglePageSteps setInputValue(String value) {
        searchInput.setValue(value);

        return this;
    }
}
