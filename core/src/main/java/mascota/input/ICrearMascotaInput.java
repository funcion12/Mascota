package mascota.input;

import mascota.exception.ExceptionNoExisteMascota;
import mascota.modelo.Mascota;


public interface ICrearMascotaInput {
    boolean crearMascota(Mascota mascota) throws ExceptionNoExisteMascota;
}
