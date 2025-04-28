/**
*
* Este archivo es la implementación del controlador: ClientAddressCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressCommandControllerImpl
* @package       catalogo-application-services
* @subpackage   ec.gob.imark.catalogo.controller.command
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command;

import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/command/client-address")
@Validated
public interface ClientAddressCommandController {

	/**
	*
	* Método que guarda los datos del cliente_address
	*
	* @name saveClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/saveClientAddress")
	@Operation(summary = "Método que guarda los datos del cliente_address")
	<T> ApiResponseRecord<T> saveClientAddress(@Valid @NotNull @RequestBody ClientAddressRequestRecord request);

	/**
	*
	* Método que actualiza los datos del cliente_address
	*
	* @name updateClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/updateClientAddress")
	@Operation(summary = "Método que actualiza los datos del cliente_address")
	<T> ApiResponseRecord<T> updateClientAddress(@Valid @NotNull @RequestBody ClientAddressRequestRecord request);

}
