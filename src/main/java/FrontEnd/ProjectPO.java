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
        }else{
            Professor professor = sistema.verificarLogin(nome, numero);
            if(professor != null){
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
                    menuRegente(sistema);
                    break;
                case 3:
                    menuDiretorCurso(sistema);
                    break;
                case 4:
                    consola.escrever("Saindo do programa. Até mais!");
                    ficheiro.salvarEstado(sistema);
                    //sistema.salvarEstado();
                    //System.exit(0);
                    break;

            }
        }
    }

    public void menuAdministrador(Sistema sistema) {

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
    }while(opcao!=4);
}
    
    public void menuINFprofs(Sistema sistema){
        int opcao;
        do{
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
                switch(opcao){
                    case 1:
                        criarProfessor(sistema);
                    break;
                    
                    case 2:
                        String RMVstor = consola.lerString("Digite o nome do Professor a ser apagado do Sistema:");
                        sistema.removerProfessor(RMVstor);
                    break;
                    
                    case 3:
                        String ALTstor = consola.lerString("Digite o nome do Professor a ser alterado:");
                        //alterarInformacoesProfessor(ALTstor, sistema);
                    break;
                    
                    case 4:
                       sistema.ListarProfessores();
                    break;
                    
                    case 5:
                        String UCstor = consola.lerString("Digite o Número Mecanográfico do Professor a ser atribuido uma UC:");
                        String Storuc = consola.lerString("Digite a designação da UC ao qual o professor vai se juntar:");
                        if(sistema.AtribuirUC(UCstor, Storuc)){
                            consola.escrever("Professor adicionado com sucesso.");
                        }else{
                            consola.escreverErro("Professor já existe na UC, ou erro.");
                        }
                        
                    break;
                    case 6:
                        sistema.ListarProfessoresPorTodosOsCursos();
                        break;
                }
        }while(opcao!=7);
    }
    
    public void menuINFcursos(Sistema sistema){
        int opcao;
        do{
                String[] opcoes = {
                  "Adicionar Curso",
                  "Apagar Curso",
                  "Alterar Informações do Curso",
                  "Tornar Diretor de Curso",
                  "Eliminar Cargo de Diretor de Curso",
                  "Listar Cursos",
                  "Voltar",};
                consola.escrever("Introduza a opção pretendida:");
                
                opcao = consola.lerInteiros(opcoes);
                switch(opcao){
                    case 1:
                        criarCurso(sistema);
                    break;
                    
                    case 2:
                        String RMVcurso = consola.lerString("Digite o nome do Curso a ser apagado do Sistema:");
                        sistema.removerCurso(RMVcurso);
                    break;
                    
                    case 3:
                        String ALTcurso = consola.lerString("Digite o nome do Curso a ser alterado:");
                        sistema.alterarINFcurso(ALTcurso);
                    break;
                    
                    case 4:
                        String nomeProf = consola.lerString("Digite o nome do Professor que deseja tornar Diretor de Curso:");
                        String nomeCurso = consola.lerString("Digite o nome do Curso:");
                        sistema.tornarDiretorCurso(nomeProf, nomeCurso);
                    break;
                    
                    case 5:
                        String nome = consola.lerString("Digite o nome do Curso que deseja tirar o seu diretor:");
                        sistema.tirarDiretorCurso(nome);
                    break;
                    
                    case 6:
                        sistema.ListarCurso();
                    break;
                }
        }while(opcao!=7);
    }
    
    public void menuINFuc(Sistema sistema){
        int opcao;
        do{
                String[] opcoes = {
                  "Adicionar Unidade Curricular",
                  "Apagar Unidade Curricular",
                  "Alterar Informações da Unidade Curricular",
                  "Tornar Regente UC",
                  "Eliminar Cargo de Regente",
                  "Listar Unidade Curriculares",
                  "Voltar",};
                consola.escrever("Introduza a opção pretendida:");
                
                opcao = consola.lerInteiros(opcoes);
                switch(opcao){
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
                        ArrayList novaEquipaDocente = new ArrayList();
                        sistema.alterarINFucs(uc,novaDesignacao,novaEquipaDocente);
                    break;
                    
                    case 4:
                        String nome = consola.lerString("Qual o nome do professor que deseja tornar Regente:");
                        String uc1 = consola.lerString("Qual a Unidade Curricular: ");
                        sistema.tornarRegente(nome,uc1);
                    break;
                    
                    case 5:
                        String uc2 = consola.lerString("Qual a Unidade Curricular: ");
                        sistema.tirarRegente(uc2);
                    break;
                    
                    case 6:
                        sistema.ListarUCs();
                    break;
                }
        }while(opcao!=7);
    }
    
    public void menuProfessores(Sistema sistema, Professor professor) {

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
                criarSumario(sistema, professor);
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

    public void menuRegente(Sistema sistema) {

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
                criarAluno(sistema);
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

    public void menuDiretorCurso(Sistema sistema) {

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
    public void criarCurso(Sistema sistema) {
        int count=0;
        String designacaoCurso = consola.lerString("Designação:");
        String diretorCurso = "";
        while (count != 1) {
            diretorCurso = consola.lerString("Número Mecanográfico do Diretor de curso:");
            if(sistema.verificarExistenciadeNumeroMecanog(diretorCurso)){
                count = count + 1;
            } else {
                consola.escreverErro("\nEste Numero Mecanografico não existe, logo é impossivel ser atribuido um Diretor.");
            }
            
        }

        Curso curso = new Curso(designacaoCurso, diretorCurso);
        sistema.addCurso(curso);
    }

    public void criarUc(Sistema sistema) {
        int count=0, count2=0;
        String designacaoUC = consola.lerString("Designação:");
        String regenteUC = "";
        while (count != 1) {
            regenteUC = consola.lerString("Número Mecanográfico do Regente da UC:");
            if(sistema.verificarExistenciadeNumeroMecanog(regenteUC)){
                count = count + 1;
            } else {
                consola.escreverErro("\nEste Numero Mecanografico não existe, logo é impossivel ser atribuido um Diretor.");
            }
            
        }   
        String designacaoCurso = consola.lerString("Designação do Curso a ser atribuido esta UC:");
        Curso curso = sistema.verificarCurso(designacaoCurso);
        if(curso !=null){
            UC uc = new UC(designacaoUC, regenteUC);
            curso.adicionarUCs(uc);
        }else{
            consola.escreverErro("Curso não existe.");
        }   
}

    
    
    public void criarProfessor(Sistema sistema) {
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
    
    

    public void criarSumario(Sistema sistema, Professor professor){

        String titulo = consola.lerString("Titulo:");
        String tipo = consola.lerString("Tipo de Sumario");
        String uc = consola.lerString("Uc:");
        String textoSumario = consola.lerString("Sumario:");
        LocalDateTime data_hora = consola.lerDataHora("Data e Hora:");
        //ArrayList<Aluno> presencas =  new ArrayList<>();

        Sumario sumario = new Sumario(titulo, tipo, uc, textoSumario, data_hora/*,presencas*/);
        professor.addSumario(sumario);
    }

    public void criarAluno(Sistema sistema) {
        String nomeAluno = consola.lerString("Nome do Aluno: ");
        String nMecanoAluno = consola.lerString("Numero Mecanografico: ");
        String curso = consola.lerString("Curso: ");

        Aluno aluno = new Aluno(nomeAluno, nMecanoAluno, curso);
        
    }

    public void alterarInformacoesProfessor(Professor a, Sistema sistema) {
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
