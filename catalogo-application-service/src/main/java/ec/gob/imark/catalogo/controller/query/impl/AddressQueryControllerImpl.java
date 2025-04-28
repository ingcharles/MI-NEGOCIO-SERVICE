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
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.controller.query.impl;

import ec.gob.imark.catalogo.ports.inputs.query.AddressQueryService;
import ec.gob.imark.catalogo.controller.query.AddressQueryController;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ApiResponseRecord;
import ec.gob.imark.catalogo.controller.utils.RestResponseHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressQueryControllerImpl implements AddressQueryController {

	private final RestResponseHandler restResponseHandler;
	private final AddressQueryService addressQueryService;

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findAllAddress
	* @return <T> ApiResponseRecord<List<T>>
	*/
	@Override
	public <T> ApiResponseRecord<List<T>> findAllAddress(Integer id) {
		try {
			List<T> resultAddress = (List<T>) addressQueryService.findAllAddress(id);
			if (resultAddress.isEmpty()) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleListContent(resultAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError(e);
		}
	}

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findAllPaginateAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T>
	*/
	@Override
	public <T> ApiResponseRecord<T> findAllPaginateAddress(PaginationRequestRecord request) {
		try {
			T resultAddress = (T) addressQueryService.findAllPaginateAddress(request);
			if (resultAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findByIdAddress
	* @param request
		* parameter input request
	* @return <T> ApiResponseRecord<T> 
	*/
	@Override
	public <T> ApiResponseRecord<T> findByIdAddress(AddressRequestRecord request) {
		try {
			T resultAddress = (T) addressQueryService.findByIdAddress(request);
			if (resultAddress == null) {
				return restResponseHandler.handleNoContent();
			}
			return restResponseHandler.handleContent(resultAddress);
		} catch (Exception e) {
			return restResponseHandler.handleInternalServerError();
		}
	}

}
