package br.com.fiap.vocatalk.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private int errorCode;

}
