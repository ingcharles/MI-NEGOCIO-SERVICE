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

import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/query/address")
@Validated
public interface AddressQueryController {

	/**
	*
	* Método que obtiene los datos de la tabla address
	*
	* @name findAllAddress
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@GetMapping("/find-id-client/{id}")
	@Operation(summary = "Método que obtiene los datos de la tabla address")
	<T> ApiResponseRecord<List<T>> findAllAddress(@PathVariable Integer id);

	/**
	*
	* Método que obtiene los datos de la tabla address
	*
	* @name FindAllPaginateAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@PostMapping("/findAllPaginateAddress")
	@Operation(summary = "Método que obtiene los datos de la tabla address")
	<T> ApiResponseRecord<T> findAllPaginateAddress(
		@Valid @NotNull @RequestBody PaginationRequestRecord request);

	/**
	*
	* Método que obtiene los datos de la tabla address
	*
	* @name findByIdAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/findByIdAddress")
	@Operation(summary = "Método que obtiene los datos de la tabla address")
	<T> ApiResponseRecord<T> findByIdAddress(@Valid @NotNull @RequestBody AddressRequestRecord request);

}
