package com.fernavardev.ms_seguimiento_envios.controller;


import com.fernavardev.ms_seguimiento_envios.model.Envio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnvioController {

    private List<Envio> envios;

    public EnvioController() {
        envios = new ArrayList<>();

        envios.add(new Envio(1, "Alimento para perro", "Ana Torres", "Av. Providencia 123",
                "pendiente", "Bodega central", "2026-03-20", "2026-03-25"));

        envios.add(new Envio(2, "Arena para gato", "Luis Soto", "Calle Norte 456",
                "en_transito", "Centro de distribución", "2026-03-21", "2026-03-26"));

        envios.add(new Envio(3, "Collar antipulgas", "María Pérez", "Pasaje Los Robles 789",
                "entregado", "Domicilio del cliente", "2026-03-18", "2026-03-22"));

        envios.add(new Envio(4, "Juguete para perro", "Carlos Díaz", "Av. Matta 741",
                "cancelado", "Envío cancelado", "2026-03-19", "2026-03-24"));

        envios.add(new Envio(5, "Shampoo para mascotas", "Fernanda Rojas", "Las Camelias 100",
                "pendiente", "Bodega central", "2026-03-22", "2026-03-27"));

        envios.add(new Envio(6, "Cama para gato", "Pedro Molina", "Los Álamos 222",
                "en_transito", "Ruta de despacho", "2026-03-20", "2026-03-25"));

        envios.add(new Envio(7, "Correa extensible", "Valentina Castro", "Av. Grecia 909",
                "entregado", "Domicilio del cliente", "2026-03-17", "2026-03-21"));

        envios.add(new Envio(8, "Snack para perro", "Jorge Herrera", "San Diego 555",
                "pendiente", "Bodega central", "2026-03-23", "2026-03-28"));
    }

    @GetMapping("/envios")
    public List<Envio> obtenerEnvios() {
        return envios;
    }

    @GetMapping("/envios/{id}")
    public Envio obtenerEnvioPorId(@PathVariable int id) {
        for (Envio envio : envios) {
            if (envio.getId() == id) {
                return envio;
            }
        }
        return null;
    }

    @GetMapping("/envios/estado/{estado}")
    public List<Envio> obtenerEnviosPorEstado(@PathVariable String estado) {
        List<Envio> resultado = new ArrayList<>();

        for (Envio envio : envios) {
            if (envio.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(envio);
            }
        }

        return resultado;
    }

    @GetMapping("/envios/ubicacion/{id}")
    public String obtenerUbicacionPorId(@PathVariable int id) {
        for (Envio envio : envios) {
            if (envio.getId() == id) {
                return "La ubicación actual del envío " + id + " es: " + envio.getUbicacionActual();
            }
        }
        return "No se encontró un envío con id " + id;
    }

    @GetMapping("/envios/cliente/{cliente}")
    public List<Envio> obtenerEnviosPorCliente(@PathVariable String cliente) {
        List<Envio> resultado = new ArrayList<>();

        for (Envio envio : envios) {
            if (envio.getCliente().equalsIgnoreCase(cliente)) {
                resultado.add(envio);
            }
        }

        return resultado;
    }

    @GetMapping("/envios/producto/{producto}")
    public List<Envio> obtenerEnviosPorProducto(@PathVariable String producto) {
        List<Envio> resultado = new ArrayList<>();

        for (Envio envio : envios) {
            if (envio.getProducto().equalsIgnoreCase(producto)) {
                resultado.add(envio);
            }
        }

        return resultado;
    }
}
