public class Controller {
    private Window window;
    private SearchEngine searchEngine;

    Controller(){
        window = new Window();
        searchEngine = new SearchEngine();
    }

    public void workingFunction() {

        String wordToSearch = window.userGiveWord();
        //if(!wordToSearch.equals("")) {
            String response = searchEngine.userCanLoginByUsername(wordToSearch);
            window.informationAboutSearch(wordToSearch, response, searchEngine.getNumberOfSearches());

        //}
    }

}
