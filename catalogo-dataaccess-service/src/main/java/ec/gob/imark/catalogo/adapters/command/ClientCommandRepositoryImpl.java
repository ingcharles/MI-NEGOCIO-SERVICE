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
import ec.gob.imark.catalogo.exceptions.ClientException;
import ec.gob.imark.catalogo.mappers.AddressMapper;
import ec.gob.imark.catalogo.mappers.ClientMapper;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
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
		clientJpaRepository.findByIdentificationNumber(request.identificationNumber())
				.ifPresent(_ -> {
					throw new ClientException(
							String.format("Cliente ya existe: %s", request.identificationNumber()));
				});

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
	public ClientResponseRecord updateClient(ClientRequestRecord request)
	{
		ClientEntity clientExistingEntity = clientJpaRepository.findById(request.id())
				.orElseThrow(() -> new ClientException(String.format("Cliente no encontrado: %s", request.identificationNumber())));

		clientJpaRepository.findByIdentificationNumber(request.identificationNumber())
				.filter(c -> !c.getId().equals(clientExistingEntity.getId()))
				.ifPresent(c -> { throw new ClientException(String.format("Número de identificación ya utilizado no puede ser modificado: %s", clientExistingEntity.getIdentificationNumber())); });

		//ClientEntity clientExistingEntity = clientQueryService.validateClientExists(request.id());

		//clientQueryService.validateIdentificationNumberUpdate(clientExistingEntity, request.identificationNumber());

		clientExistingEntity.setIdentificationType(request.identificationType());
		clientExistingEntity.setIdentificationNumber(request.identificationNumber());
		clientExistingEntity.setNames(request.names());
		clientExistingEntity.setEmail(request.email());
		clientExistingEntity.setCellPhone(request.cellPhone());
		clientExistingEntity.setUpdatedAt(request.updatedAt());
		clientExistingEntity.setUpdatedAt(LocalDateTime.now());

		ClientEntity clientEntity = clientJpaRepository.save(clientExistingEntity);

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
		ClientEntity clientEntity = clientJpaRepository.findById(id)
				.orElseThrow(() -> new ClientException(String.format("Cliente no encontrado con Id: %s", id)));

		clientJpaRepository.delete(clientEntity);

		return ClientMapper.INSTANCE.entityToResponseRecord(clientEntity);
	}

}
