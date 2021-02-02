package model;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SearchEngine {
   private int numberOfSearches;

   public SearchEngine(){
       numberOfSearches = 1;
   }

    public int getNumberOfSearches() {
        return numberOfSearches;
    }

    public void setNumberOfSearches(int numberOfSearches) {
        this.numberOfSearches = numberOfSearches;
    }

    public String searchWordOnWiki(String wordToSearch) {
        open("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        $("#searchInput").setValue(wordToSearch).pressEnter();
        if($("div#mw-content-text>div>ul>li").exists()) {
            if ($("tbody tr td b").getText().equalsIgnoreCase(wordToSearch)) {
                numberOfSearches = $$("div#mw-content-text>div>ul>li").size();
                int random = (int) Math.random() % numberOfSearches;
                $$("div#mw-content-text>div>ul>li>a").get(random).click();
            }
        }
        if($("div#mw-content-text> div.mw-parser-output>p").exists()) {
            return $("div#mw-content-text> div.mw-parser-output>p").getText();
        }
        return null;

    }
}
