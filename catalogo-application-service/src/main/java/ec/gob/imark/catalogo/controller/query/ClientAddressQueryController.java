/**
*
* Este archivo es la implementación del controlador: ClientAddressQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressQueryControllerImpl
* @package       catalogo-application-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.query;

import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/query/client-address")
@Validated
public interface ClientAddressQueryController {

	/**
	*
	* Método que obtiene los datos del cliente_address
	*
	* @name findAllClientAddress
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@GetMapping("/findAllClientAddress")
	@Operation(summary = "Método que obtiene los datos del cliente_address")
	<T> ApiResponseRecord<List<T>> findAllClientAddress();

	/**
	*
	* Método que obtiene los datos del cliente_address
	*
	* @name FindAllPaginateClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@PostMapping("/findAllPaginateClientAddress")
	@Operation(summary = "Método que obtiene los datos del cliente_address")
	<T> ApiResponseRecord<T> findAllPaginateClientAddress(
		@Valid @NotNull @RequestBody PaginationRequestRecord request);

	/**
	*
	* Método que obtiene los datos del cliente_address
	*
	* @name findByIdClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/findByIdClientAddress")
	@Operation(summary = "Método que obtiene los datos del cliente_address")
	<T> ApiResponseRecord<T> findByIdClientAddress(@Valid @NotNull @RequestBody ClientAddressRequestRecord request);

}
