package pages;

public class PaginaPrincipal extends BasePage {

    private String searchButton = "//*[@id=\"page_section_48252437\"]/div/section/div[2]";

    public PaginaPrincipal() {
        //driver en este caso viene del constructor de la BasePage
        super(driver);
    }
    
    //Método para navegar a FRT
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com/");
        clickElement(searchButton);
    }

}
