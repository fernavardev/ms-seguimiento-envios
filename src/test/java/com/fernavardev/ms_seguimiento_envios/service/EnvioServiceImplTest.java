package com.fernavardev.ms_seguimiento_envios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fernavardev.ms_seguimiento_envios.model.Envio;
import com.fernavardev.ms_seguimiento_envios.repository.EnvioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnvioServiceImplTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioServiceImpl envioService;

    private Envio envio;

    @BeforeEach
    void setUp() {
        envio = new Envio(
                "Alimento perro",
                "Juan Perez",
                "Av Siempre Viva 123",
                "pendiente",
                "Bodega",
                "2026-01-01",
                "2026-01-05"
        );
        envio.setId(1L);
    }

    @Test
    void deberiaObtenerTodosLosEnvios() {
        List<Envio> listaMock = Arrays.asList(envio);

        when(envioRepository.findAll()).thenReturn(listaMock);

        List<Envio> resultado = envioService.getAllEnvios();

        assertEquals(1, resultado.size());
        assertEquals("Juan Perez", resultado.get(0).getCliente());

        verify(envioRepository).findAll();
    }

    @Test
    void deberiaActualizarEstadoDelEnvio() {
        when(envioRepository.findById(1L)).thenReturn(Optional.of(envio));
        when(envioRepository.save(any(Envio.class))).thenReturn(envio);

        Envio resultado = envioService.actualizarEstadoEnvio(1L, "entregado");

        assertNotNull(resultado);
        assertEquals("entregado", resultado.getEstado());

        verify(envioRepository).findById(1L);
        verify(envioRepository).save(envio);
    }
}