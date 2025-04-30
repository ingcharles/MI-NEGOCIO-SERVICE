/**
*
* Este archivo es la implementación del controlador: ClientCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientCommandControllerImpl
* @package       catalogo-application-services
* @subpackage   ec.gob.imark.catalogo.controller.command
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command;

import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/command/client")
@Validated
public interface ClientCommandController {

	/**
	*
	* Método que guarda los datos del cliente
	*
	* @name create
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/create")
	@Operation(summary = "Método que guarda los datos del cliente")
	<T> ApiResponseRecord<T> saveClient(@Valid @NotNull @RequestBody ClientRequestRecord request);

	/**
	*
	* Método que actualiza los datos del cliente
	*
	* @name updateClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@PostMapping("/update")
	@Operation(summary = "Método que actualiza los datos del cliente")
	<T> ApiResponseRecord<T> updateClient(@Valid @NotNull @RequestBody ClientUpdateRequestRecord request);

	/**
	 *
	 * Método que elimina los datos del cliente
	 *
	 * @name updateClient
	 * @param id
	 * parameter input id
	 * @return <T> ApiResponseRecord<T>
	 */
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Método que elimina los datos del cliente")
	<T> ApiResponseRecord<T> deleteClient(@PathVariable Integer id);

}
