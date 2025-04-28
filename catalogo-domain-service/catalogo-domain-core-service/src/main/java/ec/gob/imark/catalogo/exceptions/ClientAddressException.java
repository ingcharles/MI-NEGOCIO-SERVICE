/**
*
* Este archivo es el modelo para recuperar los datos
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressResponseRecord
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.exceptions
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.exceptions;

public class ClientAddressException extends GeneralException {
public ClientAddressException (String message) { super(message); }
public ClientAddressException (String message, Throwable cause) { super(message, cause); }

}
