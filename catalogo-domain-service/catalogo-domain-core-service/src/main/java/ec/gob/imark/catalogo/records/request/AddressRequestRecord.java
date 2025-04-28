/**
*
* Este archivo es el modelo para enviar los datos
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressRequestRecord
* @package       catalogo-somain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.records.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AddressRequestRecord(
	Integer id,

	@NotBlank(message = "La provincia es obligatoria")
	@Size(max = 100, message = "La provincia no debe superar los 100 caracteres")
	String province,

	@NotBlank(message = "La ciudad es obligatoria")
	@Size(max = 100, message = "La ciudad no debe superar los 100 caracteres")
	String city,

	@NotBlank(message = "La dirección es obligatoria")
	@Size(max = 255, message = "La dirección no debe superar los 255 caracteres")
	String address,

	@NotNull(message = "La dirección principal es obligatoria")
	Boolean isMainAddress,

	LocalDateTime createdAt,
	LocalDateTime updatedAt)
 implements Serializable {

}
