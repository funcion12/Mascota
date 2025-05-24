package mascota.output;

import mascota.modelo.Mascota;

public interface ICrearMascotaOutput {
    boolean existeMascota(String nombre, String duenio);
    boolean save(Mascota mascota);
}
