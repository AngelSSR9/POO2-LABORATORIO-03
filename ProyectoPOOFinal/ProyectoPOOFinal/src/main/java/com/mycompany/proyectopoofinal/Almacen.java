package com.mycompany.proyectopoofinal;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Almacen implements Serializable {

    private double ganancias;
    private double gastos;

    Hashtable<Integer, Empleado> empleados;
    LinkedHashMap<Integer, Producto> productos;
    Hashtable<String, Cliente> clientes;

    List<Venta> ventas;
    List<Fabricacion> fabricaciones;
    List<Maquina> maquinas;

    private File archivo = new File("almacen.txt");
    private File archivoCodigos = new File("codigos.txt");

    public Almacen() {
        this.empleados = new Hashtable<>();
        this.productos = new LinkedHashMap<>();
        this.clientes = new Hashtable<>();
        this.fabricaciones = new ArrayList<>();
        this.ventas = new ArrayList<>();
        if(!archivo.exists()) {
            try {
                archivo.createNewFile();
                guardarAlmacen();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error al crear el archivo: " + e.toString());
            }
        }
        if(!archivoCodigos.exists()){
            try{
                archivoCodigos.createNewFile();
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Erro al crear el archivo:" + e.toString());
            }
        }
    }

    public List<Fabricacion> getFabricaciones() {
        return fabricaciones;
    }

    public void setFabricaciones(List<Fabricacion> fabricaciones) {
        this.fabricaciones = fabricaciones;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public File getArchivoCodigos() {
        return archivoCodigos;
    }

    public void setArchivoCodigos(File archivoCodigos) {
        this.archivoCodigos = archivoCodigos;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public Hashtable<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Hashtable<Integer, Empleado> empleados) {
        this.empleados = empleados;
    }

    public LinkedHashMap<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedHashMap<Integer, Producto> productos) {
        this.productos = productos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public Hashtable<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Hashtable<String, Cliente> clientes) {
        this.clientes = clientes;
    }
    
    

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.put(empleado.getDni(), empleado);
    }

    public void agregarProducto(Producto producto) {
        this.productos.put(producto.getCodigo(), producto);
    }

    public void agregarFabricacion(Fabricacion fabricacion){
        this.fabricaciones.add(fabricacion);
    }

    public void agregarVenta(Venta venta){ 
        this.ventas.add(venta); 
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.put(cliente.getEmail(), cliente);
    }

    public void eliminarProducto(int codigoProducto) {
        this.productos.remove(codigoProducto);
    }

    public void eliminarEmpleado(int codigoEmpleado) {
        this.empleados.remove(codigoEmpleado);
    }
    
    

    public String obtenerListaProductos() {
        System.out.println("Productos registrados: " + productos.size());
        StringBuffer listaProductos = new StringBuffer("LISTA DE PRODUCTOS:\n");
        int i = 1;
        int longitudMaxima = 0;

        //Determinar la longitud maxima del nombre del producto
        for(Producto producto : productos.values()){
            String nombre = producto.getNombre();
            longitudMaxima = Math.max(longitudMaxima, nombre.length());
        }

        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            Producto producto = entry.getValue();
            String puntos = Constantes.generateDots(longitudMaxima - producto.getNombre().length() + 5);

            listaProductos.append("[" + (i) + "] ").append(producto.getNombre()).append(puntos).append("| Stock: " + producto.getStock() + "\n");
            i++;
        }
        listaProductos.append("["+(i)+"] Salir.\n");
        return listaProductos.toString();
    }

    public String obtenerListaEmpleados() {
        StringBuffer listaEmpleados = new StringBuffer("LISTA DE EMPLEADOS:\n");
        int i = 1;

        for (Map.Entry<Integer, Empleado> entry : empleados.entrySet()) {
            Empleado empleado = entry.getValue();

            listaEmpleados.append("[" + (i) + "] ").append(empleado.getNombre()).append("\n");
            i++;
        }
        listaEmpleados.append("["+(i)+"] Salir.\n");
        return listaEmpleados.toString();
    }

    public String obtenerListaVentas(){
        StringBuilder listaVentas = new StringBuilder("LISTA DE VENTAS:\n");
        int i = 1;
        listaVentas.append("---------------------------------\n");
        for(Venta venta : ventas){
            listaVentas.append("[" + i + "] ").append("Fecha: " + venta.getFecha() + "\n")
                    .append("Cliente: " + venta.getCliente().nombre + "| DNI: " + venta.getCliente().getDni() + "\n")
                    .append(venta.obtenerListaProductos())
                    .append("---------------------------------\n");
        }
        return listaVentas.toString();
    }

    public String obtenerListaVentas(LocalDateTime fecha){
        StringBuffer listaVentas = new StringBuffer("LISTA DE VENTAS DE HOY:\n");
        int i = 1;
        LocalDate fechaAux = fecha.toLocalDate();

        listaVentas.append("--------------------------------\n");
        for(Venta venta : ventas){
            LocalDate fechaVenta = venta.getFecha().toLocalDate();
            if(fechaVenta.equals(fechaAux)){
                LocalTime horaVenta = venta.getFecha().toLocalTime();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaFormateada = horaVenta.format(formato);

                listaVentas.append("[" + i + "] ").append("Fecha: " + fechaVenta + " " + horaFormateada + "\n")
                        .append("Cliente: " + venta.getCliente().nombre + "| DNI: " + venta.getCliente().getDni()  + "\n")
                        .append(venta.obtenerListaProductos())
                        .append("---------------------------------\n");
            }
        }
        return listaVentas.toString();
    }

    public Producto buscarProducto(int codigoProducto){
        Producto producto = null;
        producto = productos.get(codigoProducto);
        return producto;
    }

    public Empleado buscarEmpleado(int dniEmpleado){
        Empleado empleado = null;
        empleado = empleados.get(dniEmpleado);
        return empleado;
    }

    public Producto buscarProductoPorIndice(int indice){
        Producto producto = null;
        int i = 1;
        for(Map.Entry<Integer, Producto> entry : productos.entrySet()){
            if(i == indice){
                producto = entry.getValue();
            }
        }
        return producto;
    }

    public Cliente buscarCliente(String email){
        return clientes.get(email);
    }

    //METODOS PARA SERIALIZAR Y DESERIALIZAR EL ALMACEN
    public void guardarAlmacen(){
        try {
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(archivo));
            guardar.writeObject(this);
            guardar.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro al guardar almacen: " + e.toString());
        }
    }

    public Almacen cargarAlmacen(){
        Almacen almacen = null;
        try {
            ObjectInputStream obtener = new ObjectInputStream(new FileInputStream(archivo));
            almacen = (Almacen) obtener.readObject();
            obtener.close();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro al cargar almacen: " + e.toString());
        }
        return almacen;
    }
}
