package pages;

import Utils.Playnide.PlaywrightElement;

import static Utils.Playnide.By.byText;
import static Utils.Playnide.PlaywrightDriver.$;

public class MoviesPage {
    public PlaywrightElement popCornButton = $(byText("დასვენება"));
}
