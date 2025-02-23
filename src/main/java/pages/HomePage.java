package pages;

import Utils.Playnide.PlaywrightElement;
import Utils.Playnide.PlaywrightElementsCollection;

import static Utils.Playnide.By.byText;
import static Utils.Playnide.PlaywrightDriver.*;

public class HomePage {
    public PlaywrightElement movieLink = $(byText("კინო"));

    public PlaywrightElementsCollection name = $$("#id");
}
