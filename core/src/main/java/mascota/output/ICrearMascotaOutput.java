package mascota.output;

import mascota.modelo.Mascota;

public interface ICrearMascotaOutput {
    boolean save(Mascota mascota);
    boolean existe(String nombre);
}
