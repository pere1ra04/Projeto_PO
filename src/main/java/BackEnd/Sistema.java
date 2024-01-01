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
    private ArrayList<Curso> listaCursos= new ArrayList<>();
    private ArrayList<Professor> listaProfessores= new ArrayList<>();
 
    

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
    
    public boolean verificarDiretor(Professor a){
        for(Curso b : listaCursos){
            if(b.getDiretorCurso().equals(a.getNMecanoProfessor())){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarDiretorCurso(Professor a,Curso b){
        if(b.getDiretorCurso().equals(a.getNMecanoProfessor())){
            return true;
        }
        return false;
    }
    
    public boolean verificarRegente(Professor a){
        for(Curso b : listaCursos){
            for(UC c : b.getListaUCs()){
                if(c.getRegenteUC().equals(a.getNMecanoProfessor())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verificarRegenteUC(Professor a,UC b){
        if(b.getRegenteUC().equals(a.getNMecanoProfessor())){
            return true;
        }
        return false;
    }
    
    public Professor verificarLogin(String nome, String numeromecanog){
        int count=0;
        for(Professor a : listaProfessores){
            if(a.getNomeProfessor().equals(nome) && a.getNMecanoProfessor().equals(numeromecanog)){
                count = 1 + count;
                return a;
            }
        }
        if(count==0){
            System.err.print("Professor não registrado no sistema");
        }
        return null;
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
    
    public void removerCurso(String designacao){
        for(Curso a : listaCursos){
            if(a.getDesignacaoCurso().equals(designacao)){
                listaCursos.remove(a);
            }
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
    
    
    public boolean verificarExistenciadeNumeroMecanog(String mecanog) {
        for (Professor a : listaProfessores) {
            if (a.getNMecanoProfessor().equals(mecanog)) {
                return true;
            }
        }

        // Todas as UCs existem na lista, retornar true
        return false;
    }
    public void removerUcs(String uc){
        boolean ucEncontrada = false;
            for(Professor a: listaProfessores){
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
    public void alterarINFucs(String uc, String novaDesignacao, ArrayList novaEquipaDocente){
        boolean ucEncontrada = false;
            for(Professor a: listaProfessores){
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    b.setDesignacaoUC(novaDesignacao);
                    b.setEquipaDocente(novaEquipaDocente);
                    ucEncontrada = true;
                break; //para se encontrar
                }
            }
            }
        if (!ucEncontrada) {
            System.out.println("Unidade Curricular não encontrada");
        }
    }
    
    public void tornarRegente(String nome, String uc){
       boolean professorEncontrado = false;
       boolean ucEncontrada = false;
        for (Professor a : listaProfessores) {
            if (a.getNomeProfessor().equals(nome)) {
                professorEncontrado = true;

            // Verificar se a UC existe e se já tem regente
            for (UC b : a.getListaUCs()) {
                if (b.getDesignacaoUC().equals(uc)) {
                    ucEncontrada = true;

                    if (b.getRegenteUC() == null) {
                        b.setRegenteUC(nome);
                    } else {
                        System.out.println("Esta Unidade Curricular já tem Regente");
                    }
                }
            }

            if (!ucEncontrada) {
                System.out.println("Unidade Curricular não encontrada");
            }
            break; 
            }
            if (!professorEncontrado) {
                System.out.println("Professor não encontrado");
            }
        }
    }
    
    public void tirarRegente(String uc){
        boolean ucEncontrada = false;
            for(Professor a: listaProfessores){
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
    
    
    
    
    public void alterarINFcurso(String curso){
        
    }
    
    public void tornarDiretorCurso(String nome, String curso){
        boolean professorEncontrado = false;
        
        for (Professor a : listaProfessores) {
            if (a.getNomeProfessor().equals(nome)) {
                professorEncontrado = true;

                boolean cursoEncontrado = false;

            // Verificar se o curso existe e se já tem diretor
                for (Curso c : listaCursos) {
                    if (c.getDesignacaoCurso().equals(curso)) {
                        cursoEncontrado = true;

                    if (c.getDiretorCurso() == null) {
                        c.setDiretorCurso(nome);
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
    public void tirarDiretorCurso(String curso){
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





/* Função para salvar o estado do Sistema em um arquivo
    public void carregarEstado() {
    File file = new File("Estado.txt");
    ObjectInputStream ois = null;

    try {
        ois = new ObjectInputStream(new FileInputStream(file));

        if (file.exists()) {
            listaCursos = (ArrayList<Curso>) ois.readObject();
            listaProfessores = (ArrayList<Professor>) ois.readObject();
        } else {
            salvarEstado(); // Cria um novo arquivo ao carregar se não existir
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        // Bloco finally para garantir que o ObjectInputStream seja fechado
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

    public void salvarEstado() {
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("Estado.txt"));
            out.writeObject(listaCursos);
            out.writeObject(listaProfessores);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        // Bloco finally para garantir que o ObjectInputStream seja fechado
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }*/
    
    
    
} 
