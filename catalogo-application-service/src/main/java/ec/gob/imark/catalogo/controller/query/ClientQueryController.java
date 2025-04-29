/**
*
* Este archivo es la implementación del controlador: ClientQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientQueryControllerImpl
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

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/query/client")
@Validated
public interface ClientQueryController {


	/**
	 *
	 * Método que busca y obtiene los datos del cliente
	 *
	 * @param search
	 * 	parameter String
	 * @name searchClients
	 * @return <T> ApiResponseRecord<List<T>>
	 */
	@GetMapping("/search-clients")
	@Operation(summary = "Método que busca y obtiene los datos del cliente por número de identificación o nombre")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de clientes encontrado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
			@ApiResponse(responseCode = "409", description = "Conflicto: La solicitud no puede ser procesada debido a un conflicto en los datos enviados"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor")
	})
	<T> ApiResponseRecord<List<T>> searchClients(
			@Parameter(description = "Texto de búsqueda para filtrar clientes (Número de identidad o Nombre))")
			@RequestParam String search
	);

}
