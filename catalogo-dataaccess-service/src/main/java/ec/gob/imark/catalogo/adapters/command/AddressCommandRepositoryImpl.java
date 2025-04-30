/**
*
* Este archivo es la implementación del command repository: AddressRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressCommandRepositoryImpl
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.command.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.adapters.command;

import ec.gob.imark.catalogo.entities.AddressEntity;
import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.entities.ClientEntity;
import ec.gob.imark.catalogo.mappers.AddressMapper;
import ec.gob.imark.catalogo.mappers.ClientAddressMapper;
import ec.gob.imark.catalogo.mappers.ClientMapper;
import ec.gob.imark.catalogo.ports.inputs.validators.ClientValidationService;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.ports.outputs.command.AddressCommandRepository;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.repositories.AddressJpaRepository;
import java.time.LocalDateTime;
import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressCommandRepositoryImpl implements AddressCommandRepository {
	private final ClientAddressJpaRepository clientAddressJpaRepository;
	private final AddressJpaRepository addressJpaRepository;
  private final ClientValidationService clientValidationService;
	/**
	 *
	 * Método que guarda los datos de la dirección por id cliente
	 *
	 * @name saveAddressByIdClient
	 * @param id
	 * parameter Integer id
	 * @param request
	 * parameter AddressRequestRecord request
	 * @return AddressResponseRecord
	 */
	@Override
	@Transactional
	public AddressResponseRecord saveAddressByIdClient(Integer id, AddressRequestRecord request)
	{
		LocalDateTime now = LocalDateTime.now();

		ClientResponseRecord clientResponseRecord = clientValidationService.validateClientExists(id);
		ClientEntity clientEntity = ClientMapper.INSTANCE.responseRecordToEntity(clientResponseRecord);

		AddressEntity addressEntity = AddressMapper.INSTANCE.requestRecordToEntity(request);
		addressEntity.setCreatedAt(now);
		addressEntity = addressJpaRepository.save(addressEntity);

		ClientAddressEntity clientAddressEntity = new ClientAddressEntity();
		clientAddressEntity.setClient(clientEntity);
		clientAddressEntity.setAddress(addressEntity);
		clientAddressEntity.setIsMainAddress(request.isMainAddress());
		clientAddressEntity.setCreatedAt(now);

		clientAddressEntity = clientAddressJpaRepository.save(clientAddressEntity);

		return ClientAddressMapper.INSTANCE.entityToResponseClientRecord(clientAddressEntity);
	}

}
