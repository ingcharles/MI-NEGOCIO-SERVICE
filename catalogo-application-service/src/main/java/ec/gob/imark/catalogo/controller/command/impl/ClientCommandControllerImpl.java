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
* @subpackage    ec.gob.imark.catalogo.controller.command.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.command.impl;

import ec.gob.imark.catalogo.ports.inputs.command.ClientCommandService;
import ec.gob.imark.catalogo.controller.command.ClientCommandController;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientCommandControllerImpl implements ClientCommandController {

	private final RestResponseHandler restResponseHandler;
	private final ClientCommandService clientCommandService;

	/**
	*
	* Método que guarda los datos del cliente
	*
	* @name saveClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> saveClient(ClientRequestRecord request) {
		try {
			T resultClient = (T) clientCommandService.saveClient(request);
			if (resultClient == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent("Información guardada exitosamente",resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError(e);
		}
	}

	/**
	*
	* Método que actualiza los datos del cliente
	*
	* @name updateclient
	* @param request
	 * parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> updateClient(ClientUpdateRequestRecord request) {
		try {
			T resultClient = (T) clientCommandService.updateClient(request);
			if (resultClient == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent("Registro actualizado exitosamente", resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError(e);
		}
	}

	/**
	 *
	 * Método que eliminar los datos del cliente
	 *
	 * @name updateclient
	 * @param id
	 * parameter input id
	 * @return <T> ApiResponseRecord<T>
	 */
	@Override
	public <T> ApiResponseRecord<T> deleteClient(Integer id) {
		try {
			T resultClient = (T) clientCommandService.deleteClient(id);
			if (resultClient == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent("Registro eliminado exitosamente", resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError(e);
		}
	}

}
