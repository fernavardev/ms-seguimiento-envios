package com.fernavardev.ms_seguimiento_envios;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fernavardev.ms_seguimiento_envios.model.Envio;
import com.fernavardev.ms_seguimiento_envios.repository.EnvioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final EnvioRepository repository;

    public DataLoader(EnvioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {

            repository.save(new Envio(
                    "Alimento para perro", "Ana Torres", "Av. Providencia 123",
                    "pendiente", "Bodega central", "2026-03-20", "2026-03-25"));

            repository.save(new Envio(
                    "Arena para gato", "Luis Soto", "Calle Norte 456",
                    "en_transito", "Centro de distribución", "2026-03-21", "2026-03-26"));

            repository.save(new Envio(
                    "Collar antipulgas", "María Pérez", "Pasaje Los Robles 789",
                    "entregado", "Domicilio del cliente", "2026-03-18", "2026-03-22"));

            repository.save(new Envio(
                    "Juguete para perro", "Carlos Díaz", "Av. Matta 741",
                    "cancelado", "Envío cancelado", "2026-03-19", "2026-03-24"));

            repository.save(new Envio(
                    "Shampoo para mascotas", "Fernanda Rojas", "Las Camelias 100",
                    "pendiente", "Bodega central", "2026-03-22", "2026-03-27"));

            repository.save(new Envio(
                    "Cama para gato", "Pedro Molina", "Los Álamos 222",
                    "en_transito", "Ruta de despacho", "2026-03-20", "2026-03-25"));

            repository.save(new Envio(
                    "Correa extensible", "Valentina Castro", "Av. Grecia 909",
                    "entregado", "Domicilio del cliente", "2026-03-17", "2026-03-21"));

            repository.save(new Envio(
                    "Snack para perro", "Jorge Herrera", "San Diego 555",
                    "pendiente", "Bodega central", "2026-03-23", "2026-03-28"));

            repository.save(new Envio(
                    "Transportadora para gato", "Camila Muñoz", "Los Leones 222",
                    "en_transito", "Centro logístico norte", "2026-03-24", "2026-03-29"));

            repository.save(new Envio(
                    "Cepillo para perro", "Sebastián López", "Av. Irarrázaval 456",
                    "cancelado", "Envío cancelado", "2026-03-18", "2026-03-23"));

            repository.save(new Envio(
                    "Rascador para gato", "Daniela Fuentes", "Santa Isabel 300",
                    "entregado", "Domicilio del cliente", "2026-03-16", "2026-03-20"));

            repository.save(new Envio(
                    "Plato antiderrame", "Tomás Navarro", "Portugal 678",
                    "pendiente", "Bodega central", "2026-03-25", "2026-03-30"));
        }
    }
}