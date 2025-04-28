/**
*
* Este archivo es la implementación del controlador: AddressCommandControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressCommandControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.xommand.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.command;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.command.AddressCommandService;
import ec.gob.imark.catalogo.ports.outputs.command.AddressCommandRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressCommandServiceImpl implements AddressCommandService {

	private final AddressCommandRepository addressCommandRepository;

	/**
	*
	* Método que obtiene los datosde las direcciónes por id cliente
	*
	* @name saveAddress
	* @param request
		* parameter input request
	* @return AddressResponseRecord
	*/
	@Override
	@Transactional()
	public AddressResponseRecord saveAddress(Integer id, AddressRequestRecord request) {
		return addressCommandRepository.saveAddress(id, request);
	}

}
