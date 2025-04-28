/**
*
* Este archivo es la implementación del controlador: ClientQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientQueryControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.query;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.query.ClientQueryService;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import java.util.List;

import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientQueryServiceImpl implements ClientQueryService {

	private final ClientQueryRepository clientQueryRepository;

	/**
	 *
	 * * Método que busca y obtiene los datos del cliente
	 *
	 * @name findAllClient
	 * @return List<ClientResponseRecord>
	 */
	@Override
	public List<ClientWithMainAddressResponseRecord> searchClients(String search) {
		return clientQueryRepository.searchClients(search);
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllClient
	* @return List<ClientResponseRecord>
	*/
	@Override
	public List<ClientResponseRecord> findAllClient() {
		return clientQueryRepository.findAllClient();
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllPaginateClient
	* @param request
		* parameter input request
	* @return Page<ClientResponseRecord>
	*/
	@Override
	public Page<ClientResponseRecord> findAllPaginateClient(PaginationRequestRecord request) {
		return clientQueryRepository.findAllPaginateClient(request);
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findByIdClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	@Override
	public ClientResponseRecord findByIdClient(ClientRequestRecord request) {
		return clientQueryRepository.findByIdClient(request);
	}

}
