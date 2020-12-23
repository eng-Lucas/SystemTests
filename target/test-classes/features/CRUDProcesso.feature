#language: pt

Funcionalidade: CRUD do cadastro de um processo

  Cenario: Adicionar um novo processo
    Dado que o usuário está na página inicial
    E que o usuário clica no menu Processos
    E o usuário clica no botão Novo Processo
    E o usuário preenche o campo "processo_vara" do tipo "INPUT" com valor "Osasco"
    E o usuário preenche o campo "processo_numero_processo" do tipo "INPUT" com valor "12345"
    E o usuário preenche o campo "processo_natureza" do tipo "INPUT" com valor "Guarda"
    E o usuário preenche o campo "processo_partes" do tipo "INPUT" com valor "Lucas x Mirella"
    E o usuário preenche o campo "processo_urgente" do tipo "SELECT" com valor "Não"
    E o usuário preenche o campo "processo_arbitramento_s" do tipo "RADIOBUTTON" com valor "Sim"
    E o usuário preenche o campo "processo_assistente_social" do tipo "INPUT" com valor "Aline"
    E o usuário preenche o campo "processo_data_entrada" do tipo "INPUT" com valor "17/12/2020"
    E o usuário preenche o campo "processo_data_saida" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_data_agendamento" do tipo "INPUT" com valor ""
    E o usuário preenche o campo "processo_status" do tipo "INPUT" com valor "Aguardando"
    E o usuário preenche o campo "processo_observacao" do tipo "INPUT" com valor ""
    Quando o usuário clicar no botão salvar
    Então o usuário deveria ver a mensagem "Processo foi criado com sucesso."