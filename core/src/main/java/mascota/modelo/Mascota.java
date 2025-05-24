package mascota.modelo;

import mascota.exception.ExceptionFechaMayor;
import mascota.exception.ExceptionMascotaNoVacia;
import mascota.exception.ExceptionMascotaNula;

import java.time.LocalDate;

public class Mascota {
    private final String nombre;
    private final TIPODEMASCOTA tipo;
    private final ESTADODESALUD estado;
    private final LocalDate fechaNacimiento;
    private final String duenio;

    private Mascota(String nombre, TIPODEMASCOTA tipo, ESTADODESALUD estado, LocalDate fechaNacimiento, String duenio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.duenio = duenio;
    }

    public static Mascota crearMascota(String nombre, TIPODEMASCOTA tipo, ESTADODESALUD estado, LocalDate fechaNacimiento, String duenio){
        if(nombre == null || tipo == null || estado == null || fechaNacimiento == null || duenio == null)throw new ExceptionMascotaNula("La mascota no puede ser nula");
        if(nombre.isBlank() || duenio.isBlank())throw new ExceptionMascotaNoVacia("El nombre y el duenio no pueden estar vacios");
        if(tipo == TIPODEMASCOTA.OTRO && nombre.isBlank())throw new ExceptionMascotaNoVacia("El nombre no puede estar vacio cuando el tipo es OTRO");
        if(fechaNacimiento.isAfter(LocalDate.now())) throw new ExceptionFechaMayor("La fecha de nacimiento no puede ser mayor a la fecha actual");
        return new Mascota(nombre,tipo,estado,fechaNacimiento,duenio);
    }

    public String getNombre() {
        return nombre;
    }

    public TIPODEMASCOTA getTipo() {return tipo;}

    public ESTADODESALUD getEstado() {
        return estado;
    }

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}

    public String getDuenio() {return duenio;}

}
