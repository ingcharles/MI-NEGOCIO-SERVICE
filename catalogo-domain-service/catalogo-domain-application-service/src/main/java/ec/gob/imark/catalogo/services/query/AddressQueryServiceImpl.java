/**
*
* Este archivo es la implementación del controlador: AddressQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressQueryControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.query;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.ports.inputs.query.AddressQueryService;
import ec.gob.imark.catalogo.ports.outputs.query.AddressQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressQueryServiceImpl implements AddressQueryService {

	private final AddressQueryRepository addressQueryRepository;

	/**
	*
	* Método que obtiene los datos de las direcciónes por id cliente
	*
	* @name findAllAddressByIdClient
	* @return List<AddressResponseRecord>
	*/
	@Override
	public List<AddressResponseRecord> findAllAddressByIdClient(Integer id) {

		return addressQueryRepository.findAllAddressByIdClient(id);
	}


}
