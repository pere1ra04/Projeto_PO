/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author user
 */
public class UC {
    private String designacaoUC;
    private Professor regenteUC;
    private ListaProfessores equipaDocente;

    public UC(String designacaoUC, Professor regenteUC, ListaProfessores equipaDocente) {
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

    public ListaProfessores getEquipaDocente() {
        return equipaDocente;
    }

    public void setEquipaDocente(ListaProfessores equipaDocente) {
        this.equipaDocente = equipaDocente;
    }
    
}
