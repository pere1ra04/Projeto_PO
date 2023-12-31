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
<<<<<<< Updated upstream
        //sistema.carregarEstado();
        consola.converterParaAscii("Login:", 100);
=======

        consola.converterParaAscii("LOGIN:");
>>>>>>> Stashed changes
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
            menuAdministrador();
        }else{
        exibirMenuPrincipal();
        }
   }
    public void exibirMenuPrincipal() {
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
                    menuProfessores();
                    break;
                case 2:
                    menuRegente();
                    break;
                case 3:
                    for(Curso c: listaCursos){
                        
                    }
                    menuDiretorCurso();
                    break;
                case 4:
                    consola.escrever("Saindo do programa. Até mais!");
                    sistema.salvarEstado();
                    System.exit(0);
                    break;

            }
        }
    }

    public void menuAdministrador() {

        consola.converterParaAscii("Menu Admistrador");
        int opcao;
        do{
        String[] opcoes = {
            "Informações de Professores",
            "Informações de Cursos",
            "Informações de UCS",
            "Sair",};

        consola.escrever("Introduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                menuINFprofs();
            break;
                
            case 2:
                menuINFcursos();
            break;

            case 3:
                menuINFuc();
            break;

            case 4:
                consola.escrever("Saindo do programa. Até mais!");
                //sistema.salvarEstado();
                System.exit(0);
                break;

        }
    }while(opcao!=4);
}
    
    public void menuINFprofs(){
        int opcao;
        do{
                String[] opcoes = {
                  "Adicionar Professor",
                  "Apagar Professor",
                  "Alterar Informações de Professor",
                  "Listar todos os Professores",
                  "Voltar",};
                consola.escrever("\nIntroduza a opção pretendida:");
                
                
                opcao = consola.lerInteiros(opcoes);
                switch(opcao){
                    case 1:
                        criarProfessor();
                    break;
                    
                    case 2:
                        String RMVstor = consola.lerString("Digite o nome do Professor a ser apagado do Sistema:");
                        sistema.removerProfessor(RMVstor);
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                       // sistema.ListarProfessores();
                    break;

                }
        }while(opcao!=5);
    }
    
    public void menuINFcursos(){
        int opcao;
        do{
                String[] opcoes = {
                  "Adicionar Curso",
                  "Apagar Curso",
                  "Alterar Informações do Curso",
                  "Listar Cursos",
                  "Voltar",};
                consola.escrever("Introduza a opção pretendida:");
                
                opcao = consola.lerInteiros(opcoes);
                switch(opcao){
                    case 1:
                        criarCurso();
                    break;
                    
                    case 2:
                        String RMVcurso = consola.lerString("Digite o nome do Curso a ser apagado do Sistema:");
                        sistema.removerCurso(RMVcurso);
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                        sistema.ListarCurso();
                    break;
                }
        }while(opcao!=5);
    }
    
    public void menuINFuc(){
        int opcao;
        do{
                String[] opcoes = {
                  "Adicionar Unidade Curricular",
                  "Apagar Unidade Curricular",
                  "Alterar Informações da Unidade Curricular",
                  "Listar Unidade Curriculares",
                  "Voltar",};
                consola.escrever("Introduza a opção pretendida:");
                
                opcao = consola.lerInteiros(opcoes);
                switch(opcao){
                    case 1:
                        criarUc();
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                        sistema.ListarUCs();
                    break;
                }
        }while(opcao!=5);
    }
    
    public void menuProfessores() {

        consola.converterParaAscii("Menu Professor");
        int opcao;
        do{
        String[] opcoes = {
            "Criar Sumario",
            "Consultar lista de sumários por UC e por tipo de aula.",
            "Consultar Serviço Docente",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                //criarSumario();
                break;

            case 2:
                //sistema.ListarSumariosPorUCEPorTipo(p);
                //passar como argumento o professor, quando se faz o login tentar passar o objeto Professor
                //se não mudar o parametro recebido depois
                break;

            case 3:
                //info
                break;
        }
      }while(opcao!=4);
    }

    public void menuRegente() {

        consola.converterParaAscii("Menu Regente da UC: "); //ADICIONAR O NOME DA UC POR REFERNCIA
        int opcao;
        do{
        String[] opcoes = {
            "Adicionar Aluno",
            "Remover Aluno",
            "Consultar Assiduidade",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);
        switch (opcao) {
            case 1:
                criarAluno();
                //info
                break;

            case 2:
                //info
                break;

            case 3:
                //info
                break;
        }
      }while(opcao!=4);
    }

    public void menuDiretorCurso() {

        consola.converterParaAscii("Menu Diretor de Curso    : "); //ADICIONAR O NOME Do curso POR REFERNCIA
        int opcao;
        do{
        String[] opcoes = {
            "Alterar Designação do Curso",
            "Listar Alunos",
            "Listar Professores",
            "Sair",};

        consola.escrever("Inttroduza a opção pretendida");

        opcao = consola.lerInteiros(opcoes);

        switch (opcao) {
            case 1:
                //mudarDesignação(a);
                //info
                break;

            case 2:
                String nomedocurso = consola.lerString("Nome do Curso:");
//                Sistema.NumeroAlunosCurso(nomedocurso);
                //depois têm que se mudar de forma com que o diretor só liste do seu curso
                break;

            case 3:
                String nomedocurso2 = consola.lerString("Nome do Curso:");
  //              Sistema.ListarProfessoresPorCurso(nomedocurso2);
                //depois têm que se mudar de forma com que o diretor só liste do seu curso
                break;
        }
      }while(opcao!=4);
    }

    //Funções CRIAR
    public void criarCurso() {
        String designacaoCurso = consola.lerString("Designação:");
        String diretorCurso = consola.lerString("Regente UC:");

        Curso curso = new Curso(designacaoCurso, diretorCurso);
        sistema.addCurso(curso);
    }

    public void criarUc() {
        String designacaoUC = consola.lerString("Designação:");
        String regenteUC = consola.lerString("Regente UC:");

        UC uc = new UC(designacaoUC, regenteUC);
    }
    
    public void criarProfessor() {
        int count=0, count2=0, count3=0;
        String nomeProfessor = "";
        String nMecanoProfessor = "";
        int dia=0, mes=0, ano=0;
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
            if(sistema.verificarExistenciadeNumeroMecanog(nMecanoProfessor)){
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
        while(count3!=3){
            consola.escrever("Data de inicio de Funções:");
            ano = consola.lerInteiro("Digite o Ano em que começou:");
            if(ano<1 || ano>2024){
                consola.escreverErro("\nO Ano deve estar Compreendido entre 1 e 2024.");
            }else{
            a = ano % 4;
            count3 = count3 + 1;
            mes = consola.lerInteiro("Digite o Mês em que começou:");
            if(mes<1 || mes>12){
                consola.escreverErro("\nO Mês deve estar Compreendido entre 1 e 12.");
            }else{
                count3 = count3 + 1;
                dia = consola.lerInteiro("Digite o Dia em que começou:");
                if(mes == 1 ||  mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
                    if(dia<1 || dia>31){
                        consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 31.");
                    }else{
                        count3 = count3 + 1;
                    }
                }else if(mes == 2 && a == 0){
                    if(dia<1 || dia>29){
                        consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 29.");
                    }else{
                        count3 = count3 + 1;
                    }
                }else if(mes == 2 && a != 0){
                    if(dia<1 || dia>28){
                        consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 28.");
                    }else{
                        count3 = count3 + 1;
                        }
                    }else{
                    if(dia<1 || dia>30){
                        consola.escreverErro("\nO Dia deve estar Compreendido entre 1 e 30.");
                    }else{
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
        //ArrayList<UC> ListaUCs = new ArrayList<>();
        //ArrayList<Sumario> ListaSumarios = new ArrayList<>();

        Professor professor = new Professor(nomeProfessor, nMecanoProfessor, dataInicio/*,ListaUCs,ListaSumarios*/);
        sistema.addProfessor(professor);
    }
<<<<<<< HEAD
    
<<<<<<< Updated upstream
=======
   /* 
>>>>>>> 0900c216d983b2d0860c5d32060962a3cd39903f
   public void tornarRegente() {
=======
    public void tornarRegente() {
>>>>>>> Stashed changes
        String nome = consola.lerString("Qual o nome do professor que deseja tornar Regente:");
        boolean professorEncontrado = false;

    // Procurar na lista de professores
   /* for (Professor a : listaProfessores) {
        if (a.getNomeProfessor().equals(nome)) {
            professorEncontrado = true;

            String uc = consola.lerString("Qual a Unidade Curricular:");
            boolean ucEncontrada = false;

            // Verificar se a UC existe e se já tem regente
            for (UC b : listaUcs) {
                if (b.getDesignacaoUC().equals(uc)) {
                    ucEncontrada = true;

                    if (b.getRegenteUC() == null) {
                        b.setRegenteUC(nome);
                    } else {
                        consola.escreverErro("Esta Unidade Curricular já tem Regente");
                    }
                }
            }

            if (!ucEncontrada) {
                consola.escreverErro("Unidade Curricular não encontrada");
            }
            break; 
        }
    }

    if (!professorEncontrado) {
        consola.escreverErro("Professor não encontrado");
    }
    }
    
    public void retirarRegente() {
        String uc = consola.lerString("Qual a Unidade Curricular:");
        boolean ucEncontrada = false;

            for (UC b : listaUcs) {
                if (b.getDesignacaoUC().equals(uc)) {
                    b.setRegenteUC(null);
                    ucEncontrada = true;
                break; //para se encontrar
                }
            }

        if (!ucEncontrada) {
        consola.escreverErro("Unidade Curricular não encontrada");
        }
    }
    
    public void tornarDiretor() {
        String nome = consola.lerString("Qual o nome do professor que deseja tornar Diretor:");
        boolean professorEncontrado = false;

    // Procurar na lista de professores
        for (Professor a : listaProfessores) {
            if (a.getNomeProfessor.equals(nome)) {
                professorEncontrado = true;

                String curso = consola.lerString("Qual o Curso:");
                boolean cursoEncontrado = false;

            // Verificar se o curso existe e se já tem diretor
                for (Curso c : listaCursos) {
                    if (c.getDesignacaoCurso().equals(curso)) {
                        cursoEncontrado = true;

                    if (c.getDiretorCurso() == null) {
                        c.setDiretorCurso(nome);
                    } else {
                        consola.escreverErro("Este Curso já tem Diretor");
                    }
                }
            }

            if (!cursoEncontrado) {
                consola.escreverErro("Curso não encontrado");
            }
            break;  // Se encontrou o professor, não precisa continuar procurando.
        }
    }

        if (!professorEncontrado) {
            consola.escreverErro("Professor não encontrado");
        }
    }
    
    public void retirarDiretor() {
        String curso = consola.lerString("Qual o Curso que deseja remover o Diretor:");
        boolean cursoEncontrado = false;

    // Procurar na lista de cursos
        for (Curso c : listaCursos) {
            if (c.getDesignacaoCurso().equals(curso)) {
                cursoEncontrado = true;

            if (c.getDiretorCurso() != null) {
                consola.escrever("Diretor removido do curso: " + c.getDesignacaoCurso());
                c.setDiretorCurso(null);
            } else {
                consola.escreverErro("Este Curso não tem Diretor para remover");
            }

            break;
        }
    }

        if (!cursoEncontrado) {
            consola.escreverErro("Curso não encontrado");
        }
    }*/

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
            "Atribuir Serviço Docente",
            "Remover Serviço Docente",
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

    public void mudarDesignação(Curso a){
        a.setDesignacaoCurso(consola.lerString("Nova Designação: "));
    }
}
