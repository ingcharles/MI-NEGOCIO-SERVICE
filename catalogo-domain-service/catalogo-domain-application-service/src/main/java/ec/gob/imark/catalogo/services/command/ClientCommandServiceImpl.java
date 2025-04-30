/**
*
* Este archivo es la implementación del controlador: ClientCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientCommandControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.xommand.impl
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.command;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.command.ClientCommandService;
import ec.gob.imark.catalogo.ports.outputs.command.ClientCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientCommandServiceImpl implements ClientCommandService {

	private final ClientCommandRepository clientCommandRepository;

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name saveClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	@Override
	@Transactional()
	public ClientResponseRecord saveClient(ClientRequestRecord request) {

		return clientCommandRepository.saveClient(request);
	}

	/**
	*
	* Método que actualiza los datos por id del cliente
	*
	* @name updateClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	@Override
	@Transactional
	public ClientResponseRecord updateClient(ClientUpdateRequestRecord request) {
		return clientCommandRepository.updateClient(request);
	}

	/**
	 *
	 * Método que elimina los datos por id del cliente
	 *
	 * @name deleteClient
	 * @param id
	 * parameter input request
	 * @return ClientResponseRecord
	 */
	@Override
	@Transactional
	public ClientResponseRecord deleteClient(Integer id) {
		return clientCommandRepository.deleteClient(id);
	}

}
