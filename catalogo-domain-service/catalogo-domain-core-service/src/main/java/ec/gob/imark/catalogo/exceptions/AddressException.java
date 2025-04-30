/**
*
* Este archivo es el modelo para recuperar los datos
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressResponseRecord
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.exceptions
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class AddressException extends GeneralException {
    private final HttpStatus httpStatus;

    public AddressException(String message) {
        super(message);
        this.httpStatus = HttpStatus.CONFLICT; // 409
    }

    public AddressException (String message, Throwable cause, HttpStatus httpStatus) { super(message, cause);
        this.httpStatus = httpStatus;
    }

}
