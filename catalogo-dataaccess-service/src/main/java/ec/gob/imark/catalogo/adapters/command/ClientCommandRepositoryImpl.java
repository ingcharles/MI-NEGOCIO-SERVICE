/**
*
* Este archivo es la implementación del command repository: ClientRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientCommandRepositoryImpl
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
import ec.gob.imark.catalogo.mappers.ClientMapper;
import ec.gob.imark.catalogo.ports.inputs.validators.ClientValidationService;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.ports.outputs.command.ClientCommandRepository;
import ec.gob.imark.catalogo.repositories.AddressJpaRepository;
import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
import ec.gob.imark.catalogo.repositories.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientCommandRepositoryImpl implements ClientCommandRepository {
	private final ClientJpaRepository clientJpaRepository;
	private final AddressJpaRepository addressJpaRepository;
	private final ClientAddressJpaRepository clientAddressJpaRepository;
  private final ClientValidationService clientValidationService;
	private final ClientMapper clientMapper;

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
	@Transactional
	public ClientResponseRecord saveClient(
	ClientRequestRecord request)
	{
		clientValidationService.validateIdentificationNumberSave(request.identificationNumber());

		LocalDateTime now = LocalDateTime.now();

		AddressEntity addressEntity = AddressMapper.INSTANCE.requestRecordToEntity(request.address());
		addressEntity.setCreatedAt(now);
		addressEntity = addressJpaRepository.save(addressEntity);

		ClientEntity clientEntity = ClientMapper.INSTANCE.requestRecordToEntity(request);
		clientEntity.setCreatedAt(now);
		clientEntity = clientJpaRepository.save(clientEntity);

		ClientAddressEntity clientAddressEntity = new ClientAddressEntity();
		clientAddressEntity.setClient(clientEntity);
		clientAddressEntity.setAddress(addressEntity);
		clientAddressEntity.setIsMainAddress(request.address().isMainAddress());
		clientAddressEntity.setCreatedAt(now);

		clientAddressJpaRepository.save(clientAddressEntity);

		return ClientMapper.INSTANCE.entityToResponseRecord(clientEntity); 
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
	public ClientResponseRecord updateClient(ClientUpdateRequestRecord request)
	{
		ClientResponseRecord clientResponseRecord = clientValidationService.validateClientExists(request.id());
		ClientEntity clientExistingEntity = clientMapper.responseRecordToEntity(clientResponseRecord);

		clientValidationService.validateIdentificationNumberUpdate(clientExistingEntity.getId(), request.identificationNumber());

		ClientEntity clientEntity = clientMapper.requestUpdateRecordToEntity(request);
		clientEntity.setCreatedAt(clientExistingEntity.getCreatedAt());
		clientEntity.setUpdatedAt(LocalDateTime.now());
		clientEntity = clientJpaRepository.save(clientEntity);

		return ClientMapper.INSTANCE.entityToResponseRecord(clientEntity); 
	}

	/**
	 *
	 * Método que elimina los datos por id del cliente
	 *
	 * @name deleteClient
	 * @param id
	 * parameter input id
	 * @return ClientResponseRecord
	 */
	@Override
	@Transactional
	public ClientResponseRecord deleteClient(Integer id)
	{

		ClientResponseRecord clientResponseRecord = clientValidationService.validateClientExists(id);
		ClientEntity clientEntity = clientMapper.responseRecordToEntity(clientResponseRecord);
		clientJpaRepository.delete(clientEntity);

		return ClientMapper.INSTANCE.entityToResponseRecord(clientEntity);
	}

}
