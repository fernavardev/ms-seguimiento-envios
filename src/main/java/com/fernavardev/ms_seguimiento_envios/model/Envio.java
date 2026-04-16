package com.fernavardev.ms_seguimiento_envios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El producto no puede estar vacio")
    @Size(min = 2, max = 120, message = "El producto debe tener entre 2 y 120 caracteres")
    @Column(name = "producto", nullable = false)
    private String producto;

    @NotBlank(message = "El cliente no puede estar vacio")
    @Size(min = 2, max = 100, message = "El cliente debe tener entre 2 y 100 caracteres")
    @Column(name = "cliente", nullable = false)
    private String cliente;

    @NotBlank(message = "La direccion no puede estar vacia")
    @Size(min = 5, max = 200, message = "La direccion debe tener entre 5 y 200 caracteres")
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotBlank(message = "El estado no puede estar vacio")
    @Pattern(
        regexp = "^(pendiente|en_transito|entregado|cancelado)$",
        message = "El estado solo puede ser: pendiente, en_transito, entregado o cancelado"
    )
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotBlank(message = "La ubicacion actual no puede estar vacia")
    @Size(min = 3, max = 150, message = "La ubicacion actual debe tener entre 3 y 150 caracteres")
    @Column(name = "ubicacion_actual", nullable = false)
    private String ubicacionActual;

    @NotBlank(message = "La fecha de envio no puede estar vacia")
    @Column(name = "fecha_envio", nullable = false)
    private String fechaEnvio;

    @NotBlank(message = "La fecha estimada de entrega no puede estar vacia")
    @Column(name = "fecha_estimada_entrega", nullable = false)
    private String fechaEstimadaEntrega;

    public Envio() {
    }

    public Envio(String producto, String cliente, String direccion, String estado,
                 String ubicacionActual, String fechaEnvio, String fechaEstimadaEntrega) {
        this.producto = producto;
        this.cliente = cliente;
        this.direccion = direccion;
        this.estado = estado;
        this.ubicacionActual = ubicacionActual;
        this.fechaEnvio = fechaEnvio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public Long getId() {
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

    public void setId(Long id) {
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