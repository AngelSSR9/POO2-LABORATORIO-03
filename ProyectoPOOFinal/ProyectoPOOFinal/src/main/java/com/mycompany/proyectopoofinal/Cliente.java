package com.mycompany.proyectopoofinal;

import java.io.Serializable;
import java.util.Map;

public class Cliente extends Persona implements Serializable {
    private Map<String, Venta> historialCompras;
    private String email;
    private String password;

    public Cliente(String nombre, int dni, int telefono, String email, String password) {
        super(nombre, dni, telefono);
        this.email = email;
        this.password = password;
    }

    public Map<String, Venta> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(Map<String, Venta> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cliente{" + "historialCompras=" + historialCompras + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
}
