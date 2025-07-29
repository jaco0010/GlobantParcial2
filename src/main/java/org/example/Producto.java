package org.example;

import java.time.LocalDate;

public class Producto {
    public String id;
    public String nombre;
    public String descripcion;
    public String categoria;
    public String proveedor;
    public String foto1;
    public String foto2;
    public LocalDate fechaVencimiento;
    public int PrecioUnitario;
    public int cantidad;

    public Producto(String id, String nombre, String descripcion,
                    String categoria, String proveedor,
                    String foto1, String foto2,
                    LocalDate fechaVencimiento, int precioUnitario, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.fechaVencimiento = fechaVencimiento;
        this.PrecioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }


    public String toString() {
        return String.format(
                "ID: %s\nNombre: %s\nDescripción: %s\nCategoría: %s\nProveedor: %s\nPrecio unitario: $%d\nCantidad en bodega: %d\nVence: %s",
                id, nombre, descripcion, categoria,
                proveedor, PrecioUnitario, cantidad,
                fechaVencimiento
        );
    }
}
