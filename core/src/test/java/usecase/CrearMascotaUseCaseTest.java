package usecase;


import mascota.exception.ExceptionMascotaExiste;
import mascota.modelo.ESTADODESALUD;
import mascota.modelo.Mascota;
import mascota.modelo.TIPODEMASCOTA;
import mascota.output.ICrearMascotaOutput;
import mascota.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearMascotaUseCaseTest {

    @Mock
    private ICrearMascotaOutput crearMascotaOutput;

    @Test
    public void crearMascotaUseCaseTest() throws ExceptionMascotaExiste {

        Mascota mascota = Mascota.crearMascota("Pepe", TIPODEMASCOTA.PERRO, ESTADODESALUD.SANO, LocalDate.of(2020,12,10), "Juan");

        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaOutput);

        when(crearMascotaOutput.existeMascota(mascota.getNombre(), mascota.getDuenio())).thenReturn(false);
        when(crearMascotaOutput.save(mascota)).thenReturn(true);

        boolean resultado = crearMascotaUseCase.crearMascota(mascota);

        Assertions.assertTrue(resultado);
    }
}
