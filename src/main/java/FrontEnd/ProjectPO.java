/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package FrontEnd;

//import BackEnd.ListaUCs;
import BackEnd.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ProjectPO extends Consola {

    private final Consola consola = new Consola();
    Ficheiro ficheiro = new Ficheiro("Estado.txt");
    //private final Sistema sistema = new Sistema();
    Admnistrador adm = new Admnistrador("ADM", "000000");

    public static void main(String[] args) throws Exception {
        ProjectPO programa = new ProjectPO();
        programa.login();
    }

    public void login() {
        Sistema sistema;

        if (!ficheiro.getFile().exists()) {
            sistema = new Sistema();
        } else {
            sistema = ficheiro.carregarEstado();
            if (sistema == null) {
                sistema = new Sistema();
            }
        }

        consola.converterParaAscii("LOGIN:");

        int count = 0;
        String nome = "";
        String numero = "";
        while (count != 3) {
            nome = consola.lerString("\nNome:");
            if (nome.length() < 1) {
                consola.escreverErro("\nO nome deve conter pelo menos 1 Letra.");
            } else {
                count = count + 1;
            }
            if (nome.length() >= 100) {
                consola.escreverErro("\nO nome deve conter no maximo 100 Letras.");
            } else {
                count = count + 1;
            }
            if (consola.SoTemLetra(nome)) {
                count = count + 1;
            } else {
                consola.escreverErro("\nO nome deve conter apenas Letras.");
            }
            if (count == 3) {
                break;
            } else {
                count = 0;
            }
        }
        int count2 = 0;
        while (count2 != 3) {
            numero = consola.lerString("Numero Mecanografico:");
            if (numero.length() < 6) {
                consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
            } else {
                count2 = count2 + 1;
            }
            if (numero.length() > 6) {
                consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
            } else {
                count2 = count2 + 1;
            }
            if (consola.SoTemNumero(numero)) {
                count2 = count2 + 1;
            } else {
                consola.escreverErro("\nO Numero Mecanografico deve conter apenas Digitos.");
            }
            if (count2 == 3) {
                break;
            } else {
                count2 = 0;
            }
        }
        if (adm.verificarAdmnistrador(nome, numero)) {
            menuAdministrador(sistema);
        } else {
            Professor professor = sistema.verificarLogin(nome, numero);
            if (professor != null) {
                exibirMenuPrincipal(sistema, professor);
            }

        }
    }

    public void exibirMenuPrincipal(Sistema sistema, Professor professor) {
        while (true) {
            consola.converterParaAscii("Gestao de Departamento");
            consola.escrever("\n----- Menu Principal -----");

            int opcao;

            String[] opcoes = {
                "Entrar como Professor",
                "Entrar como Regente de UC",
                "Entrar como Diretor de Curso",
                "Sair"

            };

            consola.escrever("Escolha uma opção: ");
            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    menuProfessores(sistema, professor);
                    break;
                case 2:
                    UC ucEncontrada = sistema.verificarCargoRegente(professor);
                    if (ucEncontrada != null) {
                        menuRegente(sistema, professor, ucEncontrada);
                    } else {
                        consola.escreverErro("Não tem Permissões para aceder!");
                    }
                    break;
                case 3:
                    Curso cursoEncontrado = sistema.verificarCargoDiretor(professor);
                    if (cursoEncontrado != null) {
                        menuDiretorCurso(sistema, professor, cursoEncontrado);
                    } else {
                        consola.escreverErro("Não tem Permissões para aceder!");
                    }
                    break;
                case 4:
                    consola.escrever("Saindo do programa. Até mais!");
                    ficheiro.salvarEstado(sistema);
                    System.exit(0);
                    break;

            }
        }
    }

    public void menuAdministrador(Sistema sistema) {

        consola.converterParaAscii("Menu Admistrador");
        consola.escrever("\n");
        int opcao;
        do {
            String[] opcoes = {
                "Informações de Professores",
                "Informações de Cursos",
                "Informações de UCS",
                "Sair",};


            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    menuINFprofs(sistema);
                    break;

                case 2:
                    menuINFcursos(sistema);
                    break;

                case 3:
                    menuINFuc(sistema);
                    break;

                case 4:
                    consola.escrever("Saindo do programa. Até mais!");
                    ficheiro.salvarEstado(sistema);
                    //sistema.salvarEstado();
                    //System.exit(0);
                    break;

            }
        } while (opcao != 4);
    }

    public void menuINFprofs(Sistema sistema) {
        int opcao;
        do {
            String[] opcoes = {
                "Adicionar Professor",
                "Apagar Professor",
                "Alterar Informações de Professor",
                "Listar todos os Professores",
                "Atribuir UC",
                "Listar Professores por UC",
                "Voltar",};
            consola.escrever("\nIntroduza a opção pretendida:");

            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    criarProfessor(sistema);
                    break;

                case 2:
                    String RMVstor = consola.lerString("Digite o nome do Professor a ser apagado do Sistema:");
                    sistema.removerProfessor(RMVstor, sistema);
                    break;

                case 3:
                    String ALTstor = consola.lerString("Digite o numero do Professor a ser alterado:");
                    Professor novo = sistema.verificarLogin2(ALTstor);
                    alterarInformacoesProfessor(novo, sistema);
                    break;

                case 4:
                    sistema.ListarProfessores();
                    break;

                case 5:
                    String UCstor = consola.lerString("Digite o Número Mecanográfico do Professor a ser atribuido uma UC:");
                    String Storuc = consola.lerString("Digite a designação da UC ao qual o professor vai se juntar:");
                    if (sistema.AtribuirUC(UCstor, Storuc)) {
                        consola.escrever("Professor adicionado com sucesso.");
                    } else {
                        consola.escreverErro("Professor já existe na UC, ou erro.");
                    }

                    break;
                case 6:
                    sistema.ListarProfessoresPorTodosOsCursos();
                    break;
            }
        } while (opcao != 7);
    }

    public void menuINFcursos(Sistema sistema) {
        int opcao;
        do {
            String[] opcoes = {
                "Adicionar Curso",
                "Apagar Curso",
                "Alterar Nome do Curso",
                "Tornar Diretor de Curso",
                "Eliminar Cargo de Diretor de Curso",
                "Listar Cursos",
                "Adicionar Aluno Curso",
                "Remover Aluno Curso",
                "Listar alunos",
                "Voltar",};
            consola.escrever("Introduza a opção pretendida:");

            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    criarCurso(sistema);
                    break;

                case 2:
                    String RMVcurso = consola.lerString("Digite o nome do Curso a ser apagado do Sistema:");
                    sistema.removerCurso(RMVcurso);
                    break;

                case 3:
                    String ALTcurso = consola.lerString("Digite o nome do Curso a ser alterado:");
                    String novo = consola.lerString("Nova Designação:");
                    sistema.mudarDesignaçãoCurso(ALTcurso, novo);
                    break;

                case 4:
                    String codProf = consola.lerString("Digite o Numero Mecanografico do Professor que deseja tornar Diretor de Curso:");
                    String nomeCurso = consola.lerString("Digite o nome do Curso:");
                    sistema.tornarDiretorCurso(codProf, nomeCurso);
                    break;

                case 5:
                    String nome = consola.lerString("Digite o nome do Curso que deseja tirar o seu diretor:");
                    sistema.tirarDiretorCurso(nome);
                    break;

                case 6:
                    sistema.ListarCurso();
                    break;

                case 7:
                    criarAluno(sistema);
                    break;

                case 8:
                    String codigo = consola.lerString("Codigo de Aluno a remover:");
                    String curso = consola.lerString("A que Curso quer remover:");
                    sistema.removerAlunoCurso(sistema.verificarAlunoCurso(codigo, curso));
                    break;
                case 9:
                    sistema.ListarAlunos();
                    break;
            }
        } while (opcao != 10);
    }

    public void menuINFuc(Sistema sistema) {
        int opcao;
        do {
            String[] opcoes = {
                "Adicionar Unidade Curricular",
                "Apagar Unidade Curricular",
                "Alterar nome da Unidade Curricular",
                "Tornar Regente UC",
                "Eliminar Cargo de Regente",
                "Retirar Professor da Equipa Docente",
                "Listar Unidade Curriculares",
                "Voltar",};
            consola.escrever("Introduza a opção pretendida:");

            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    criarUc(sistema);
                    break;

                case 2:
                    String Uc = consola.lerString("Qual o nome da uc que deseja remover:");
                    sistema.removerUcs(Uc);
                    break;

                case 3:
                    String uc = consola.lerString("Qual o nome da uc que deseja alterar:");
                    String novaDesignacao = consola.lerString("Nova Designação:");
                    sistema.alterarINFucs(uc, novaDesignacao);
                    break;

                case 4:
                    String nome = consola.lerString("Qual o nome do professor que deseja tornar Regente:");
                    String uc1 = consola.lerString("Qual a Unidade Curricular: ");
                    sistema.tornarRegente(nome, uc1, sistema);
                    break;

                case 5:
                    String uc2 = consola.lerString("Qual a Unidade Curricular: ");
                    sistema.tirarRegente(uc2);
                    break;

                case 6:
                    String uc3 = consola.lerString("Qual a Unidade Curricular: ");
                    String numRemovido = consola.lerString("Qual o professor a ser eliminado da Equipa Docente: ");
                    sistema.retirarEquipaDocente(numRemovido, uc3);
                case 7:
                    sistema.ListarUCs();
                    break;
            }
        } while (opcao != 8);
    }

    public void menuProfessores(Sistema sistema, Professor professor) {

        consola.converterParaAscii("Menu Professor");
        int opcao;
        do {
            String[] opcoes = {
                "Criar Sumario",
                "Consultar lista de sumários por UC e por tipo de aula.",
                "Consultar Serviço Docente",
                "Sair",};

            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    criarSumario(sistema, professor);
                    break;

                case 2:
                    sistema.ListarSumariosPorUCEPorTipo(professor);
                    break;

                case 3:
                    professor.listaServicoDocente();
                    break;
            }
        } while (opcao != 4);
    }

    public void menuRegente(Sistema sistema, Professor regente, UC uc) {

        consola.converterParaAscii("Menu Regente da UC: " + uc.getDesignacaoUC());
        int opcao;
        do {
            String[] opcoes = {
                "Adicionar Aluno",
                "Remover Aluno",
                "Consultar Assiduidade",
                "Sair",};

            opcao = consola.lerInteiros(opcoes);
            switch (opcao) {
                case 1:
                    criarAluno(sistema);
                    break;

                case 2:
                    String aluno = consola.lerString("Qual o Aluno que deseja remover:");
                    break;

                case 3:
                    String codigo = consola.lerString("Qual é o codigo do Aluno:");
                    sistema.consultarAssiduidade(codigo, uc);
                    break;
            }
        } while (opcao != 4);
    }

    public void menuDiretorCurso(Sistema sistema, Professor professor, Curso curso) {

        consola.converterParaAscii("Menu Diretor de Curso    : " + curso.getDesignacaoCurso());
        int opcao;
        do {
            String[] opcoes = {
                "Alterar Designação do Curso",
                "Listar Numero Alunos",
                "Listar Numero Professores",
                "Sair",};

            opcao = consola.lerInteiros(opcoes);

            switch (opcao) {
                case 1:
                    mudarDesignação(curso);
                    break;

                case 2:
                    sistema.NumeroAlunosCurso(curso);
                    break;

                case 3:
                    sistema.listarNumeroProfessores(curso);
                    break;
            }
        } while (opcao != 4);
    }

    //Funções CRIAR
    public void criarCurso(Sistema sistema) {
        int count = 0;
        String designacaoCurso = consola.lerString("Designação:");
        String diretorCurso = "";
        while (count != 1) {
            diretorCurso = consola.lerString("Número Mecanográfico do Diretor de curso:");
            if (sistema.verificarExistenciadeNumeroMecanog(diretorCurso)) {
                count = count + 1;
            } else {
                consola.escreverErro("\nEste Numero Mecanografico não existe, logo é impossivel ser atribuido um Diretor.");
            }

        }

        Curso curso = new Curso(designacaoCurso, diretorCurso);
        sistema.addCurso(curso);
    }

    public void criarUc(Sistema sistema) {
        int count = 0, count2 = 0;
        String designacaoUC = consola.lerString("Designação:");
        String regenteUC = "";
        while (count != 1) {
            regenteUC = consola.lerString("Número Mecanográfico do Regente da UC:");
            if (sistema.verificarExistenciadeNumeroMecanog(regenteUC)) {
                count = count + 1;
            } else {
                consola.escreverErro("\nEste Numero Mecanografico não existe, logo é impossivel ser atribuido um Regente.");
            }

        }
        String designacaoCurso = consola.lerString("Designação do Curso a ser atribuido esta UC:");
        Curso curso = sistema.verificarCurso(designacaoCurso);
        if (curso != null) {
            UC uc = new UC(designacaoUC, regenteUC);
            curso.adicionarUCs(uc);
            sistema.AtribuirUC(regenteUC, uc.getDesignacaoUC());
        } else {
            consola.escreverErro("Curso não existe.");
        }
    }

    public void criarProfessor(Sistema sistema) {
        int count = 0, count2 = 0, count3 = 0;
        String nomeProfessor = "";
        String nMecanoProfessor = "";
        int dia = 0, mes = 0, ano = 0;
        double a;
        while (count != 3) {
            nomeProfessor = consola.lerString("Nome:");
            if (nomeProfessor.length() < 1) {
                consola.escreverErro("\nO nome deve conter pelo menos 1 Letra.");
            } else {
                count = count + 1;
            }
            if (nomeProfessor.length() >= 100) {
                consola.escreverErro("\nO nome deve conter no maximo 100 Letras.");
            } else {
                count = count + 1;
            }
            if (consola.SoTemLetra(nomeProfessor)) {
                count = count + 1;
            } else {
                consola.escreverErro("\nO nome deve conter apenas Letras.");
            }
            if (count == 3) {
                break;
            } else {
                count = 0;
            }
        }
        while (count2 != 4) {
            nMecanoProfessor = consola.lerString("Número Mecanográfico:");
            if (nMecanoProfessor.length() < 6) {
                consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
            } else {
                count2 = count2 + 1;
            }
            if (nMecanoProfessor.length() > 6) {
                consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
            } else {
                count2 = count2 + 1;
            }
            if (consola.SoTemNumero(nMecanoProfessor)) {
                count2 = count2 + 1;
            } else {
                consola.escreverErro("\nO Numero Mecanografico deve conter apenas Digitos.");
            }
            if (sistema.verificarExistenciadeNumeroMecanog(nMecanoProfessor)) {
                consola.escreverErro("\nEste Numero Mecanografico já existe.");
            } else {
                count2 = count2 + 1;
            }
            if (count2 == 4) {
                break;
            } else {
                count2 = 0;
            }
        }
        while (count3 != 3) {
            consola.escrever("Data de inicio de Funções:");
            ano = consola.lerInteiro("Digite o Ano em que começou:");
            if (ano < 1 || ano > 2024) {
                consola.escreverErro("\nO Ano deve estar Compreendido entre 1 e 2024.");
            } else {
                a = ano % 4;
                count3 = count3 + 1;
                mes = consola.lerInteiro("Digite o Mês em que começou:");
                if (mes < 1 || mes > 12) {
                    consola.escreverErro("\nO Mês deve estar Compreendido entre 1 e 12.");
                } else {
                    count3 = count3 + 1;
                    dia = consola.lerInteiro("Digite o Dia em que começou:");
                    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                        if (dia < 1 || dia > 31) {
                            consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 31.");
                        } else {
                            count3 = count3 + 1;
                        }
                    } else if (mes == 2 && a == 0) {
                        if (dia < 1 || dia > 29) {
                            consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 29.");
                        } else {
                            count3 = count3 + 1;
                        }
                    } else if (mes == 2 && a != 0) {
                        if (dia < 1 || dia > 28) {
                            consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 28.");
                        } else {
                            count3 = count3 + 1;
                        }
                    } else {
                        if (dia < 1 || dia > 30) {
                            consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 30.");
                        } else {
                            count3 = count3 + 1;
                        }
                    }
                }
            }
            if (count3 == 3) {
                break;
            } else {
                count3 = 0;
            }
        }

        String dataInicio = consola.DatadeIniciotoString(dia, mes, ano);

        Professor professor = new Professor(nomeProfessor, nMecanoProfessor, dataInicio/*,ListaUCs,ListaSumarios*/);
        sistema.addProfessor(professor);
    }

    public void criarSumario(Sistema sistema, Professor professor) {
        int count = 0;
        int opcao;
        String titulo = consola.lerString("Titulo:");
        String tipo = "";
        String[] opcoes = {
            "Teórica (T)",
            "Teórico-Prática (TP)",
            "Prático-Laboratorial (PL)",};
        consola.escrever("Tipo de Sumario");
        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                tipo = "T";
                break;

            case 2:
                tipo = "TP";
                break;

            case 3:
                tipo = "PL";
                break;
        }
        String uc = "";
        while (count != 1) {
            uc = consola.lerString("Uc:");
            if (sistema.verificarUC(uc)) {
                count = count + 1;
            } else {
                consola.escreverErro("UC não existe");
            }
        }
        String textoSumario = consola.lerString("Sumario:");
        LocalDateTime data_hora = consola.lerDataHora("Data e Hora:");
        ArrayList<Aluno> presencas = new ArrayList<>();

        // Loop para adicionar códigos dos alunos presentes
        consola.escrever("Adicione os códigos dos alunos presentes (pressione Enter para terminar):");
        boolean adicionarMaisAlunos = true;
        while (adicionarMaisAlunos) {
            String codigoAluno = consola.lerString("Código do Aluno (ou Enter para terminar):");
            if (!codigoAluno.isEmpty()) {
                // Verifica se o código do aluno existe no sistema
                if (sistema.verificarAluno(codigoAluno)) {
                    presencas.add(sistema.verificarAlunoObjeto(codigoAluno));
                } else {
                    consola.escreverErro("Aluno não existe. Por favor, verifique o código do aluno.");
                }
            } else {
                adicionarMaisAlunos = false;
            }
        }
        Sumario sumario = new Sumario(titulo, tipo, uc, textoSumario, data_hora, presencas);
        professor.addSumario(sumario);
    }

    public void criarAluno(Sistema sistema) {
        String nomeAluno = consola.lerString("Nome do Aluno: ");
        String nMecanoAluno = consola.lerString("Numero Mecanografico: ");
        String curso = consola.lerString("Curso: ");

        Aluno aluno = new Aluno(nomeAluno, nMecanoAluno, curso);
        for (Curso c : sistema.getListaCursos()) {
            if (c.getDesignacaoCurso().equals(curso)) {
                c.inserirAlunoCurso(aluno);
            }
        }

    }

    public void alterarInformacoesProfessor(Professor a, Sistema sistema) {
        int opcao;
        int count = 0, count2 = 0, count3 = 0;
        String nomeProfessor = "";
        String nMecanoProfessor = "";
        int dia = 0, mes = 0, ano = 0;
        double b;

        String[] opcoes = {
            "Alterar Nome ",
            "Alterar Numero Mecanografico",
            "Alterar Data de Inicio",
            "Atribuir Serviço Docente",
            "Remover Serviço Docente",
            "Voltar",};
        consola.escrever("Introduza a opção pretendida");
        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                while (count != 3) {
                    nomeProfessor = consola.lerString("Nome:");
                    if (nomeProfessor.length() < 1) {
                        consola.escreverErro("\nO nome deve conter pelo menos 1 Letra.");
                    } else {
                        count = count + 1;
                    }
                    if (nomeProfessor.length() >= 100) {
                        consola.escreverErro("\nO nome deve conter no maximo 100 Letras.");
                    } else {
                        count = count + 1;
                    }
                    if (consola.SoTemLetra(nomeProfessor)) {
                        count = count + 1;
                    } else {
                        consola.escreverErro("\nO nome deve conter apenas Letras.");
                    }
                    if (count == 3) {
                        a.setNomeProfessor(nomeProfessor);
                        break;
                    } else {
                        count = 0;
                    }
                }

            case 2:
                while (count2 != 4) {
                    nMecanoProfessor = consola.lerString("Número Mecanográfico:");
                    if (nMecanoProfessor.length() < 6) {
                        consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
                    } else {
                        count2 = count2 + 1;
                    }
                    if (nMecanoProfessor.length() > 6) {
                        consola.escreverErro("\nO Numero Mecanografico deve conter 6 Digitos.");
                    } else {
                        count2 = count2 + 1;
                    }
                    if (consola.SoTemNumero(nMecanoProfessor)) {
                        count2 = count2 + 1;
                    } else {
                        consola.escreverErro("\nO Numero Mecanografico deve conter apenas Digitos.");
                    }
                    if (sistema.verificarExistenciadeNumeroMecanog(nMecanoProfessor)) {
                        consola.escreverErro("\nEste Numero Mecanografico já existe.");
                    } else {
                        count2 = count2 + 1;
                    }
                    if (count2 == 4) {
                        a.setNMecanoProfessor(nMecanoProfessor);
                        break;
                    } else {
                        count2 = 0;
                    }
                }
            case 3:
                while (count3 != 3) {
                    consola.escrever("Data de inicio de Funções:");
                    ano = consola.lerInteiro("Digite o Ano em que começou:");
                    if (ano < 1 || ano > 2024) {
                        consola.escreverErro("\nO Ano deve estar Compreendido entre 1 e 2024.");
                    } else {
                        b = ano % 4;
                        count3 = count3 + 1;
                        mes = consola.lerInteiro("Digite o Mês em que começou:");
                        if (mes < 1 || mes > 12) {
                            consola.escreverErro("\nO Mês deve estar Compreendido entre 1 e 12.");
                        } else {
                            count3 = count3 + 1;
                            dia = consola.lerInteiro("Digite o Dia em que começou:");
                            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                                if (dia < 1 || dia > 31) {
                                    consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 31.");
                                } else {
                                    count3 = count3 + 1;
                                }
                            } else if (mes == 2 && b == 0) {
                                if (dia < 1 || dia > 29) {
                                    consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 29.");
                                } else {
                                    count3 = count3 + 1;
                                }
                            } else if (mes == 2 && b != 0) {
                                if (dia < 1 || dia > 28) {
                                    consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 28.");
                                } else {
                                    count3 = count3 + 1;
                                }
                            } else {
                                if (dia < 1 || dia > 30) {
                                    consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 30.");
                                } else {
                                    count3 = count3 + 1;
                                }
                            }
                        }
                    }
                    if (count3 == 3) {
                        String dataInicio = consola.DatadeIniciotoString(dia, mes, ano);
                        a.setDataInicio(dataInicio);
                        break;
                    } else {
                        count3 = 0;
                    }
                }
            case 4:
                a.inserirServicoDocente(sistema.EncontrarUC(consola.lerString("Serviço Docente:")));
                break;
            case 5:
                a.removerServicoDocente(sistema.EncontrarUC(consola.lerString("Serviço Docente:")));
                break;
            case 6:
                break;
        }
    }

    public void mudarDesignação(Curso a) {
        a.setDesignacaoCurso(consola.lerString("Nova Designação: "));
    }

}
