package br.com.meli.obterdiploma.dao;

import br.com.meli.obterdiploma.dto.AlunoDTO;
import br.com.meli.obterdiploma.entity.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunoDAO {

    private static List<Aluno> listaDeAlunos = new ArrayList<>();

    public static List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public static void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        AlunoDAO.listaDeAlunos = listaDeAlunos;
    }

    public Long addAluno(Aluno aluno){
        listaDeAlunos.add(aluno);
        return aluno.getId();
    }

    public Aluno getAluno(Long id) {
        Optional<Aluno> alunoOptional = listaDeAlunos.stream().
                filter(a -> a.getId().equals(id)).findFirst();

        if (alunoOptional.isEmpty()){
            throw new IllegalStateException("Aluno não encontrado.");
        }
        return alunoOptional.get();
    }

}
