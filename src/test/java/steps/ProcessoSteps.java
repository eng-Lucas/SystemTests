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
    private EditarProcesso editarProcesso = new EditarProcesso(driver);
    private DetalheProcesso detalheProcesso = new DetalheProcesso(driver);

    @Dado("^que o usuário está na página inicial$")
    public void queOUsuárioEstaNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuário clica no menu Processos$")
    public void queOUsuarioClicaNoMenuProcessos() {
        menuPrincipal.clicarProcessos();
    }

    @E("^o usuário clica no botão Novo Processo$")
    public void oUsuarioClicaNoBotaoNovoProcesso() {
        listaProcessos.clicarNovoProcesso();
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
        novoProcesso.clicarSalvar();
        novoProcesso.setCodigo(detalheProcesso.getCodigo());
    }

    @Então("^o usuário deveria ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerAMensagem(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, detalheProcesso.getNotice());
    }

    @E("^o usuário clicar no botão voltar$")
    public void oUsuarioClicarNoBotaoVoltar() {
        detalheProcesso.clicarVoltar();
    }

    @E("^o usuário clicar no botão editar do processo cadastrado$")
    public void oUsuarioClicarNoBotaoEditarDoProcessoCadastrado() {
        listaProcessos.clicarEditarProcesso(novoProcesso.getCodigo());
    }

    @Quando("^o usuário clicar no botão salvar na tela de edição$")
    public void oUsuarioClicarNoBotaoSalvarNaTelaDeEdicao() {
        editarProcesso.clicarSalvar();
    }

    @E("^o usuário preenche o campo \"([^\"]*)\" do tipo \"([^\"]*)\" com valor \"([^\"]*)\" na tela de edição$")
    public void oUsuarioPreencheOCampoDoTipoComValorNaTelaDeEdicao(String campo, ElementType tipo, String valor) throws Throwable {
        editarProcesso.preencherCampos(campo, tipo, valor);
    }

    @E("^o usuário preenche o campo \"([^\"]*)\" do tipo \"([^\"]*)\" para informar o valor \"([^\"]*)\"$")
    public void oUsuarioPreencheOCampoDoTipoParaInformarOValor(String campo, ElementType tipo, String valor) throws Throwable {
        editarProcesso.preencherCampos(campo, tipo, valor);
    }

    @Então("^o usuário deveria ver o valor \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOValorNoCampo(String valor, String campo) throws Throwable {
        Assert.assertEquals(valor, detalheProcesso.getCampo(campo));
    }

    @Quando("^o usuário clicar no botão mostrar$")
    public void oUsuarioClicarNoBotaoMostrar() {
        listaProcessos.clicarMostrar(novoProcesso.getCodigo());
    }

    @Quando("^o usuário clicar no botão apagar$")
    public void oUsuarioClicarNoBotaoApagar() {
        listaProcessos.clicarApagar(novoProcesso.getCodigo());
    }

    @E("^o usuário confirmar a deleção$")
    public void oUsuarioConfirmarADelecao() {
        listaProcessos.confirmarDelecao();
    }

    @Então("^o botão apagar não deve mais existir para o processo cadastrado$")
    public void oBotaoApagarNaoDeveMaisExistirParaOProcessoCadastrado() {
        Assert.assertFalse(listaProcessos.existeBotaoApagar(novoProcesso.getCodigo()));
    }

    @Então("^o usuário deveria ver a mensagem \"([^\"]*)\" na tela de cadastro$")
    public void oUsuarioDeveriaVerAMensagemNaTelaDeCadastro(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, novoProcesso.getNotice());
    }

    @Quando("^o usuário clicar no botão salvar na tela de cadastro$")
    public void oUsuárioClicarNoBotãoSalvarNaTelaDeCadastro() {
        novoProcesso.clicarSalvar();
    }
}
