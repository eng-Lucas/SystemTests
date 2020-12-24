package pages;

import org.openqa.selenium.By;
import support.DriverQA;

public class ListaProcessos extends BasePage {

    public ListaProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clicarNovoProcesso() {
        driver.click("btn-novo");
    }

    public void clicarEditarProcesso(String codigo) {
        driver.click("btn-edit_" + codigo);
    }

    public void clicarMostrar(String codigo) {
        driver.click("btn-show_" + codigo);
    }

    public void clicarApagar(String codigo) {
        driver.click("btn-delete_" + codigo);
    }

    public void confirmarDelecao() {
        driver.ChooseOkOnNextConfirmation();
    }

    public boolean existeBotaoApagar(String codigo) {
    /*    boolean res = true;
        try {
            driver.getDriver().findElement(By.id("btn-delete_" + codigo));
        }
        catch(Exception ex){
            res = false;
        }
        return res;*/


        return driver.getDriver().getPageSource().contains("btn-delete_" + codigo);
    }
}
