/**
*
* Este archivo es el modelo para recuperar los datos
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientResponseRecord
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.records.response
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.records.response;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record ClientWithMainAddressResponseRecord(
	Integer id,
	String identificationType,
	String identificationNumber,
	String names,
	String email,
	String cellPhone,
	String mainProvince,
	String mainCity,
	String mainAddress,
	LocalDateTime createdAt,
	LocalDateTime updatedAt)
 implements Serializable {

}
