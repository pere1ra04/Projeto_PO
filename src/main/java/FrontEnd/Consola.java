/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import BackEnd.Sistema;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Consola {
    private final Scanner scanner = new Scanner(System.in);
    
  
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
    
    
    public int lerInteiro(String mensagem) {
        Integer numero = null;
        String texto;

        do {
            escrever(mensagem);
            texto = scanner.nextLine();

            try {
                numero = Integer.valueOf(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " nÃ£o Ã© um nÃºmero inteiro vÃ¡lido.");
            }

        } while (numero == null);

        return numero;
    }
    
    
    public int lerInteiros(String[] opcoes) {
        Integer numero = null;
        String texto = "";

        do {
            escrever("Selecione uma das seguintes opcões:");
            for (int i = 0; i < opcoes.length; i++) {
                escrever((i + 1) + " - " + opcoes[i]);
            }

            try {
                texto = scanner.nextLine();
                numero = Integer.valueOf(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " não é uma opção válida");
            }

            if (numero == null || numero <= 0 || numero > opcoes.length) {
                numero = null;
                escreverErro(texto + " não é uma opção válida");
            }

        } while (numero == null);

        return numero;
    }
    
        public LocalDateTime lerDataHora(String mensagem) {
        LocalDateTime data = null;
        String texto;

        do {
            escrever(mensagem + " (dd/mm/aaaa hh:mm)");
            texto = scanner.nextLine();

            try {
                data = LocalDateTime.parse(texto, 
                        DateTimeFormatter.ofPattern("d/M/yyyy HH:mm"));
            } catch (DateTimeParseException e) {
                escreverErro(texto + " nÃ£o Ã© um data no formato dd/mm/aaaa hh:mm");
            }

        } while (data == null);

        return data;
    }
    
    public static void converterParaAscii(String texto, int tamanhoFonte){
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

    public boolean SoTemLetra(String palavra) {
        for (char a : palavra.toCharArray()) {
            if (!((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z'))) {
                return false;
            }
        }
    
        return true;
    }

    public boolean SoTemNumero(String numero) {
        for (char n : numero.toCharArray()) {
            if (!(n >= '0' && n <= '9')) {
                return false;
            }
        }
    
        return true;
    }
}
