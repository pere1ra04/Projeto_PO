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
    private ArrayList<Professor> equipaDocente= new ArrayList<>();
    

    public UC(String designacaoUC, String regenteUC, ArrayList<Professor> equipaDocente) {
        setDesignacaoUC(designacaoUC);
        setRegenteUC(regenteUC);
        setEquipaDocente(equipaDocente);
    }
    
    public UC(String designacaoUC, String regenteUC) {
        setDesignacaoUC(designacaoUC);
        setRegenteUC(regenteUC);
    }
    
    public void adicionarProfessoruc(Professor a){
        equipaDocente.add(a);
    }
    public void removerProfessoruc (Professor a){
        equipaDocente.remove(a);
        
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
    
    
    @Override
    public String toString() {
        return "UC{" + "designacaoUC=" + designacaoUC + ", regenteUC=" + regenteUC + '}';
    }

}
