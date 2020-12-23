package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;
import support.ElementType;

public class ProcessoSteps extends BaseSteps {

    private HomePage homePage = new HomePage(driver);
    private MenuPrincipal menuPrincipal = new MenuPrincipal(driver);
    private ListaProcessos listaProcessos = new ListaProcessos(driver);
    private NovoProcesso novoProcesso = new NovoProcesso(driver);
    private DetalheProcesso detalheProcesso = new DetalheProcesso(driver);

    @Dado("^que o usuário está na página inicial$")
    public void queOUsuárioEstaNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuário clica no menu Processos$")
    public void queOUsuarioClicaNoMenuProcessos() {
        menuPrincipal.clickProcessos();
    }

    @E("^o usuário clica no botão Novo Processo$")
    public void oUsuarioClicaNoBotaoNovoProcesso() {
        listaProcessos.clickNovoProcesso();
    }

    @E("^o usuário preenche o campo \"([^\"]*)\" com valor \"([^\"]*)\"$")
    public void oUsuarioPreencheOCampoComValor(String campo, String valor) throws Throwable {
        //novoProcesso.preencherCampos(campo, valor);
    }

    @E("^o usuário preenche o campo \"([^\"]*)\" do tipo \"([^\"]*)\" com valor \"([^\"]*)\"$")
    public void oUsuárioPreencheOCampoDoTipoComValor(String campo, ElementType tipo, String valor) throws Throwable {
        novoProcesso.preencherCampos(campo, tipo, valor);
    }

    @Quando("^o usuário clicar no botão salvar$")
    public void oUsuarioClicarNoBotaoSalvar() {
        novoProcesso.clickSalvar();
        novoProcesso.setCodigo(detalheProcesso.getCodigo());
    }

    @Então("^o usuário deveria ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerAMensagem(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, detalheProcesso.getNotice());
    }
}
