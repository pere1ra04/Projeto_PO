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
    private ArrayList<Professor> listaProfessores= new ArrayList<>();

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void ListarCurso(){
        for (Curso a: listaCursos){
            System.out.printf("-> %s\n",a.getDesignacaoCurso());
        }
    }
    
    public void ListarUCs(){
        for (Curso a: listaCursos){
            for(UC b : a.getListaUCs()){
            System.out.printf("-> %s\n",b.getDesignacaoUC());
            }
        }
    }
    
    public void ListarAlunos(){
        for (Curso a: listaCursos){
            for(Aluno b : a.getListaAlunos()){
            System.out.printf("-> %s\n",b.getNomeAluno());
            }
        }
    }
    
    public int NumeroAlunosCurso(String Curso){
        int totalAlunos = 0;
        for(Curso a : listaCursos){
            if(a.getDesignacaoCurso().equals(Curso)){
                for(Aluno b : a.getListaAlunos()){
                    totalAlunos++;
                }
            }
        }
        return totalAlunos;
    }
    
    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }
    
    public void ListarProfessors(){
        for (Professor a: listaProfessores){
            System.out.printf("-> %s\n",a.getNomeProfessor());
        }
    }
    
}
