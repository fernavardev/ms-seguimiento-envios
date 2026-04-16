package com.fernavardev.ms_seguimiento_envios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fernavardev.ms_seguimiento_envios.model.Envio;
import com.fernavardev.ms_seguimiento_envios.service.EnvioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/envios")
@CrossOrigin(origins = "*")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> obtenerEnvios() {
        return envioService.getAllEnvios();
    }

    @GetMapping("/{id}")
    public Envio obtenerEnvioPorId(@PathVariable Long id) {
        return envioService.getEnvioById(id);
    }

    @PostMapping
    public Envio crearEnvio(@Valid @RequestBody Envio envio) {
        return envioService.createEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable Long id, @Valid @RequestBody Envio envio) {
        return envioService.updateEnvio(id, envio);
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        envioService.deleteEnvio(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Envio> obtenerEnviosPorEstado(@PathVariable String estado) {
        return envioService.getEnviosByEstado(estado);
    }

    @GetMapping("/ubicacion/{id}")
    public String obtenerUbicacionPorId(@PathVariable Long id) {
        return envioService.getUbicacionById(id);
    }

    @GetMapping("/cliente/{cliente}")
    public List<Envio> obtenerEnviosPorCliente(@PathVariable String cliente) {
        return envioService.getEnviosByCliente(cliente);
    }

    @GetMapping("/producto/{producto}")
    public List<Envio> obtenerEnviosPorProducto(@PathVariable String producto) {
        return envioService.getEnviosByProducto(producto);
    }

    @PutMapping("/actualizar-estado/{id}")
    public Envio actualizarEstadoEnvio(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return envioService.actualizarEstadoEnvio(id, body.get("estado"));
    }

    @PutMapping("/cancelar/{id}")
    public Envio cancelarEnvio(@PathVariable Long id) {
        return envioService.cancelarEnvio(id);
    }
}