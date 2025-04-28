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
* @subpackage    ec.gob.imark.catalogo.controller.command.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command.impl;

import ec.gob.imark.catalogo.ports.inputs.command.ClientAddressCommandService;
import ec.gob.imark.catalogo.controller.command.ClientAddressCommandController;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientAddressCommandControllerImpl implements ClientAddressCommandController {

	private final RestResponseHandler restResponseHandler;
	private final ClientAddressCommandService clientAddressCommandService;

	/**
	*
	* Método que guarda los datos del cliente_address
	*
	* @name saveClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> saveClientAddress(ClientAddressRequestRecord request) {
		try {
			T resultClientAddress = (T) clientAddressCommandService.saveClientAddress(request);
			if (resultClientAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultClientAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que actualiza los datos del cliente_address
	*
	* @name updateclientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> updateClientAddress(ClientAddressRequestRecord request) {
		try {
			T resultClientAddress = (T) clientAddressCommandService.updateClientAddress(request);
			if (resultClientAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultClientAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

}
