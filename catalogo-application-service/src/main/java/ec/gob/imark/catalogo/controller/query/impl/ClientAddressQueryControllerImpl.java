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
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.query.impl;

import ec.gob.imark.catalogo.ports.inputs.query.ClientAddressQueryService;
import ec.gob.imark.catalogo.controller.query.ClientAddressQueryController;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientAddressQueryControllerImpl implements ClientAddressQueryController {

	private final RestResponseHandler restResponseHandler;
	private final ClientAddressQueryService clientAddressQueryService;

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllClientAddress
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@Override
	public <T> ApiResponseRecord<List<T>> findAllClientAddress() {
		try {
			List<T> resultClientAddress = (List<T>) clientAddressQueryService.findAllClientAddress();
			if (resultClientAddress.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultClientAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllPaginateClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T>
	*/
	@Override
	public <T> ApiResponseRecord<T> findAllPaginateClientAddress(PaginationRequestRecord request) {
		try {
			T resultClientAddress = (T) clientAddressQueryService.findAllPaginateClientAddress(request);
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
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findByIdClientAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> findByIdClientAddress(ClientAddressRequestRecord request) {
		try {
			T resultClientAddress = (T) clientAddressQueryService.findByIdClientAddress(request);
			if (resultClientAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultClientAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

}
