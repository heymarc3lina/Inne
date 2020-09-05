import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public String userCanLoginByUsername(String hasloWyszukiwania) {
        open("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        $("#searchInput").setValue(hasloWyszukiwania);
        return  $("div#mw-content-text> div.mw-parser-output>p").getText();

    }
}
