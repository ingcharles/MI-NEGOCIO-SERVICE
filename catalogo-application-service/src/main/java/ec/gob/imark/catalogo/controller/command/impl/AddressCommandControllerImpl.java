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
* @subpackage    ec.gob.imark.catalogo.controller.command.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command.impl;

import ec.gob.imark.catalogo.ports.inputs.command.AddressCommandService;
import ec.gob.imark.catalogo.controller.command.AddressCommandController;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressCommandControllerImpl implements AddressCommandController {

	private final RestResponseHandler restResponseHandler;
	private final AddressCommandService addressCommandService;

	/**
	*
	* Método que guarda los datos de la tabla address
	*
	* @name saveAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> saveAddress(@PathVariable Integer id, AddressRequestRecord request) {
		try {
			T resultAddress = (T) addressCommandService.saveAddress(id, request);
			if (resultAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent("Dirección agregada exitosamente",resultAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError(e);
		}
	}

	/**
	*
	* Método que actualiza los datos de la tabla address
	*
	* @name updateaddress
	* @param request
	 * parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> updateAddress(AddressRequestRecord request) {
		try {
			T resultAddress = (T) addressCommandService.updateAddress(request);
			if (resultAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

}
