package pages;

import Utils.Playnide.PlaywrightElement;

import static Utils.Playnide.PlaywrightDriver.$;

public class GooglePage {
    public PlaywrightElement searchInput = $("textarea[name='q']");
}
