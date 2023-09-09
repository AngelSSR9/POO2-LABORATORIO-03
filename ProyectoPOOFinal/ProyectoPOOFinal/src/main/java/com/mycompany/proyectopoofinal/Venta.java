package com.mycompany.proyectopoofinal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Venta implements Serializable {
    private Map<Producto, Integer> productos;
    private Cliente cliente;
    private LocalDateTime fecha;
    private double montoTotal;

    public Venta(Map<Producto, Integer> productos, Cliente cliente, LocalDateTime fecha, double montoTotal) {
        this.productos = productos;
        this.cliente = cliente;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void agregarProducto(Producto producto, int cantidad){
        this.productos.put(producto, cantidad);
    }

    public String obtenerListaProductos(){
        StringBuffer listaProductos = new StringBuffer();
        int longitudMaxima = 0;
        for(Producto producto : productos.keySet()){
            String nombre = producto.getNombre();
            longitudMaxima = Math.max(longitudMaxima, nombre.length());
        }

        for(Map.Entry<Producto, Integer> entry : productos.entrySet()){
            Producto producto = entry.getKey();
            int canntidad = entry.getValue();
            String puntos = Constantes.generateDots(longitudMaxima - producto.getNombre().length() + 5);
            listaProductos.append(producto.getNombre()).append(puntos).append(canntidad).append("\n");
        }
        return listaProductos.toString();
    }

}
