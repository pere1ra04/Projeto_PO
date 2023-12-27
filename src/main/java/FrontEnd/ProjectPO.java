/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package FrontEnd;

//import BackEnd.ListaUCs;
import BackEnd.Admnistrador;
import BackEnd.Sistema;
import BackEnd.Professor;
import BackEnd.Aluno;
import BackEnd.Curso;
import BackEnd.Sumario;
import BackEnd.UC;
import java.util.Scanner;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class ProjectPO extends Consola {

    private final Consola consola = new Consola();
    private final Sistema sistema = new Sistema();
    Admnistrador adm = new Admnistrador("ADM", "000000");

    public static void main(String[] args) throws Exception {
        ProjectPO programa = new ProjectPO();
        programa.login();
    }

    public void login() {

        consola.converterParaAscii("Login:", 100);
        int count = 0;
        String nome = "";
        String numero = "";
        while (count != 3) {
            nome = consola.lerString("Nome:");
            if (nome.length() < 1) {
                consola.escreverErro("O nome deve conter pelo menos 1 Letra.");
            } else {
                count = count + 1;
            }
            if (nome.length() >= 100) {
                consola.escreverErro("O nome deve conter no maximo 100 Letras.");
            } else {
                count = count + 1;
            }
            if (consola.SoTemLetra(nome)) {
                count = count + 1;
            } else {
                consola.escreverErro("O nome deve conter apenas Letras.");
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
                consola.escreverErro("O Numero Mecanografico deve conter pelo menos 1 Digito.");
            } else {
                count2 = count2 + 1;
            }
            if (numero.length() > 6) {
                consola.escreverErro("O Numero Mecanografico deve conter no maximo 6 Digitos.");
            } else {
                count2 = count2 + 1;
            }
            if (consola.SoTemNumero(numero)) {
                count2 = count2 + 1;
            } else {
                consola.escreverErro("O Numero Mecanografico deve conter apenas Digitos.");
            }
            if (count2 == 3) {
                break;
            } else {
                count2 = 0;
            }
        }
        if (adm.verificarAdmnistrador(nome, numero)) {
            menuAdministrador();
        }
        exibirMenuPrincipal();
    }

    public void exibirMenuPrincipal() {
        while (true) {
            consola.converterParaAscii("Gestao de Departamento", 100);
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
                    menuProfessores();
                    break;
                case 2:
                    menuRegente();
                    break;
                case 3:
                    menuDiretorCurso();
                    break;
                case 4:
                    consola.escrever("Saindo do programa. Até mais!");
                    System.exit(0);
                    break;

            }
        }
    }

    public void menuAdministrador() {

        consola.converterParaAscii("Menu Admistrador", 20);
        int opcao;
        String[] opcoes = {
            "Informações de Professores",
            "Informações de Cursos",
            "Informações de UCS",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                //info
                break;

            case 2:
                //info
                break;

            case 3:
                //info
                break;

            case 4:
                consola.escrever("Saindo do programa. Até mais!");
                System.exit(0);
                break;

        }
    }

    public void menuProfessores() {

        consola.converterParaAscii("Menu Professor", 20);
        int opcao;
        String[] opcoes = {
            "Criar Sumario",
            "Consultar Sumarios",
            "Consultar Serviço Docente",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                //info
                break;

            case 2:
                //info
                break;

            case 3:
                //info
                break;

            case 4:
                //info
                break;
        }
    }

    public void menuRegente() {

        consola.converterParaAscii("Menu Regente da UC: ", 20); //ADICIONAR O NOME DA UC POR REFERNCIA
        int opcao;
        String[] opcoes = {
            "Adicionar Aluno",
            "Remover Aluno",
            "Consultar Assiduidade",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                //info
                break;

            case 2:
                //info
                break;

            case 3:
                //info
                break;

            case 0:
                //info
                break;

        }
    }

    public void menuDiretorCurso() {

        consola.converterParaAscii("Menu Diretor de Curso    : ", 20); //ADICIONAR O NOME Do curso POR REFERNCIA
        int opcao;
        String[] opcoes = {
            "Alterar Designação do Curso",
            "Listar Alunos",
            "Listar Professores",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);

        switch (opcao) {
            case 1:
                //info
                break;

            case 2:
                //info
                break;

            case 3:
                //info
                break;

            case 4:
                //info
                break;

        }
    }

    //Funções CRIAR
    public void criarCurso() {
        String designacaoCurso = consola.lerString("Designação:");
        String diretorCurso = consola.lerString("Regente UC:");

        Curso curso = new Curso(designacaoCurso, diretorCurso);
    }

    public void criarUc() {
        String designacaoUC = consola.lerString("Designação:");
        String regenteUC = consola.lerString("Regente UC:");

        UC uc = new UC(designacaoUC, regenteUC);
    }

    public void criarProfessor() {
        String nomeProfessor = consola.lerString("Nome:");
        String nMecanoProfessor = consola.lerString("Número Mecanográfico:");
        String dataInicio = consola.lerString("Data de inicio de Funções:");
        //ArrayList<UC> ListaUCs = new ArrayList<>();
        //ArrayList<Sumario> ListaSumarios = new ArrayList<>();

        Professor professor = new Professor(nomeProfessor, nMecanoProfessor, dataInicio/*,ListaUCs,ListaSumarios*/);
    }

    public void criarSumario() {

        String titulo = consola.lerString("Titulo:");
        String tipo = consola.lerString("Tipo de Sumario");
        String uc = consola.lerString("Uc:");
        String textoSumario = consola.lerString("Sumario:");
        LocalDateTime data_hora = consola.lerDataHora("Data e Hora:");
        //ArrayList<Aluno> presencas =  new ArrayList<>();

        Sumario sumario = new Sumario(titulo, tipo, uc, textoSumario, data_hora/*,presencas*/);
    }

    public void criarAluno() {
        String nomeAluno = consola.lerString("Nome do Aluno: ");
        String nMecanoAluno = consola.lerString("Numero Mecanografico: ");
        String curso = consola.lerString("Curso: ");

        Aluno aluno = new Aluno(nomeAluno, nMecanoAluno, curso);
    }

    public void alterarInformacoesProfessor(Professor a) {
        int opcao;
        String[] opcoes = {
            "Alterar Nome ",
            "Alterar Numero Mecanografico",
            "Alterar Data de Inicio",
            "Atribuir Serviço Docente"
            "Remover Serviço Docente"
            "Voltar",};
        consola.escrever("Introduza a opção pretendida");
        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                a.setNomeProfessor(consola.lerString("Nome Professor: "));
                break;
            case 2:
                a.setNMecanoProfessor(consola.lerString("NMecanografico Professor: "));
                break;
            case 3:
                a.setDataInicio(consola.lerString("Data Inicio Professor:"));
                break;
            case 4:
                //Ver isto
                a.inserirServicoDocente(sistema.EncontrarUC(consola.lerString("Serviço Docente:")));
                break;
            case 5:
                //Ver isto
                a.removerServicoDocente(sistema.EncontrarUC(consola.lerString("Serviço Docente:")));
                break;
            case 6:
                break;
        }
    }

}
