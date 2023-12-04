/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package FrontEnd;


import BackEnd.Sistema;
import java.util.Scanner;
import java.awt.Font;

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

}
