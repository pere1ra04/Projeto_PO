/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import BackEnd.Sistema;
import java.awt.Font;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Consola {
    private final Scanner scanner = new Scanner(System.in);

    public void login(){
            converterParaAscii("Login:",100);
            escrever("Username:");
            String nome = scanner.nextLine();
            //verificaçoes
            escrever("Password:");
            String password = scanner.nextLine();
            //verificaçoes
            //depois das verficaçoes chamar sistema.exibirMenuPrincipal();
        }
    
        public void exibirMenuPrincipal() {
            while (true) {
                converterParaAscii("Gestao de Departamento",100);
                escrever("\n----- Menu Principal -----");
                escrever("1. Entrar como Administrador");
                escrever("2. Entrar como Professor");
                escrever("3. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuProfessores();
                    break;
                case 3:
                    escrever("Saindo do programa. Até mais!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    escreverErro("Opção inválida. Tente novamente.");
            }
            }
    }
    
    public void menuAdministrador(){
    converterParaAscii("Menu Admistrador",20);
    escrever ("1-Informações de Professores");
    escrever ("2-Informações de Cursos");
    escrever ("3-Informações de UCS");
    escrever ("0-Sair");
    
    escrever ("Inttroduza a opção pretendida");
    int opcao = scanner.nextInt();
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
        escreverErro("Opção inválida. Tente novamente.");
    }
    }
    
    public void menuProfessores(){
        //fazer verficações para saber quais as opcoes disponivies consuante o seu cargo
    converterParaAscii("Menu Professores",20);
    escrever ("1-");
    escrever ("2-");
    escrever ("3-");
    escrever ("0-");
    
    escrever ("Inttroduza a opção pretendida");
    int opcao = scanner.nextInt();
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
        escreverErro("Opção inválida. Tente novamente.");
    }
    }
    
    
    
    public void escrever(String mensagem) {
        System.out.println(mensagem);
    }

    public void escreverErro(String mensagem) {
        System.err.println(mensagem);
    }

    public String lerString(String mensagem) {
        escrever(mensagem);
        return scanner.nextLine();
    }
    
    private static void converterParaAscii(String texto, int tamanhoFonte){
        Font fonte = new Font("Lato", Font.PLAIN, tamanhoFonte);
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);
            int valorAscii = (int) caractere;

            // Certifique-se de que o caractere é imprimível
            if (valorAscii >= 32 && valorAscii <= 126) {
                System.out.print(caractere + " ");
            } else {
                // Se não for imprimível, pule para a próxima linha
                System.out.println();
            }
        }
    }
  
}
