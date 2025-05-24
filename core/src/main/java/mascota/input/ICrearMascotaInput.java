package mascota.input;

import mascota.exception.ExceptionMascotaExiste;
import mascota.modelo.Mascota;

public interface ICrearMascotaInput {
    boolean crearMascota(Mascota mascota)throws ExceptionMascotaExiste;
}
