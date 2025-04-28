/**
*
* Este archivo es la implementación del controlador: ClientAddressCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressCommandControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.xommand.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.command;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.command.ClientAddressCommandService;
import ec.gob.imark.catalogo.ports.outputs.command.ClientAddressCommandRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientAddressCommandServiceImpl implements ClientAddressCommandService {

	private final ClientAddressCommandRepository clientAddressCommandRepository;

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name saveClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	@Override
	@Transactional()
	public ClientAddressResponseRecord saveClientAddress(ClientAddressRequestRecord request) {
		return clientAddressCommandRepository.saveClientAddress(request);
	}

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name updateClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	@Override
	@Transactional
	public ClientAddressResponseRecord updateClientAddress(ClientAddressRequestRecord request) {
		return clientAddressCommandRepository.updateClientAddress(request);
	}

}
