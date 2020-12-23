package pages;

import support.DriverQA;

public class MenuPrincipal extends BasePage {

    public MenuPrincipal(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clickProcessos() {
        driver.click("processos");
    }
}
