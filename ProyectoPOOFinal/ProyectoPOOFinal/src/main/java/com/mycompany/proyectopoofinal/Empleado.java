package com.mycompany.proyectopoofinal;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable {
    private int codigo;
    private ArrayList<Fabricacion> fabricaciones;
    private SistemaGestion sistemaGestion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Fabricacion> getFabricaciones() {
        return fabricaciones;
    }

    public void setFabricaciones(ArrayList<Fabricacion> fabricaciones) {
        this.fabricaciones = fabricaciones;
    }

    public SistemaGestion getSistemaGestion() {
        return sistemaGestion;
    }

    public void setSistemaGestion(SistemaGestion sistemaGestion) {
        this.sistemaGestion = sistemaGestion;
    }

    public Empleado(String nombre, int dni, int telefono, int codigo) {
        super(nombre, dni, telefono);
        this.codigo = codigo;
        this.fabricaciones = new ArrayList<>();
    }

    public void registrarProducto(){
        this.sistemaGestion.registrarNuevoProducto();
    }

    /*public void registrarVenta(){
        this.sistemaGestion.registrarNuevaVenta();
    }*/

    public void registrarFabricacion(){
        Fabricacion fabricacion = new Fabricacion(sistemaGestion.getAlmacen());
        boolean confirmacion = fabricacion.realizarFabricacion();
        this.sistemaGestion.gestionarFabricacion(fabricacion, confirmacion);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", fabricaciones=" + fabricaciones +
                ", sistemaGestion=" + sistemaGestion +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", telefono=" + telefono +
                '}';
    }
}
