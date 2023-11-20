/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author user
 */
public class Aluno {
    private String nomeAluno;
    private String nMecanoAluno; 
    private String curso;

    public Aluno(String nomeAluno, String nmecanoAluno, String curso) {
        this.nomeAluno = nomeAluno;
        this.nMecanoAluno = nmecanoAluno;
        this.curso = curso;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNMecanoAluno() {
        return nMecanoAluno;
    }

    public void setNMecanoAluno(String nmecanoAluno) {
        this.nMecanoAluno = nmecanoAluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
