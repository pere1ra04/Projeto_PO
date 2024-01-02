/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sumario implements Serializable {
    private String titulo;
    private String tipo;
    private String UC;
    private String sumario;
    private LocalDateTime data_hora;
    private ArrayList<Aluno> Presencas = new ArrayList<>();
    
    public Sumario(String titulo, String tipo, String UC, String textoSumario, LocalDateTime data_hora,ArrayList<Aluno> presencas){
        setTitulo(titulo);
        setTipo(tipo);
        setUC(UC);
        setSumario(textoSumario);
        setData_hora(data_hora);
        setPresencas(presencas);
    }
    
    public Sumario(String titulo, String tipo, String UC, String textoSumario, LocalDateTime data_hora){
        setTitulo(titulo);
        setTipo(tipo);
        setUC(UC);
        setSumario(textoSumario);
        setData_hora(data_hora);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String novotitulo){
        titulo=novotitulo;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String novotipo){
        tipo=novotipo;
    }

    public String getUC() {
        return UC;
    }

    public void setUC(String UC) {
        this.UC = UC;
    }
    
    public String getSumario() {
        return sumario;
    }
    public void setSumario(String novosumario){
        sumario=novosumario;
    }

    public ArrayList<Aluno> getPresencas() {
        return Presencas;
    }

    public void setPresencas(ArrayList<Aluno> Presencas) {
        this.Presencas = Presencas;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
    
    public boolean verificarPresenca(Aluno nome){
        for(Aluno b : Presencas){
            if(b.equals(nome)){
                return true;
            }
        }
        return false;
    }
    
   

    @Override
    public String toString() {
        return "Sumario{" + "titulo=" + titulo + ", tipo=" + tipo + ", sumario=" + sumario + ", data_hora=" + data_hora + '}';
    }
    
}
