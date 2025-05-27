package usecase;

import mascota.exception.ExceptionFechaInvalida;
import mascota.exception.ExceptionMascotaYaExiste;
import mascota.exception.ExceptionNoExisteMascota;
import mascota.modelo.Mascota;
import mascota.modelo.TALLA_MASCOTA;
import mascota.output.ICrearMascotaOutput;
import mascota.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CrearMascotaUseCaseTest {

    @Mock
    ICrearMascotaOutput crearMascotaOutput;

    @Test
    public void mascotaNoExiste_crearMascota_mascotaCreada() throws  ExceptionFechaInvalida, ExceptionMascotaYaExiste {
        Mascota mascota = Mascota.crearMascota(UUID.randomUUID(), LocalDate.of(2003,12,30),"Pepe", TALLA_MASCOTA.PEQUEÑA);

        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaOutput);

        when(crearMascotaOutput.existe("Pepe")).thenReturn(false);
        when(crearMascotaOutput.save(mascota)).thenReturn(true);

        Assertions.assertTrue(crearMascotaUseCase.crearMascota(mascota));
    }

    @Test
    public void mascotaYaExiste_crearMascota_noSeCreaMascota() throws  ExceptionFechaInvalida, ExceptionMascotaYaExiste {
        Mascota mascota = Mascota.crearMascota(UUID.randomUUID(), LocalDate.of(2003,12,30),"Pepe", TALLA_MASCOTA.PEQUEÑA);

        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaOutput);

        when(crearMascotaOutput.existe("Pepe")).thenReturn(true);


        Assertions.assertThrows(ExceptionMascotaYaExiste.class,()->crearMascotaUseCase.crearMascota(mascota));
    }


}
