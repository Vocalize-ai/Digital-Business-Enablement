package br.com.fiap.vocatalk.models;

public record Token(
    String token,
    String type,
    String prefix
) {}