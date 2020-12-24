#language: pt

#tag na funcionalidade para não afetar a execução do verify
@run
Funcionalidade: CRUD do cadastro de um processo

  Contexto: Adicionar um novo processo
    Dado que o usuário está na página inicial
    E que o usuário clica no menu Processos
    E o usuário clica no botão Novo Processo
    E o usuário preenche o campo "processo_vara" do tipo "INPUT" com valor "Osasco"
    E o usuário preenche o campo "processo_numero_processo" do tipo "INPUT" com valor "12345"
    E o usuário preenche o campo "processo_natureza" do tipo "INPUT" com valor "Guarda"
    E o usuário preenche o campo "processo_partes" do tipo "INPUT" com valor "Lucas x Mirella"
    E o usuário preenche o campo "processo_urgente" do tipo "SELECT" com valor "Não"
    E o usuário preenche o campo "processo_arbitramento_s" do tipo "RADIOBUTTON" para informar o valor "Sim"
    E o usuário preenche o campo "processo_assistente_social" do tipo "INPUT" com valor "Aline"
    E o usuário preenche o campo "processo_data_entrada" do tipo "INPUT" com valor "17/12/2020"
    E o usuário preenche o campo "processo_data_saida" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_data_agendamento" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_status" do tipo "INPUT" com valor "Aguardando"
    E o usuário preenche o campo "processo_observacao" do tipo "INPUT" com valor ""

  Cenario: Adicionar um novo processo
    Quando o usuário clicar no botão salvar
    Então o usuário deveria ver a mensagem "Processo foi criado com sucesso."

  Cenario: Criar e mostrar o processo criado
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    Quando o usuário clicar no botão mostrar
    Então o usuário deveria ver o valor "Osasco" no campo "vara"
    E o usuário deveria ver o valor "12345" no campo "numero"
    E o usuário deveria ver o valor "Guarda" no campo "natureza"
    E o usuário deveria ver o valor "Lucas x Mirella" no campo "partes"
    E o usuário deveria ver o valor "N" no campo "urgente"
    E o usuário deveria ver o valor "S" no campo "arbitramento"
    E o usuário deveria ver o valor "Aline" no campo "as_social"
    E o usuário deveria ver o valor "2020-12-17" no campo "dt_entrada"
    E o usuário deveria ver o valor "" no campo "dt_saida"
    E o usuário deveria ver o valor "" no campo "dt_agendamento"
    E o usuário deveria ver o valor "Aguardando" no campo "status"
    E o usuário deveria ver o valor "" no campo "observacao"

  Cenário: Criar, alterar e verificar se a alteração foi aplicada
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    E o usuário clicar no botão editar do processo cadastrado
    E o usuário preenche o campo "processo_vara" do tipo "INPUT" com valor "São Paulo" na tela de edição
    Quando o usuário clicar no botão salvar na tela de edição
    Então o usuário deveria ver o valor "São Paulo" no campo "vara"

  Cenário: Criar e deletar o processo
    E o usuário clicar no botão salvar
    E o usuário clicar no botão voltar
    Quando o usuário clicar no botão apagar
    E o usuário confirmar a deleção
    Então o botão apagar não deve mais existir para o processo cadastrado

  Esquema do Cenário: Validação do cadastro com esquema de cenário. Vara = <vara>, Número do processo = <numero_processo>, Natureza = <natureza>, Partes = <partes>, Data de entrada = <data_entrada> e Status = <status>
    Dado que o usuário está na página inicial
    E que o usuário clica no menu Processos
    E o usuário clica no botão Novo Processo
    E o usuário preenche o campo "processo_vara" do tipo "INPUT" com valor "<vara>"
    E o usuário preenche o campo "processo_numero_processo" do tipo "INPUT" com valor "<numero_processo>"
    E o usuário preenche o campo "processo_natureza" do tipo "INPUT" com valor "<natureza>"
    E o usuário preenche o campo "processo_partes" do tipo "INPUT" com valor "<partes>"
    E o usuário preenche o campo "processo_urgente" do tipo "SELECT" com valor "Não"
    E o usuário preenche o campo "processo_arbitramento_s" do tipo "RADIOBUTTON" com valor "Sim"
    E o usuário preenche o campo "processo_assistente_social" do tipo "INPUT" com valor "Aline"
    E o usuário preenche o campo "processo_data_entrada" do tipo "INPUT" com valor "<data_entrada>"
    E o usuário preenche o campo "processo_data_saida" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_data_agendamento" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_status" do tipo "INPUT" com valor "<status>"
    E o usuário preenche o campo "processo_observacao" do tipo "INPUT" com valor ""
    Quando o usuário clicar no botão salvar na tela de cadastro
    Então o usuário deveria ver a mensagem "<mensagem>" na tela de cadastro

    Exemplos:
      | vara   | numero_processo | natureza | partes          | data_entrada | status     | mensagem                                       |
      #| Osasco | 1234            | Guarda   | Lucas x Mirella | 17/12/2020   | Aguardando | Processo foi criado com sucesso.       |
      #|        |                 |          |                 |              |            | entidade não processada |
      | Osasco | 1234            | Guarda   | Lucas x Mirella | 17/12/2020   |            | Status não pode ser deixado em branco          |
      | Osasco | 1234            | Guarda   | Lucas x Mirella |              | Aguardando | Data entrada não pode ser deixado em branco    |
      | Osasco | 1234            | Guarda   |                 | 17/12/2020   | Aguardando | Partes não pode ser deixado em branco          |
      | Osasco | 1234            |          | Lucas x Mirella | 17/12/2020   | Aguardando | Natureza não pode ser deixado em branco        |
      | Osasco |                 | Guarda   | Lucas x Mirella | 17/12/2020   | Aguardando | Numero processo não pode ser deixado em branco |
      |        | 1234            | Guarda   | Lucas x Mirella | 17/12/2020   | Aguardando | Vara não pode ser deixado em branco            |
      | Osasco | 1234            | Guarda   | Lucas x Mirella | Invalida     | Aguardando | Data entrada não pode ser deixado em branco    |

