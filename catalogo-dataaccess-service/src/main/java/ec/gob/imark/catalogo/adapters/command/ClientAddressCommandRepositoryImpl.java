/**
*
* Este archivo es la implementación del command repository: ClientAddressRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressCommandRepositoryImpl
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.command.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.adapters.command;

import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.exceptions.ClientAddressException;
import ec.gob.imark.catalogo.mappers.ClientAddressMapper;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import ec.gob.imark.catalogo.messages.MessageSourceUtil;
import ec.gob.imark.catalogo.ports.outputs.command.ClientAddressCommandRepository;
import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientAddressCommandRepositoryImpl implements ClientAddressCommandRepository {
	private final ClientAddressJpaRepository clientAddressJpaRepository;
	private final MessageSourceUtil messageSourceUtil;

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
	@Transactional
	public ClientAddressResponseRecord saveClientAddress(
	ClientAddressRequestRecord request)
	{
		ClientAddressEntity clientAddressEntity = ClientAddressMapper.INSTANCE.requestRecordToEntity(request);
		clientAddressEntity = clientAddressJpaRepository.save(clientAddressEntity); 
		return ClientAddressMapper.INSTANCE.entityToResponseRecord(clientAddressEntity); 
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
	public ClientAddressResponseRecord updateClientAddress(ClientAddressRequestRecord request)
	{
		ClientAddressEntity clientAddressEntity = clientAddressJpaRepository.findById(request.id())
			.orElseThrow(() -> new ClientAddressException(String.format(messageSourceUtil.getMessage("clientAddress.findById.exception.notfound"))));
		clientAddressEntity.setIsMainAddress(request.isMainAddress());
		clientAddressEntity.setCreatedAt(request.createdAt());
		clientAddressEntity = clientAddressJpaRepository.save(clientAddressEntity); 
		return ClientAddressMapper.INSTANCE.entityToResponseRecord(clientAddressEntity); 
	}

}
