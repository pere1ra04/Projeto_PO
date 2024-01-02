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
public class Sistema implements Serializable {

    private ArrayList<Curso> listaCursos = new ArrayList<>();
    private ArrayList<Professor> listaProfessores = new ArrayList<>();

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public Aluno verificarAlunoCurso(String codigo, String curso) {
        for (Curso c : listaCursos) {
            if (c.getDesignacaoCurso().equals(curso)) {
                for (Aluno a : c.getListaAlunos()) {
                    if (a.getNMecanoAluno().equals(codigo)) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    public void removerAlunoCurso(Aluno a) {
        for (Curso b : listaCursos) {
            for (Aluno c : b.getListaAlunos()) {
                if (c.getNMecanoAluno().equals(a)) {
                    b.getListaAlunos().remove(a);
                }
            }
        }

    }

    public boolean verificarUC(String uc) {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarDiretor(Professor a) {
        for (Curso b : listaCursos) {
            if (b.getDiretorCurso().equals(a.getNMecanoProfessor())) {
                return true;
            }
        }
        return false;
    }

    public Curso verificarCurso(String curso) {
        int count = 0;
        for (Curso a : listaCursos) {
            if (a.getDesignacaoCurso().equals(curso)) {
                count = count + 1;
                return a;
            }
        }
        if (count != 0) {
            System.err.print("Curso não existe");
        }
        return null;
    }

    public boolean verificarDiretorCurso(Professor a, Curso b) {
        if (b.getDiretorCurso().equals(a.getNMecanoProfessor())) {
            return true;
        }
        return false;
    }

    public boolean verificarRegente(Professor a) {
        for (Curso b : listaCursos) {
            for (UC c : b.getListaUCs()) {
                if (c.getRegenteUC().equals(a.getNMecanoProfessor())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarRegenteUC(Professor a, UC b) {
        if (b.getRegenteUC().equals(a.getNMecanoProfessor())) {
            return true;
        }
        return false;
    }

    public Professor verificarLogin(String nome, String numeromecanog) {
        int count = 0;
        for (Professor a : listaProfessores) {
            if (a.getNomeProfessor().equals(nome) && a.getNMecanoProfessor().equals(numeromecanog)) {
                count = 1 + count;
                return a;
            }
        }
        if (count == 0) {
            System.err.print("Professor não registrado no sistema");
        }
        return null;
    }

    public void addProfessor(Professor a) {
        listaProfessores.add(a);
    }

    public void removerProfessor(String nome, Sistema sistema) {
        for (Professor a : listaProfessores) {
            if (a.getNomeProfessor().equals(nome)) {
                listaProfessores.remove(a);
            }
        }
    }

    public void addCurso(Curso a) {
        listaCursos.add(a);
    }

    public void ListarCurso() {
        for (Curso a : listaCursos) {
            System.out.printf("-> %s\n", a.getDesignacaoCurso());
        }
    }

    public void removerCurso(String designacao) {
        for (Curso a : listaCursos) {
            if (a.getDesignacaoCurso().equals(designacao)) {
                listaCursos.remove(a);
            }
        }
    }

    public boolean AtribuirUC(String stor, String uc) {
        int count = 0;
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    for (Professor c : b.getEquipaDocente()) {
                        if (c.getNMecanoProfessor().equals(stor)) {
                            count = count + 1;
                            return false;
                        }
                    }
                }
            }
        }
        if (count == 0) {
            for (Curso a : listaCursos) {
                for (UC b : a.getListaUCs()) {
                    if (b.getDesignacaoUC().equals(uc)) {
                        for (Professor c : listaProfessores) {
                            if (c.getNMecanoProfessor().equals(stor)) {
                                b.adicionarProfessoruc(c);
                                c.addUC(b);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void ListarUCs() {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                System.out.printf("-> %s\n", b.getDesignacaoUC());
            }
        }
    }

    public UC EncontrarUC(String designacao) {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(designacao)) {
                    return b;
                }
            }
        }
        return null;
    }

    public void ListarAlunos() {
        for (Curso a : listaCursos) {
            for (Aluno b : a.getListaAlunos()) {
                System.out.printf("-> %s\n", b.getNomeAluno());
            }
        }
    }

    public void consultarAssiduidade(String codigo, UC uc) {
        for (Professor p : listaProfessores) {
            for (Sumario s : p.getListaSumarios()) {
                if (s.getUC().equals(uc.getDesignacaoUC())) {
                    for (Aluno a : s.getPresencas()) {
                        if (a.getNMecanoAluno().equals(codigo)) {
                            System.out.printf("\t\t->%s\n", s.getUC());
                            System.out.printf("\tAula: %s\n", s.getTipo());
                            System.out.printf("Titulo: %s\n", s.getTitulo());
                        }
                    }
                }
            }

        }
    }

    public void NumeroAlunosCurso(Curso curso) {
        int totalAlunos = 0;
        for (Aluno b : curso.getListaAlunos()) {
            totalAlunos = totalAlunos + 1;
        }
        System.out.printf("O numero de Alunos neste curso é: %d", totalAlunos);
    }

    public void listarNumeroProfessores(Curso curso) {
        int totalProf = 0;
        System.out.printf("\t-> %s\n", curso.getDesignacaoCurso());
        for (UC b : curso.getListaUCs()) {
            for (Professor c : b.getEquipaDocente()) {
                totalProf = totalProf + 1;
            }
        }
        System.out.printf("O numero de Professores neste curso é: %d", totalProf);
    }

    public void ListarProfessores() {
        for (Professor a : listaProfessores) {
            System.out.printf("Nome: %s\n", a.getNomeProfessor());
            System.out.printf("Numero Mecanografico: %s\n", a.getNMecanoProfessor());
            System.out.printf("Data de inicio: %s\n", a.getDataInicio());
            System.out.print("\n");
        }
    }

    public void ListarProfessoresPorTodosOsCursos() {
        for (Curso a : listaCursos) {
            System.out.printf("\t-> %s\n", a.getDesignacaoCurso());
            for (UC b : a.getListaUCs()) {
                System.out.printf("\t-> %s\n", b.getDesignacaoUC());
                for (Professor c : b.getEquipaDocente()) {
                    System.out.printf("Nome: %s\n", c.getNomeProfessor());
                    System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoProfessor());
                    System.out.print("\n");
                }
            }
        }
    }

    public boolean verificarAluno(String codigo) {
        for (Curso c : listaCursos) {
            for (Aluno a : c.getListaAlunos()) {
                if (a.getNMecanoAluno().equals(codigo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Aluno verificarAlunoObjeto(String codigo) {
        for (Curso c : listaCursos) {
            for (Aluno a : c.getListaAlunos()) {
                if (a.getNMecanoAluno().equals(codigo)) {
                    return a;
                }
            }
        }
        return null;
    }

    public void ListarSumariosPorUCEPorTipo(Professor p) {
        String tipo1 = "T", tipo2 = "PL", tipo3 = "TP";
        for (UC a : p.getListaUCs()) {
            for (Sumario b : p.getListaSumarios()) {
                if (a.getDesignacaoUC().equals(b.getUC())) {
                    System.out.printf("->%s\n", a.getDesignacaoUC());
                    if (tipo1.equals(b.getTipo())) {
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos:\n ");
                        for (Aluno c : b.getPresencas()) {
                            System.out.printf("Nome: %s\n", c.getNomeAluno());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoAluno());
                            System.out.printf("Curso: %s\n", c.getCurso());
                            System.out.printf("\n");
                        }
                    }
                }
            }
        }
        for (UC a : p.getListaUCs()) {
            for (Sumario b : p.getListaSumarios()) {
                if (a.getDesignacaoUC().equals(b.getUC())) {
                    System.out.printf("\t\t->%s\n", a.getDesignacaoUC());
                    if (tipo2.equals(b.getTipo())) {
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos: ");
                        for (Aluno c : b.getPresencas()) {
                            System.out.printf("Nome: %s\n", c.getNomeAluno());
                            System.out.printf("Numero Mecanografico: %s\n", c.getNMecanoAluno());
                            System.out.printf("Curso: %s\n", c.getCurso());
                            System.out.printf("\n");
                        }
                    }
                }
            }
        }
        for (UC a : p.getListaUCs()) {
            for (Sumario b : p.getListaSumarios()) {
                if (a.getDesignacaoUC().equals(b.getUC())) {
                    System.out.printf("\t\t->%s\n", a.getDesignacaoUC());
                    if (tipo3.equals(b.getTipo())) {
                        System.out.printf("\tAula: %s\n", b.getTipo());
                        System.out.printf("Titulo: %s\n", b.getTitulo());
                        System.out.printf("Sumario: %s\n", b.getSumario());
                        System.out.printf("Lista de Alunos: ");
                        for (Aluno c : b.getPresencas()) {
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

    public boolean verificarExistenciadeNumeroMecanog(String mecanog) {
        for (Professor a : listaProfessores) {
            if (a.getNMecanoProfessor().equals(mecanog)) {
                return true;
            }
        }

        // Todas as UCs existem na lista, retornar true
        return false;
    }

    public void removerUcs(String uc) {
        boolean ucEncontrada = false;
        for (Professor a : listaProfessores) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    a.removerUC(uc);
                    ucEncontrada = true;
                    break; //para se encontrar
                }
            }
        }
        if (!ucEncontrada) {
            System.out.println("Unidade Curricular não encontrada");
        }
    }

    public void alterarINFucs(String uc, String novaDesignacao) {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    b.setDesignacaoUC(novaDesignacao);
                }
            }
        }
    }

    public Professor verificarLogin2(String numeromecanog) {
        int count = 0;
        for (Professor a : listaProfessores) {
            if (a.getNMecanoProfessor().equals(numeromecanog)) {
                count = 1 + count;
                return a;
            }
        }
        if (count == 0) {
            System.err.print("Professor não registrado no sistema");
        }
        return null;
    }

    public void retirarEquipaDocente(String removido, String uc) {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    b.removerProfessoruc(verificarLogin2(removido));
                }
            }
        }
    }

    public void mudarDesignaçãoCurso(String atual, String novo) {
        for (Curso c : listaCursos) {
            if (c.getDesignacaoCurso().equals(atual)) {
                c.setDesignacaoCurso(novo);
            }
        }
    }

    public void tornarRegente(String codigo, String uc, Sistema sistema) {
        for (Curso a : listaCursos) {
            for (UC b : a.getListaUCs()) {
                if (uc.equals(b.getDesignacaoUC())) {
                    if (b.getRegenteUC() == null) {
                        // Assumindo que setRegenteUC() espera um objeto Professor como argumento
                        b.setRegenteUC(codigo);

                        AtribuirUC(codigo, uc);
                        //Certifique-se de que AtribuirUC(codigo, uc) faz sentido aqui no seu sistema
                    } else {
                        System.out.println("Esta Unidade Curricular já tem Regente");
                    }
                }
            }
        }
    }

    public void tirarRegente(String uc) {
        boolean ucEncontrada = false;
        for (Professor a : listaProfessores) {
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    b.setRegenteUC(null);
                    ucEncontrada = true;
                    break; //para se encontrar
                }
            }
        }
        if (!ucEncontrada) {
            System.out.println("Unidade Curricular não encontrada");
        }
    }

    public void alterarINFcurso(String curso) {

    }

    public void tornarDiretorCurso(String codigo, String curso) {
        boolean professorEncontrado = false;

        for (Professor a : listaProfessores) {
            if (a.getNMecanoProfessor().equals(codigo)) {
                professorEncontrado = true;

                boolean cursoEncontrado = false;

                // Verificar se o curso existe e se já tem diretor
                for (Curso c : listaCursos) {
                    if (c.getDesignacaoCurso().equals(curso)) {
                        cursoEncontrado = true;

                        if (c.getDiretorCurso() == null) {
                            c.setDiretorCurso(codigo);
                        } else {
                            System.out.println("Este Curso já tem Diretor");
                        }
                    }
                }

                if (!cursoEncontrado) {
                    System.out.println("Curso não encontrado");
                }
                break;  // Se encontrou o professor, não precisa continuar procurando.
            }
        }
        if (!professorEncontrado) {
            System.out.println("Professor não encontrado");
        }
    }

    public void tirarDiretorCurso(String curso) {
        boolean cursoEncontrado = false;
        for (Curso c : listaCursos) {
            if (c.getDesignacaoCurso().equals(curso)) {
                cursoEncontrado = true;
                if (c.getDiretorCurso() != null) {
                    System.out.println("Diretor removido do curso: " + c.getDesignacaoCurso());
                    c.setDiretorCurso(null);
                } else {
                    System.out.println("Este Curso não tem Diretor para remover");
                }
                break;
            }
        }

        if (!cursoEncontrado) {
            System.out.println("Curso não encontrado");
        }
    }

    public UC verificarCargoRegente(Professor professor) {
        for (UC uc : professor.getListaUCs()) {
            if (uc.getRegenteUC().equals(professor.getNMecanoProfessor())) {
                return uc;
            }
        }
        return null;
    }

    public Curso verificarCargoDiretor(Professor professor) {
        for (Curso curso : listaCursos) {
            if (curso.getDiretorCurso().equals(professor.getNMecanoProfessor())) {
                return curso;
            }
        }
        return null;
    }

}
