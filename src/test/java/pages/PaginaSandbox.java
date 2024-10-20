package pages;

public class PaginaSandbox extends BasePage {

    private String infoTextXpath = "//p[contains(., 'Visita nuestra página en') and contains(., 'www.freerangetesters.com')]";
    private String botonOcultoXpath = "//button[contains(text(),'Hacé click para generar un ID dinámico y mostrar el elemento oculto')]";
    private String textoElementoOculto = "//p[contains(text(),'OMG, aparezco después de 3 segundos')]";


    public PaginaSandbox() {
        super(driver);
    }

    public String getInfoText() {
        return getElementText(infoTextXpath);
    }

    public String getLink() {
        return getLink("www.freerangetesters.com");
    }

    public void clickOnElementoOcultoButton() {
        clickElement(botonOcultoXpath);
    }

    public String getTextoElementoOculto() {
        return getElementText(textoElementoOculto);
    }
}
