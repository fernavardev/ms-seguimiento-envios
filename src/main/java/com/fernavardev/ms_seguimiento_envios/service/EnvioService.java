package com.fernavardev.ms_seguimiento_envios.service;

import java.util.List;

import com.fernavardev.ms_seguimiento_envios.model.Envio;

public interface EnvioService {

    List<Envio> getAllEnvios();

    Envio getEnvioById(Long id);

    Envio createEnvio(Envio envio);

    Envio updateEnvio(Long id, Envio envio);

    void deleteEnvio(Long id);

    List<Envio> getEnviosByEstado(String estado);

    List<Envio> getEnviosByCliente(String cliente);

    List<Envio> getEnviosByProducto(String producto);

    String getUbicacionById(Long id);

    Envio actualizarEstadoEnvio(Long id, String nuevoEstado);

    Envio cancelarEnvio(Long id);
}