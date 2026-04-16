package com.fernavardev.ms_seguimiento_envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernavardev.ms_seguimiento_envios.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long> {

    List<Envio> findByEstadoIgnoreCase(String estado);

    List<Envio> findByClienteIgnoreCase(String cliente);

    List<Envio> findByProductoIgnoreCase(String producto);
}