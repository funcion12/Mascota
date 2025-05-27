package mascota.modelo;

import mascota.exception.ExceptionFechaInvalida;
import mascota.exception.ExceptionNombreInvalido;

import java.time.LocalDate;
import java.util.UUID;

public class Mascota {
    private UUID id;
    private final LocalDate fecha_nacimiento;
    private final String nombre;
    private final TALLA_MASCOTA talla;

    private Mascota(UUID id, LocalDate fecha_nacimiento, String nombre, TALLA_MASCOTA talla) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.talla = talla;
    }

    public static Mascota crearMascota(UUID id, LocalDate fecha_nacimiento, String nombre, TALLA_MASCOTA talla) throws ExceptionFechaInvalida {
        if(fecha_nacimiento.isAfter(LocalDate.now())) throw new ExceptionFechaInvalida("La fecha de nacimiento no puede ser posterior a la fecha actual");
        if(nombre.isBlank()) throw new ExceptionNombreInvalido("El nombre no puede estar vacío");
        if(talla == null) throw new ExceptionNombreInvalido("La talla no puede estar vacía");
        if(id == null) id = UUID.randomUUID();

        return new Mascota(id, fecha_nacimiento, nombre, talla);
    }

    public UUID getId() {return id;}
    public LocalDate getFecha_nacimiento() {return fecha_nacimiento;}
    public String getNombre() {return nombre;}
    public TALLA_MASCOTA getTalla() {return talla;}

}
