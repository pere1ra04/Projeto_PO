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
public class Sistema {
    private ArrayList<Curso> listaCursos= new ArrayList<>();
    private ArrayList<Diretor> listaDiretores= new ArrayList<>();
    private ArrayList<Professor> listaProfessores= new ArrayList<>();
    private ArrayList<Regente> listaRegentes= new ArrayList<>();

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public ArrayList<Diretor> getListaDiretores() {
        return listaDiretores;
    }

    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public ArrayList<Regente> getListaRegentes() {
        return listaRegentes;
    }
    
   
    
    
}
