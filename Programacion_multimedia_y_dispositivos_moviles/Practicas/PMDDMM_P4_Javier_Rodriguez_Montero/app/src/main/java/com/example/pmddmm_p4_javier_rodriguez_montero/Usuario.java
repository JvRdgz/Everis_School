package com.example.pmddmm_p4_javier_rodriguez_montero;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public String toString() {
        return this.nombreUsuario + "#" + this.contrasena;
    }
}
