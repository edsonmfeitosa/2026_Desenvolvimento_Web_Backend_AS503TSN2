package com.aulaspring.aulajpa.service;

import com.aulaspring.aulajpa.model.Aluno;
import com.aulaspring.aulajpa.model.Endereco;
import com.aulaspring.aulajpa.repository.AlunoRepository;
import com.aulaspring.aulajpa.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private EnderecoRepository enderecoRepository;


    public AlunoService(AlunoRepository alunoRepository,
                        EnderecoRepository enderecoRepository){
        this.alunoRepository = alunoRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public Aluno salvar(Aluno aluno){

        Endereco enderecoSalvar = aluno.getEndereco();
        Endereco enderecoCriado = this.enderecoRepository.save(enderecoSalvar);
        aluno.setEndereco(enderecoCriado);
        return this.alunoRepository.save(aluno);
    }
    public List<Aluno> todos (){
        return this.alunoRepository.findAll();
    }
    public Aluno porRA(String ra){
        return this.alunoRepository.findById(ra).orElse(null);
    }
;;}
