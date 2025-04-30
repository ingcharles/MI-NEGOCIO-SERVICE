package ec.gob.imark.catalogo;

import ec.gob.imark.catalogo.exceptions.ClientException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ClientException.class)
  public ResponseEntity<Object> handleClientNotFound(ClientException ex) {
    // Tu implementación personalizada
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
    // Manejo de errores de integridad de datos
    return ResponseEntity.badRequest().body("Error de integridad de datos");
  }
}