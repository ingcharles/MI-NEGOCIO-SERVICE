/**
*
* Este archivo es la implementación del controlador: AddressQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressQueryControllerImpl
* @package       catalogo-application-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.query;

import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/query/address")
@Validated
public interface AddressQueryController {

	/**
	*
	* Método que obtiene los datos de las direcciónes por id cliente
	*
	* @name findAllAddressByIdClient
    * @param id
	 * 	parameter Integer
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@GetMapping("/find-id-client/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de dirrecciones por cliente obtenido exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
			@ApiResponse(responseCode = "409", description = "Conflicto: La solicitud no puede ser procesada debido a un conflicto en los datos enviados"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor")
	})
	@Operation(summary = "Método que obtiene los datos de las direcciónes por id cliente")
	<T> ApiResponseRecord<List<T>> findAllAddressByIdClient(@PathVariable Integer id);


}
