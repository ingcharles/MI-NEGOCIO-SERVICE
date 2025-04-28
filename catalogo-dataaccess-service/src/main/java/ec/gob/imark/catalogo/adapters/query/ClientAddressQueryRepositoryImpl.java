/**
*
* Este archivo es la implementación del query repository: ClientAddressRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressQueryRepositoryImpl
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
import ec.gob.imark.catalogo.exceptions.ClientAddressException;
import ec.gob.imark.catalogo.mappers.ClientAddressMapper;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
import ec.gob.imark.catalogo.messages.MessageSourceUtil;
import ec.gob.imark.catalogo.ports.outputs.query.ClientAddressQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientAddressQueryRepositoryImpl implements ClientAddressQueryRepository {
	private final ClientAddressJpaRepository clientAddressJpaRepository;
	private final MessageSourceUtil messageSourceUtil;

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllClientAddress
	* @return List<ClientAddressResponseRecord>
	*/
	@Override
	public List<ClientAddressResponseRecord> findAllClientAddress() {
		List<ClientAddressEntity> clientAddressEntityList = clientAddressJpaRepository.findAllClientAddress();
		return clientAddressEntityList.stream().map(ClientAddressMapper.INSTANCE::entityToResponseRecord).toList();
	}

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllPaginateClientAddress
	* @param request
		* parameter request
	* @return Page<ClientAddressResponseRecord>
	*/
	@Override
	public Page<ClientAddressResponseRecord> findAllPaginateClientAddress(PaginationRequestRecord request) {
		Sort pegeableSort =
		"ASC".equalsIgnoreCase(request.sortDirection())
		? Sort.by(request.sortBy()).ascending()
		: Sort.by(request.sortBy()).descending();

		Pageable pageable = PageRequest.of(request.page(), request.size(), pegeableSort);
		Page<ClientAddressEntity> ClientAddressEntityPage = clientAddressJpaRepository.findAllPaginateClientAddress(request.search(), pageable);
		return ClientAddressEntityPage.map(ClientAddressMapper.INSTANCE::entityToResponseRecord);
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
		ClientAddressEntity clientAddressEntity = clientAddressJpaRepository.findByIdClientAddress(request.id())
		.orElseThrow(() -> new ClientAddressException(String.format(messageSourceUtil.getMessage("findByIdClientAddress.component.exception.notfound"))));
		return ClientAddressMapper.INSTANCE.entityToResponseRecord(clientAddressEntity);
	}

}
