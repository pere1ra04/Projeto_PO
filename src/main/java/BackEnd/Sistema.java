/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;
import java.io.*;


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
    
    /*public boolean verificarExistenciaUCs(ArrayList<String> ucsEscritas, ListaUCs listaUCsExistente) {
        ArrayList<String> ucsExistente = listaUCsExistente.getUCs();

        for (String ucInput : ucsEscritas) {
            if (!ucsExistente.contains(ucInput)) {
                // Se alguma UC não existir na lista, retornar false
                return false;
            }
        }

        // Todas as UCs existem na lista, retornar true
        return true;
    } */
    




// Função para salvar o estado do Sistema em um arquivo
    public void salvarEstado(String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaCursos);
            oos.writeObject(listaProfessores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Função para carregar o estado do Sistema a partir de um arquivo
    public void carregarEstado(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaCursos = (ArrayList<Curso>) ois.readObject();
            listaProfessores = (ArrayList<Professor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public void salvarAdmin(){
        
    }
    
}
