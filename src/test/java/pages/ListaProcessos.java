package pages;

import support.DriverQA;

public class ListaProcessos extends BasePage {

    public ListaProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clickNovoProcesso() {
        driver.click("btn-novo");
    }
}
