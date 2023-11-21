/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.awt.Font;

/**
 *
 * @author user
 */
public class Sistema {
    //Listas para o front end ler
    
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
