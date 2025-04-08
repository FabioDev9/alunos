package com.fabio.alunos.controller;

import com.fabio.alunos.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final List<Aluno> listaDeAlunos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong();

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        aluno.setId(contadorId.incrementAndGet());
        listaDeAlunos.add(aluno);
        return aluno;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return listaDeAlunos;
    }

    @DeleteMapping
    public void limparAlunos() {
        listaDeAlunos.clear();
    }
}
