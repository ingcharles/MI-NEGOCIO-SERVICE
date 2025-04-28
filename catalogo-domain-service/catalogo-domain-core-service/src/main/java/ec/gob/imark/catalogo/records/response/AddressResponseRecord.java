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
* @subpackage   ec.gob.imark.catalogo.records.response
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.records.response;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record AddressResponseRecord(
	Integer id,
	String province,
	String city,
	String address,
	String isMainAddress,
	LocalDateTime createdAt,
	LocalDateTime updateAt)
 implements Serializable {

}
