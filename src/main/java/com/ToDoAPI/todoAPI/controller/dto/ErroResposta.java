package com.ToDoAPI.todoAPI.controller.dto;

import java.util.List;

public record ErroResposta(int status, String mensagem, List<ErroCampo> erros) {

    public static ErroResposta respostaPadrao(String mensagem) {
        return new ErroResposta(H, mensagem, null);
    }
}
