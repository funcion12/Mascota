package mascota.usecase;

import mascota.exception.ExceptionMascotaExiste;
import mascota.input.ICrearMascotaInput;
import mascota.modelo.ESTADODESALUD;
import mascota.modelo.Mascota;
import mascota.modelo.TIPODEMASCOTA;
import mascota.output.ICrearMascotaOutput;

public class CrearMascotaUseCase implements ICrearMascotaInput {

    private final ICrearMascotaOutput crearMascotaOutput;

    public CrearMascotaUseCase(ICrearMascotaOutput crearMascotaOutput) {
        this.crearMascotaOutput = crearMascotaOutput;
    }

    @Override
    public boolean crearMascota(Mascota mascota) {
        if(mascota == null) return false;

        if(crearMascotaOutput.existeMascota(mascota.getNombre(),mascota.getDuenio()))throw new ExceptionMascotaExiste("La mascota ya existe");

        return crearMascotaOutput.save(mascota);
    }

}
