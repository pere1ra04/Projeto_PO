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
public class ProjectPO extends Consola {
    private final Consola consola = new Consola();
    private final Sistema sistema = new Sistema();
    
     public static void main(String[] args) {
        ProjectPO sistema = new ProjectPO();
        sistema.login();
    }
}