/**
*
* Este archivo es la implementación del controlador: AddressCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressCommandControllerImpl
* @package       catalogo-application-services
* @subpackage   ec.gob.imark.catalogo.controller.command
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command;

import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/command/address")
@Validated
public interface AddressCommandController {

	/**
	*
	* Método que guarda los datos de la tabla address
	*
	* @name saveAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/add-id-client/{id}")
	@Operation(summary = "Método que guarda los datos de la tabla address")
	<T> ApiResponseRecord<T> saveAddress(@PathVariable Integer id, @Valid @NotNull @RequestBody AddressRequestRecord request);

	/**
	*
	* Método que actualiza los datos de la tabla address
	*
	* @name updateAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T>
	*/
	@PostMapping("/updateAddress")
	@Operation(summary = "Método que actualiza los datos de la tabla address")
	<T> ApiResponseRecord<T> updateAddress(@Valid @NotNull @RequestBody AddressRequestRecord request);

}
