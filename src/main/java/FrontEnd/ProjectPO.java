/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package FrontEnd;


import BackEnd.ListaUCs;
import BackEnd.Sistema;
import BackEnd.Professor;
import java.util.Scanner;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class ProjectPO{
   
    private final Consola consola = new Consola();
    private final Sistema sistema = new Sistema();
    
     public static void main(String[] args) throws Exception{
     ProjectPO programa = new ProjectPO();
     programa.login();
     }

    public void login(){
        
            consola.converterParaAscii("Login:",100);
            
            String numero = consola.lerString("Numero:");
            //verificaçoes
            String password = consola.lerString("Password");
            //verificaçoes
            exibirMenuPrincipal();
        }
    
        public void exibirMenuPrincipal() {
            while (true) {
                consola.converterParaAscii("Gestao de Departamento",100);
                consola.escrever("\n----- Menu Principal -----");
                
                int opcao;
                String[] opcoes = {
                    "Entrar como Administrador",
                    "Entrar como Professor",
                    "Entrar como Regente de UC",
                    "Entrar como Diretor de Curso",
                    "Sair",
                };
                

            consola.escrever("Escolha uma opção: ");
            opcao = consola.lerInteiro(opcoes);
            switch (opcao) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuProfessores();
                    break;
                case 3:
                    menuRegente();
                    break;
                case 4:
                    menuDiretorCurso();
                    break;
                case 5:
                    consola.escrever("Saindo do programa. Até mais!");
                    System.exit(0);
                    break;
                default:
                    consola.escreverErro("Opção inválida. Tente novamente.");
            }
            }
    }
    
    public void menuAdministrador(){
    
    consola.converterParaAscii("Menu Admistrador",20);
    int opcao;
    String[] opcoes = {
        "Informações de Professores",
        "Informações de Cursos",
        "Informações de UCS",
        "Sair",
    };
    
    
    consola.escrever ("Inttroduza a opção pretendida");
    
    opcao = consola.lerInteiro(opcoes);
    switch(opcao){
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
        
        default:
        consola.escreverErro("Opção inválida. Tente novamente.");
    }
    }
    
    public void menuProfessores(){
    
    consola.converterParaAscii("Menu Professor",20);
    int opcao;
    String[] opcoes = {
        "Criar Sumario",
        "Consultar Sumarios",
        "Consultar Serviço Docente",
        "Sair",
    };
    
    
    consola.escrever ("Inttroduza a opção pretendida");
    
    opcao = consola.lerInteiro(opcoes);
    switch(opcao){
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
        
        default:
        consola.escreverErro("Opção inválida. Tente novamente.");
    }
    }
    
    
    public void menuRegente(){
    
    consola.converterParaAscii("Menu Regente da UC: ",20); //ADICIONAR O NOME DA UC POR REFERNCIA
    int opcao;
    String[] opcoes = {
        "Adicionar Aluno",
        "Remover Aluno",
        "Consultar Assiduidade",
        "Sair",
    };
    
    
    consola.escrever ("Inttroduza a opção pretendida");
    
    opcao = consola.lerInteiro(opcoes);
    switch(opcao){
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
        
        default:
        consola.escreverErro("Opção inválida. Tente novamente.");
    }
    }
    
    public void menuDiretorCurso(){
    
    consola.converterParaAscii("Menu Diretor de Curso    : ",20); //ADICIONAR O NOME Do curso POR REFERNCIA
    int opcao;
    String[] opcoes = {
        "Alterar Designação do Curso",
        "Listar Alunos",
        "Listar Professores",
        "Sair",
    };
    
    
    consola.escrever ("Inttroduza a opção pretendida");
    
    opcao = consola.lerInteiro(opcoes);
    
    switch(opcao){
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
        
        default:
        consola.escreverErro("Opção inválida. Tente novamente.");
    }
    }   
    
    
    
    //Funções CRIAR
    
    public void criarProfessor(){
        String nomeProfessor = consola.lerString("Nome:");
        String nMecanoProfessor = consola.lerString("Número Mecanográfico:");
        String dataInicio = consola.lerString("Data de inicio de Funções:");
       
        String ucsInput= consola.lerString("Digite as unidades curriculares (separadas por vírgula):");
        ListaUCs listaUC = new ListaUCs(Arrays.asList(ucsInput.split(",")));
        
        Professor professor = new Professor(nomeProfessor, nMecanoProfessor, dataInicio, listaUC);
    }
    
    public void criarSumario(){
        Scanner scanner = new Scanner(System.in);

        String Titulo = consola.lerString("Titulo:");
        String tipo = consola.lerString("Tipo de Sumario");
        String sumario = consola.lerString("Sumario:");
        LocalDateTime data;
        consola.escrever("Numero de Presenças:");
        int presencas = scanner.nextInt();
    }
    
    public void adicionarRegente(){
            
    }
    
    public void adicionarDiretordeCurso(){
        
    }
    
   
}

