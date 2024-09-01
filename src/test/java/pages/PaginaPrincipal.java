package pages;

public class PaginaPrincipal extends BasePage {

    public PaginaPrincipal() {
        //driver en este caso viene del constructor de la BasePage
        super(driver);
    }
    
    //Método para navegar a FRT
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com/");
    }

}
