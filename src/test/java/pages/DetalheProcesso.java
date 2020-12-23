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
}
