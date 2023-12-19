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
    private ArrayList<Sumario> listaSumarios= new ArrayList<>();

    public UC(String designacaoUC, Professor regenteUC, ArrayList<Professor> equipaDocente, ArrayList<Sumario> listaSumarios) {
        setDesignacaoUC(designacaoUC);
        setRegenteUC(regenteUC);
        setEquipaDocente(equipaDocente);
        setListaSumarios(listaSumarios);
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

    public ArrayList<Sumario> getListaSumarios() {
        return listaSumarios;
    }

    public void setListaSumarios(ArrayList<Sumario> listaSumarios) {
        this.listaSumarios = listaSumarios;
    }

    @Override
    public String toString() {
        return "UC{" + "designacaoUC=" + designacaoUC + ", regenteUC=" + regenteUC + '}';
    }

}
