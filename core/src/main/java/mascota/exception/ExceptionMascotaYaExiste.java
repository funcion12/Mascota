package mascota.exception;

public class ExceptionMascotaYaExiste extends RuntimeException {
    public ExceptionMascotaYaExiste(String message) {
        super(message);
    }
}
