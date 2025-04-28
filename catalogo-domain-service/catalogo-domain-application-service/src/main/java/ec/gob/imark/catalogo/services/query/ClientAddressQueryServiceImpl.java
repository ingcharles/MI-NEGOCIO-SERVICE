/**
*
* Este archivo es la implementación del controlador: ClientAddressQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressQueryControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.query;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.query.ClientAddressQueryService;
import ec.gob.imark.catalogo.ports.outputs.query.ClientAddressQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientAddressQueryServiceImpl implements ClientAddressQueryService {

	private final ClientAddressQueryRepository clientAddressQueryRepository;

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllClientAddress
	* @return List<ClientAddressResponseRecord>
	*/
	@Override
	public List<ClientAddressResponseRecord> findAllClientAddress() {
		return clientAddressQueryRepository.findAllClientAddress();
	}

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllPaginateClientAddress
	* @param request
		* parameter input request
	* @return Page<ClientAddressResponseRecord>
	*/
	@Override
	public Page<ClientAddressResponseRecord> findAllPaginateClientAddress(PaginationRequestRecord request) {
		return clientAddressQueryRepository.findAllPaginateClientAddress(request);
	}

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findByIdClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	@Override
	public ClientAddressResponseRecord findByIdClientAddress(ClientAddressRequestRecord request) {
		return clientAddressQueryRepository.findByIdClientAddress(request);
	}

}
