package controller;
import View.WindowView;
import model.SearchEngine;


public class Controller {
    private WindowView window;
    private SearchEngine searchEngine;

   public Controller(){
        window = new WindowView();
        searchEngine = new SearchEngine();
    }

    public void workingFunction() {

        String wordToSearch = window.userGiveWord();
        //if(!wordToSearch.equals("")) {
            String response = searchEngine.searchWordOnWiki(wordToSearch);

                window.informationAboutSearch(wordToSearch, response, searchEngine.getNumberOfSearches());

        //}
    }

}
