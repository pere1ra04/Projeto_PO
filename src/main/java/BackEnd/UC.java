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
    private Professor regenteUC;
    private ArrayList<Professor> equipaDocente= new ArrayList<>();

    public UC(String designacaoUC, Professor regenteUC, ArrayList<Professor> equipaDocente) {
        setDesignacaoUC(designacaoUC);
        setRegenteUC(regenteUC);
        setEquipaDocente(equipaDocente);
    }

    public String getDesignacaoUC() {
        return designacaoUC;
    }

    public void setDesignacaoUC(String designacaoUC) {
        this.designacaoUC = designacaoUC;
    }

    public Professor getRegenteUC() {
        return regenteUC;
    }

    public void setRegenteUC(Professor regenteUC) {
        this.regenteUC = regenteUC;
    }

    public ArrayList<Professor> getEquipaDocente() {
        return equipaDocente;
    }

    public void setEquipaDocente(ArrayList<Professor> equipaDocente) {
        this.equipaDocente = equipaDocente;
    }

   
    
}
