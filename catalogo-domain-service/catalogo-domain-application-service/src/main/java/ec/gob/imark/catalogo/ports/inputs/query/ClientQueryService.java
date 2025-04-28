/**
*
* Este archivo es la implementación del controlador: ClientQueryService
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientQueryService
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.inputs.query;

import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import java.util.List;

import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import org.springframework.data.domain.Page;

public interface ClientQueryService {

	/**
	 *
	 * Método que busca y obtiene los datos del cliente
	 *
	 * @name findAllClient
	 * @return List<ClientResponseRecord>
	 */
	List<ClientWithMainAddressResponseRecord> searchClients(String search);


	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllClient
	* @return List<ClientResponseRecord>
	*/
	List<ClientResponseRecord> findAllClient();

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllPaginateClient
	* @param request
		* parameter input request
	* @return Page<ClientResponseRecord>
	*/
	Page<ClientResponseRecord> findAllPaginateClient(PaginationRequestRecord request);

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findByIdClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	ClientResponseRecord findByIdClient(ClientRequestRecord request);

}
