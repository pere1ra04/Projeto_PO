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
public class ProjectPO {
    private final Consola consola = new Consola();
    private final Sistema sistema = new Sistema();
    
     public static void main(String[] args) {
        ProjectPO sistema = new ProjectPO();
        sistema.login();
    }
        public void login(){
            Scanner scanner = new Scanner(System.in);
            converterParaAscii("Login:",100);
            System.out.println("Username:");
            String nome = scanner.nextLine();
            //verificaçoes
            System.out.println("Password:");
            String password = scanner.nextLine();
            //verificaçoes
            //depois das verficaçoes chamar sistema.exibirMenuPrincipal();
        }
        public void exibirMenuPrincipal() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                converterParaAscii("Gestao de Departamento",100);
                System.out.println("\n----- Menu Principal -----");
                System.out.println("1. Entrar como Administrador");
                System.out.println("2. Entrar como Professor");
                System.out.println("3. Sair");

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
                    System.out.println("Saindo do programa. Até mais!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            }
    }
    
    public void menuAdministrador(){
    }
    
    public void menuProfessores(){
    }
    
    private static void converterParaAscii(String texto, int tamanhoFonte) {
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