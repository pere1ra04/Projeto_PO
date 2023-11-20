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
public class UC {
    private String designacaoUC;
    private String regenteUC;
    private ArrayList<Professor> equipaDocente;

    public UC(String designacaoUC, String regenteUC, ArrayList<Professor> equipaDocente) {
        this.designacaoUC = designacaoUC;
        this.regenteUC = regenteUC;
        this.equipaDocente = equipaDocente;
    }

    public String getDesignacaoUC() {
        return designacaoUC;
    }

    public void setDesignacaoUC(String designacaoUC) {
        this.designacaoUC = designacaoUC;
    }

    public String getRegenteUC() {
        return regenteUC;
    }

    public void setRegenteUC(String regenteUC) {
        this.regenteUC = regenteUC;
    }

    public ArrayList<Professor> getEquipaDocente() {
        return equipaDocente;
    }

    public void setEquipaDocente(ArrayList<Professor> equipaDocente) {
        this.equipaDocente = equipaDocente;
    }
    
    
}
