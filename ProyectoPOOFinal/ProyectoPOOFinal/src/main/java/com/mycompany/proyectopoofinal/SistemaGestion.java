package com.mycompany.proyectopoofinal;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Map;

public class SistemaGestion implements Serializable {
    private Almacen almacen;

    public SistemaGestion(Almacen almacen) {
        this.almacen = almacen;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public void gestionarFabricacion(Fabricacion fabricacion, boolean confirmacion) {
        if (confirmacion) {
            this.almacen.agregarFabricacion(fabricacion);
            JOptionPane.showMessageDialog(null, "Fabricacion registrada correctamente.");
        }
    }

    public void registrarNuevoEmpleado() {
        Empleado empleado = leerDatosEmpleado();
        int codigo = 0;
        File archivo = almacen.getArchivoCodigos();
        long longitudArchivo = archivo.length();
        //System.out.println("archivo length: " + archivo.length());
        //Asignar codigo al producto
        try {
            RandomAccessFile rw = new RandomAccessFile(archivo, "rw");
            //System.out.println("archivo length: " + archivo.length());
            if (longitudArchivo > 0) {
                //System.out.println("Entra en el if");
                if(longitudArchivo == 1){
                    //System.out.println("Entra en long 1");
                    rw.seek(1);
                    codigo = 1;
                    rw.writeBytes(String.valueOf(codigo));
                    rw.close();
                }
                else if(longitudArchivo == 2){
                    //System.out.println("Entra en long 2");
                    rw.seek(1);
                    String codigoStr = rw.readLine();
                    codigo = Integer.parseInt(codigoStr);
                    //System.out.println("CODIGO LEIDO: " + codigo);
                    codigo++;
                    rw.seek(1);
                    rw.writeBytes(String.valueOf(codigo));
                    rw.close();
                }
            } else {
                //System.out.println("Entra en el else");
                rw.seek(0);
                rw.writeBytes("0");
                codigo = 1;
                rw.seek(1);
                rw.writeBytes(String.valueOf(codigo));
                rw.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        empleado.setCodigo(codigo);
        System.out.println("Codigo del empleado : " + codigo);
        this.almacen.agregarEmpleado(empleado);
        JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
    }

    public void registrarNuevoProducto() {
        Producto producto = leerDatosProducto();
        int codigo = 0;
        File archivo = almacen.getArchivoCodigos();
        long longitudArchivo = archivo.length();
        //System.out.println("archivo length: " + archivo.length());
        //Asignar codigo al producto
        try {
            RandomAccessFile rw = new RandomAccessFile(archivo, "rw");
            //System.out.println("archivo length: " + archivo.length());
            if (longitudArchivo > 0) {
                if(longitudArchivo == 1){
                    rw.seek(0);
                    String codigoStr = rw.readLine();
                    codigo = Integer.parseInt(codigoStr);
                    codigo++;
                    rw.seek(0);
                    rw.writeBytes(String.valueOf(codigo));
                    rw.close();
                }
                else if(longitudArchivo == 2){
                    //System.out.println("Entra en el if");
                    rw.seek(0);
                    String codigoStr[] = rw.readLine().split("");
                    codigo = Integer.parseInt(codigoStr[0]);
                    //System.out.println("CODIGO LEIDO: " + codigo);
                    codigo++;
                    rw.seek(0);
                    rw.writeBytes(String.valueOf(codigo));
                    rw.close();
                }
            } else if (longitudArchivo == 0){
                //System.out.println("Entra en el else");
                codigo = 1;
                rw.writeBytes(String.valueOf(codigo));
                rw.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        producto.setCodigo(codigo);
        System.out.println("Codigo del producto : " + codigo);
        this.almacen.agregarProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");
    }

    /*public void registrarNuevaVenta(){
        Venta venta = this.leerDatosVenta();
        this.almacen.agregarVenta(venta);
        JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
    }*/

    public void eliminarEmpleado(int codigoEmpleado) {
        this.almacen.eliminarEmpleado(codigoEmpleado);
        JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
    }

    public void eliminarProducto(int codigoProducto) {
        this.almacen.eliminarProducto(codigoProducto);
        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
    }

    public Producto leerDatosProducto(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto:");
        String stockText = JOptionPane.showInputDialog("Ingrese el stock inicial del producto:");
        while (!Constantes.esNumero(stockText))
            stockText = JOptionPane.showInputDialog("Ingrese el stock inicial del producto:");
        int stock = Integer.parseInt(stockText);

        String precioText = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        while (!Constantes.esNumero(precioText))
            precioText = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        int precio = Integer.parseInt(precioText);

        return new Producto(nombre, descripcion, stock, precio, 0);
    }

    public Empleado leerDatosEmpleado(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        String dniText = JOptionPane.showInputDialog("Ingrese el DNI: ");
        while (!Constantes.esNumero(dniText))
            dniText = JOptionPane.showInputDialog("Ingrese el DNI: ");
        int dni = Integer.parseInt(dniText);
        String telefonoText = JOptionPane.showInputDialog("Ingrese el numero telefonico: ");
        while (!Constantes.esNumero(telefonoText))
            telefonoText = JOptionPane.showInputDialog("Ingrese el numero telefonico: ");
        int telefono = Integer.parseInt(telefonoText);

        return new Empleado(nombre, dni, telefono, 0);
    }

    /*public Cliente leerDatosCliente(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        String dniText = JOptionPane.showInputDialog("Ingrese el DNI: ");
        while (!Constantes.esNumero(dniText))
            dniText = JOptionPane.showInputDialog("Ingrese el DNI: ");
        int dni = Integer.parseInt(dniText);
        String telefonoText = JOptionPane.showInputDialog("Ingrese el numero telefonico: ");
        while (!Constantes.esNumero(telefonoText))
            telefonoText = JOptionPane.showInputDialog("Ingrese el numero telefonico: ");
        int telefono = Integer.parseInt(telefonoText);

        return new Cliente(nombre, dni, telefono);
    }*/

    /*public Venta leerDatosVenta(){
        Cliente cliente = leerDatosCliente();
        LocalDateTime fechaActual = LocalDateTime.now();
        Map<Producto, Integer> productos = null;
        float montoTotal = 0;

        int cantProductos = almacen.productos.size();
        int opcion = 0;
        while(opcion != cantProductos + 1){
            String opcText = JOptionPane.showInputDialog(almacen.obtenerListaProductos() + "Seleccione un producto: ");
            while(!Constantes.esNumero(opcText)) opcText = JOptionPane.showInputDialog(almacen.obtenerListaProductos() + "Seleccione un producto: ");
            opcion = Integer.parseInt(opcText);

            Producto productoSeleccionado = this.almacen.buscarProductoPorIndice(opcion);
            if(productoSeleccionado != null){
                productos = new Hashtable<>();
                String cantText = JOptionPane.showInputDialog("Ingrese la cantidad a comprar: ");
                while(!Constantes.esNumero(cantText)) cantText = JOptionPane.showInputDialog("Ingrese la cantidad a comprar: ");
                int cantidad = Integer.parseInt(cantText);
                int stockActual = this.almacen.productos.get(productoSeleccionado.getCodigo()).getStock();
                this.almacen.getProductos().get(productoSeleccionado.getCodigo()).setStock(stockActual - cantidad);
                montoTotal += productoSeleccionado.getPrecio() * cantidad;
                productos.put(productoSeleccionado, cantidad);
            }

        }

        return new Venta(productos, cliente, fechaActual, montoTotal);
    }*/

}
