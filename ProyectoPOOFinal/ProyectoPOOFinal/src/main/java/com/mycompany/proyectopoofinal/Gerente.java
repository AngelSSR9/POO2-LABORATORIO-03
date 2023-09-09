package com.mycompany.proyectopoofinal;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Gerente extends Persona{
    private SistemaGestion sistemaGestion;

    public Gerente(String nombre, int dni, int telefono) {
        super(nombre, dni, telefono);
    }

    public SistemaGestion getSistemaGestion() {
        return sistemaGestion;
    }

    public void setSistemaGestion(SistemaGestion sistemaGestion) {
        this.sistemaGestion = sistemaGestion;
    }

    public void registrarNuevoProducto(){
        this.sistemaGestion.registrarNuevoProducto();
    }

    public void registrarNuevoEmpleado(){
        this.sistemaGestion.registrarNuevoEmpleado();
    }

    public void mostrarEmpleadosRegistrados(){
        if(!sistemaGestion.getAlmacen().getEmpleados().isEmpty()){
            String listaEmpleados = sistemaGestion.getAlmacen().obtenerListaEmpleados();
            JOptionPane.showMessageDialog(null, listaEmpleados);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay ni un empleado registrado.");
        }

    }

    public void mostrarProductosRegistrados(){
        if(!sistemaGestion.getAlmacen().getProductos().isEmpty()){
            String listaProductos = sistemaGestion.getAlmacen().obtenerListaProductos();
            JOptionPane.showMessageDialog(null, listaProductos);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay ni un producto registrado.");
        }
    }

    public void mostrarVentasDia(){
        if(!sistemaGestion.getAlmacen().getVentas().isEmpty()){
            LocalDateTime fechaActual = LocalDateTime.now();
            String listaVentas = sistemaGestion.getAlmacen().obtenerListaVentas(fechaActual);
            JOptionPane.showMessageDialog(null, listaVentas);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay ni una venta registrada.");
        }
    }

    public void eliminarEmpleadoRegistrado(){
        if(!this.sistemaGestion.getAlmacen().getEmpleados().isEmpty()){
            int codigoEmpleado = this.obtenerCodigoListaEmpleados();
            this.sistemaGestion.eliminarEmpleado(codigoEmpleado);
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ni un empleado registrado.");
    }

    public void eliminarProductoRegistrado(){
        if(!this.sistemaGestion.getAlmacen().getProductos().isEmpty()){
            int codigoProducto = this.obtenerCodigoListaProductos();
            this.sistemaGestion.eliminarProducto(codigoProducto);
        }
        else
            JOptionPane.showMessageDialog(null, "No hay ni un producto registrado");
    }

    public int obtenerCodigoListaEmpleados(){
        String listaEmpleados = this.sistemaGestion.getAlmacen().obtenerListaEmpleados();
        String codigoEmpleadoText = JOptionPane.showInputDialog(listaEmpleados + "Ingrese el codigo del empleado a eliminar: ");
        while(!Constantes.esNumero(codigoEmpleadoText))
            codigoEmpleadoText = JOptionPane.showInputDialog(listaEmpleados + "Ingrese el codigo del empleado a eliminar: ");
        return Integer.parseInt(codigoEmpleadoText);
    }

    public int obtenerCodigoListaProductos(){
        String listaProductos = this.sistemaGestion.getAlmacen().obtenerListaProductos();
        String codigoProductoText = JOptionPane.showInputDialog(listaProductos + "Ingrese el codigo del producto a eliminar: ");
        while(!Constantes.esNumero(codigoProductoText))
            codigoProductoText = JOptionPane.showInputDialog(listaProductos + "Ingrese el codigo del producto a eliminar: ");
        return Integer.parseInt(codigoProductoText);
    }

}

