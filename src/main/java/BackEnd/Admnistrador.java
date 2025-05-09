/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author user
 */
public class Admnistrador {

    private String nomeAdm;
    private String codigoAdm;

    public Admnistrador(String nomeAdm, String codigoAdm) {
        setNomeAdm(nomeAdm);
        setCodigoAdm(codigoAdm);
    }

    public String getNomeAdm() {
        return nomeAdm;
    }

    public void setNomeAdm(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }

    public String getCodigoAdm() {
        return codigoAdm;
    }

    public void setCodigoAdm(String codigoAdm) {
        this.codigoAdm = codigoAdm;
    }

    public boolean verificarAdmnistrador(String nomeAdm, String codigoAdm) {
        return ((this.getNomeAdm().equals(nomeAdm)) && (this.getCodigoAdm().equals(codigoAdm)));
    }
}
