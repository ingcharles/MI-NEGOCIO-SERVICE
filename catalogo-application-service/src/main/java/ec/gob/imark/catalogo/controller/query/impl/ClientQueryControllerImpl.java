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
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.query.impl;

import ec.gob.imark.catalogo.ports.inputs.query.ClientQueryService;
import ec.gob.imark.catalogo.controller.query.ClientQueryController;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientQueryControllerImpl implements ClientQueryController {

	private final RestResponseHandler restResponseHandler;
	private final ClientQueryService clientQueryService;


	/**
	 *
	 * Método que busca y obtiene los datos del cliente
	 *
	 * @name searchClients
	 * @return <T> ApiResponseRecord<List<T>>
	 */
	@Override
	public <T> ApiResponseRecord<List<T>> searchClients(String search) {
		try {
			List<T> resultClient = (List<T>) clientQueryService.searchClients(search);
			if (resultClient.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllClient
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@Override
	public <T> ApiResponseRecord<List<T>> findAllClient() {
		try {
			List<T> resultClient = (List<T>) clientQueryService.findAllClient();
			if (resultClient.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllPaginateClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T>
	*/
	@Override
	public <T> ApiResponseRecord<T> findAllPaginateClient(PaginationRequestRecord request) {
		try {
			T resultClient = (T) clientQueryService.findAllPaginateClient(request);
			if (resultClient == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findByIdClient
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> findByIdClient(ClientRequestRecord request) {
		try {
			T resultClient = (T) clientQueryService.findByIdClient(request);
			if (resultClient == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultClient);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

}
