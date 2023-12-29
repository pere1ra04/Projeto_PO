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
    
    public void addProfessor(Professor a){
        listaProfessores.add(a);
    }
    
    public void removerProfessor(String nome){
        for(Professor a : listaProfessores){
            if(a.getNomeProfessor().equals(nome)){
                listaProfessores.remove(a);
            }
        }
    }
    
    public void addCurso(Curso a){
        listaCursos.add(a);
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
    
    public UC EncontrarUC(String designacao){
        for (Curso a: listaCursos){
            for(UC b : a.getListaUCs()){
                if(b.getDesignacaoUC().equals(designacao)){
                    return b;
                }
            }
        }
        return null;
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
    public void ListarProfessoresPorCurso(String Curso){
            System.out.printf("\t-> %s\n", Curso);
            for(Curso a : listaCursos){
                if(a.getDesignacaoCurso().equals(Curso)){
                    for(UC b : a.getListaUCs()){
                        for(Professor c : b.getEquipaDocente()){
                            System.out.printf("Nome: %s\n", c.getNomeProfessor());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoProfessor());
                            System.out.print("\n");
                }
            }
        }
    }
}
    public void ListarProfessores(){
        for(Professor a: listaProfessores){
                    System.out.printf("Nome: %s\n", a.getNomeProfessor());
                    System.out.printf("Numero Mecanografico: %s\n", a.getNMecanoProfessor());
                    System.out.printf("Data de inicio: %s\n", a.getDataInicio());
                    System.out.print("\n");
                }
            }
        
    
    
    public void ListarProfessoresPorTodosOsCursos(){
        for(Curso a: listaCursos){
            System.out.printf("\t-> %s\n", a.getDesignacaoCurso());
            for(UC b : a.getListaUCs()){
                System.out.printf("\t-> %s\n", b.getDesignacaoUC());
                for(Professor c : b.getEquipaDocente()){
                    System.out.printf("Nome: %s\n", c.getNomeProfessor());
                    System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoProfessor());
                    System.out.print("\n");
                }
            }
        }
    }
    
    public void ListarSumariosPorUCEPorTipo(Professor p){
        String tipo1="T", tipo2="PL", tipo3="TP";
        for(UC a : p.getListaUCs()){
            for(Sumario b : p.getListaSumarios()){
                if(a.getDesignacaoUC().equals(b.getUC())){
                    System.out.printf("\t\t->%s\n", a.getDesignacaoUC());
                    if(tipo1.equals(b.getTipo())){
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos: ");
                        for(Aluno c : b.getPresencas()){
                            System.out.printf("Nome: %s\n", c.getNomeAluno());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoAluno());
                            System.out.printf("Curso: %s\n", c.getCurso());
                            System.out.printf("\n");
                        }
                    }
                }  
        }
    }
        for(UC a : p.getListaUCs()){
            for(Sumario b : p.getListaSumarios()){
                if(a.getDesignacaoUC().equals(b.getUC())){
                    System.out.printf("\t\t->%s\n", a.getDesignacaoUC());
                    if(tipo2.equals(b.getTipo())){
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos: ");
                        for(Aluno c : b.getPresencas()){
                            System.out.printf("Nome: %s\n", c.getNomeAluno());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoAluno());
                            System.out.printf("Curso: %s\n", c.getCurso());
                            System.out.printf("\n");
                        }
                    }
                }  
        }
    }
        for(UC a : p.getListaUCs()){
            for(Sumario b : p.getListaSumarios()){
                if(a.getDesignacaoUC().equals(b.getUC())){
                    System.out.printf("\t\t->%s\n", a.getDesignacaoUC());
                    if(tipo3.equals(b.getTipo())){
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos: ");
                        for(Aluno c : b.getPresencas()){
                            System.out.printf("Nome: %s\n", c.getNomeAluno());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoAluno());
                            System.out.printf("Curso: %s\n", c.getCurso());
                            System.out.printf("\n");
                        }
                    }
                }  
        }
    }
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
    
    
    
    
}
