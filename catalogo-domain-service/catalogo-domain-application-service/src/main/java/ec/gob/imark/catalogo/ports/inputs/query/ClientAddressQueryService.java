/**
*
* Este archivo es la implementación del controlador: ClientAddressQueryService
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressQueryService
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.inputs.query;

import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ClientAddressQueryService {

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllClientAddress
	* @return List<ClientAddressResponseRecord>
	*/
	List<ClientAddressResponseRecord> findAllClientAddress();

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllPaginateClientAddress
	* @param request
		* parameter input request
	* @return Page<ClientAddressResponseRecord>
	*/
	Page<ClientAddressResponseRecord> findAllPaginateClientAddress(PaginationRequestRecord request);

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findByIdClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	ClientAddressResponseRecord findByIdClientAddress(ClientAddressRequestRecord request);

}
