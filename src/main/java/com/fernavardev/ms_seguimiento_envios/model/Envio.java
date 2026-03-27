package com.fernavardev.ms_seguimiento_envios.model;

public class Envio {

    private int id;
    private String producto;
    private String cliente;
    private String direccion;
    private String estado;
    private String ubicacionActual;
    private String fechaEnvio;
    private String fechaEstimadaEntrega;

    public Envio() {
    }

    public Envio(int id, String producto, String cliente, String direccion, String estado,
                 String ubicacionActual, String fechaEnvio, String fechaEstimadaEntrega) {
        this.id = id;
        this.producto = producto;
        this.cliente = cliente;
        this.direccion = direccion;
        this.estado = estado;
        this.ubicacionActual = ubicacionActual;
        this.fechaEnvio = fechaEnvio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public String getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setFechaEstimadaEntrega(String fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }
}