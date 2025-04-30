/**
*
* Este archivo es el modelo para enviar los datos
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressRequestRecord
* @package       catalogo-somain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.records.request;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ClientAddressRequestRecord(
	Integer id,
	ClientRequestRecord clientId,
	AddressRequestRecord addressId,
	Boolean isMainAddress,
	LocalDateTime createdAt,
	LocalDateTime updatedAt)
 implements Serializable {

}
