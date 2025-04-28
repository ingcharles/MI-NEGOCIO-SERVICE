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

import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/query/client")
@Validated
public interface ClientQueryController {


	/**
	 *
	 * Método que busca y obtiene los datos del cliente
	 *
	 * @name searchClients
	 * @return <T> ApiResponseRecord<List<T>>
	 */
	@GetMapping("/search-clients")
	@Operation(summary = "Método que busca y obtiene los datos del cliente")
	<T> ApiResponseRecord<List<T>> searchClients(@RequestParam String search);

	/**
	*
	* Método que obtiene los datos del cliente
	*
	* @name findAllClient
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@GetMapping("/findAllClient")
	@Operation(summary = "Método que obtiene los datos del cliente")
	<T> ApiResponseRecord<List<T>> findAllClient();

	/**
	*
	* Método que obtiene los datos del cliente
	*
	* @name FindAllPaginateClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@PostMapping("/findAllPaginateClient")
	@Operation(summary = "Método que obtiene los datos del cliente")
	<T> ApiResponseRecord<T> findAllPaginateClient(
		@Valid @NotNull @RequestBody PaginationRequestRecord request);

	/**
	*
	* Método que obtiene los datos del cliente
	*
	* @name findByIdClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/findByIdClient")
	@Operation(summary = "Método que obtiene los datos del cliente")
	<T> ApiResponseRecord<T> findByIdClient(@Valid @NotNull @RequestBody ClientRequestRecord request);

}
