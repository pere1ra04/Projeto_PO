/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.time.LocalDateTime;

/**
 *
 * @author Afonso
 */
public class Sumario {
    private String titulo;
    private String tipo;
    private String sumario;
    private LocalDateTime data;
    private int presencas;
    
    public Sumario(String titulo, String tipo, String sumario, LocalDateTime data, int presencas){
        this.titulo=titulo;
        this.tipo=tipo;
        this.sumario=sumario;
        setData(data);
        this.presencas=presencas;
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
    
    public String getSumario() {
        return sumario;
    }
    public void setSumario(String novosumario){
        sumario=novosumario;
    }
    
    public int getPresencas() {
        return presencas;
    }
    public void setPresencas(int novaspresencas) {
        presencas=novaspresencas;
    }
    
    
    public LocalDateTime getData (){
        return LocalDateTime.now();
    }
    public void setData(LocalDateTime novaData){
        data=novaData; 
    }
    

}
