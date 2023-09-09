package com.mycompany.proyectopoofinal;

import javax.swing.*;
import java.io.Serializable;

public class Fabricacion implements Runnable, Serializable {

    private Almacen almacen;
    private Producto producto;
    private int cantidad;
    private Empleado empleado;

    public Fabricacion(Almacen almacen) {
        this.almacen = almacen;
    }

    public boolean realizarFabricacion() {
        boolean confirmacion = false;
        String dniEmpleadoText = JOptionPane.showInputDialog("Ingrese su dni.");
        if (esNumero(dniEmpleadoText)) {
            int dniEmpleado = Integer.parseInt(dniEmpleadoText);
            this.empleado = almacen.buscarEmpleado(dniEmpleado);
            if(empleado != null){
                String listaProductos = almacen.obtenerListaProductos();

                String opcionText = JOptionPane.showInputDialog(listaProductos + "Ingrese el numero del producto que va a fabricar: ");
                if (!esNumero(opcionText)) {
                    opcionText = JOptionPane.showInputDialog(listaProductos + "Ingrese el numero del producto que va a fabricar: ");
                }
                int opcion = Integer.parseInt(opcionText);
                if (opcion != almacen.getProductos().size() + 1) {
                    this.producto = almacen.buscarProductoPorIndice(opcion);
                    String cantidadText = JOptionPane.showInputDialog("Ingrese la cantidad a fabricar: ");
                    while (!esNumero(cantidadText)) {
                        cantidadText = JOptionPane.showInputDialog("Ingrese la cantidad a fabricar: ");
                    }
                    this.cantidad = Integer.parseInt(cantidadText);

                    //ACTUALIZAR EL STOCK SEGUN LA CANTIDAD FABRICADA
                    int stockActual = this.almacen.productos.get(producto.getCodigo()).getStock();
                    this.almacen.productos.get(producto.getCodigo()).setStock(stockActual + this.cantidad);
                    Thread fabricacionThread = new Thread(this);
                    fabricacionThread.start();
                    confirmacion = true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El DNI ingresado no esta registrado.");
            }
        }
        return confirmacion;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Fabricando " + producto.getNombre() + " | Cantidad: " + cantidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error en el bloqueo del hilo: " + e.toString());
            }
        }
    }

    private boolean esNumero(String texto) {
        try {
            Integer numero = Integer.valueOf(texto);
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese una opcion!");
            return false;
        }
    }

}
