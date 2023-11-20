/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Regente extends Professor {
    public Regente(String nomeRegente, String codigoRegente, String dataDeInicio, ArrayList<UC> listaUC) {
        super(nomeRegente,codigoRegente,dataDeInicio,listaUC);
    }
}
