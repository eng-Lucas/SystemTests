package pages;

import support.DriverQA;
import support.ElementType;

public class NovoProcesso extends BasePage{

    private String codigo;

    public NovoProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void preencherCampos(String campo, ElementType tipo, String valor) {
        switch (tipo) {
            case INPUT: preencherInput(campo, valor); break;
            case SELECT: preencherSelect(campo, valor); break;
            case RADIOBUTTON: preencherRadioButton(campo); break;
        }
    }

    private void preencherInput(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    private void preencherSelect(String campo, String valor) {
        driver.selectByText(valor, campo);
    }

    private void preencherRadioButton(String campo) {
        driver.click(campo);
    }

    public void clickSalvar() {
        driver.click("#btn-save", "css");
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
