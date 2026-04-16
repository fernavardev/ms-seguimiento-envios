package com.fernavardev.ms_seguimiento_envios.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernavardev.ms_seguimiento_envios.model.Envio;
import com.fernavardev.ms_seguimiento_envios.repository.EnvioRepository;

@Service
public class EnvioServiceImpl implements EnvioService {

    private static final Logger log = LoggerFactory.getLogger(EnvioServiceImpl.class);

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public List<Envio> getAllEnvios() {
        log.info("Obteniendo todos los envios");
        return envioRepository.findAll();
    }

    @Override
    public Envio getEnvioById(Long id) {
        log.info("Buscando envio con id {}", id);
        return envioRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro un envio con id {}", id);
                    return new RuntimeException("No se encontró un envío con id " + id);
                });
    }

    @Override
    public Envio createEnvio(Envio envio) {
        log.info("Creando nuevo envio para cliente {}", envio.getCliente());
        return envioRepository.save(envio);
    }

    @Override
    public Envio updateEnvio(Long id, Envio envio) {
        log.info("Actualizando envio con id {}", id);
        if (envioRepository.existsById(id)) {
            envio.setId(id);
            return envioRepository.save(envio);
        } else {
            log.warn("No se encontro un envio para actualizar con id {}", id);
            throw new RuntimeException("No se encontró un envío con id " + id);
        }
    }

    @Override
    public void deleteEnvio(Long id) {
        log.info("Eliminando envio con id {}", id);
        if (envioRepository.existsById(id)) {
            envioRepository.deleteById(id);
        } else {
            log.warn("No se encontro un envio para eliminar con id {}", id);
            throw new RuntimeException("No se encontró un envío con id " + id);
        }
    }

    @Override
    public List<Envio> getEnviosByEstado(String estado) {
        log.info("Buscando envios por estado {}", estado);
        List<Envio> envios = envioRepository.findByEstadoIgnoreCase(estado);
        if (envios.isEmpty()) {
            log.warn("No existen envios con estado {}", estado);
            throw new RuntimeException("No existen envíos con estado: " + estado);
        }
        return envios;
    }

    @Override
    public List<Envio> getEnviosByCliente(String cliente) {
        log.info("Buscando envios del cliente {}", cliente);
        List<Envio> envios = envioRepository.findByClienteIgnoreCase(cliente);
        if (envios.isEmpty()) {
            log.warn("No existen envios para el cliente {}", cliente);
            throw new RuntimeException("No existen envíos para el cliente: " + cliente);
        }
        return envios;
    }

    @Override
    public List<Envio> getEnviosByProducto(String producto) {
        log.info("Buscando envios por producto {}", producto);
        List<Envio> envios = envioRepository.findByProductoIgnoreCase(producto);
        if (envios.isEmpty()) {
            log.warn("No existen envios para el producto {}", producto);
            throw new RuntimeException("No existen envíos para el producto: " + producto);
        }
        return envios;
    }

    @Override
    public String getUbicacionById(Long id) {
        log.info("Buscando ubicacion actual del envio con id {}", id);
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro un envio para consultar ubicacion con id {}", id);
                    return new RuntimeException("No se encontró un envío con id " + id);
                });

        return "La ubicación actual del envío " + id + " es: " + envio.getUbicacionActual();
    }

    @Override
    public Envio actualizarEstadoEnvio(Long id, String nuevoEstado) {
        log.info("Actualizando estado del envio con id {} a {}", id, nuevoEstado);
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro un envio para actualizar estado con id {}", id);
                    return new RuntimeException("No se encontró un envío con id " + id);
                });

        envio.setEstado(nuevoEstado);
        return envioRepository.save(envio);
    }

    @Override
    public Envio cancelarEnvio(Long id) {
        log.info("Cancelando envio con id {}", id);
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro un envio para cancelar con id {}", id);
                    return new RuntimeException("No se encontró un envío con id " + id);
                });

        envio.setEstado("cancelado");
        return envioRepository.save(envio);
    }
}