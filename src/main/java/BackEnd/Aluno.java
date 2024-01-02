/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Aluno implements Serializable {

    private String nomeAluno;
    private String nMecanoAluno;
    private String curso;

    public Aluno(String nomeAluno, String nmecanoAluno, String curso) {
        setNomeAluno(nomeAluno);
        setNMecanoAluno(nmecanoAluno);
        setCurso(curso);
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

    @Override
    public String toString() {
        return "Aluno{" + "nomeAluno=" + nomeAluno + ", nMecanoAluno=" + nMecanoAluno + ", curso=" + curso + '}';
    }
}
