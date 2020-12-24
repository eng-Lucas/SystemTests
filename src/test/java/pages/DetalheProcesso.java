package pages;

import support.DriverQA;

public class DetalheProcesso extends BasePage{

    public DetalheProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public String getNotice() {
        return driver.getText("notice");
    }

    public String getCodigo(){
        return driver.getText("codigo");
    }

    public void clicarVoltar() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public String getCampo(String campo) {
        driver.waitElement(campo);
        return driver.getText(campo);
    }
}
