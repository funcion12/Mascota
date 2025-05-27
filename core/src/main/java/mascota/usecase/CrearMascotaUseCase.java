package mascota.usecase;

import mascota.exception.ExceptionMascotaYaExiste;
import mascota.input.ICrearMascotaInput;
import mascota.modelo.Mascota;
import mascota.output.ICrearMascotaOutput;

public class CrearMascotaUseCase implements ICrearMascotaInput {

    ICrearMascotaOutput crearMascotaOutput;

    public CrearMascotaUseCase(ICrearMascotaOutput crearMascotaOutput) {
        this.crearMascotaOutput = crearMascotaOutput;
    }

    @Override
    public boolean crearMascota(Mascota mascota) {
        if(crearMascotaOutput.existe(mascota.getNombre())) throw new ExceptionMascotaYaExiste("Ya existe una mascota con ese nombre");

        return crearMascotaOutput.save(mascota);
    }
}
