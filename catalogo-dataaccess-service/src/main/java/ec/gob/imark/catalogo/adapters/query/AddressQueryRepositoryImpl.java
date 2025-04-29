/**
*
* Este archivo es la implementación del query repository: AddressRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressQueryRepositoryImpl
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.adapters.query;

import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.mappers.ClientAddressMapper;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.ports.outputs.query.AddressQueryRepository;
import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressQueryRepositoryImpl implements AddressQueryRepository {
	private final ClientAddressJpaRepository clientAddressJpaRepository;

	/**
	*
	* Método que obtiene los datos de las direcciónes por id cliente
	*
	* @name findAllAddressByIdClient
	* @return List<AddressResponseRecord>
	*/
	@Override
	public List<AddressResponseRecord> findAllAddressByIdClient(Integer id) {

		List<ClientAddressEntity> addressEntityList = clientAddressJpaRepository.findByClientId(id);
		return addressEntityList.stream().map(ClientAddressMapper.INSTANCE::entityToResponseClientRecord).toList();
	}

}
