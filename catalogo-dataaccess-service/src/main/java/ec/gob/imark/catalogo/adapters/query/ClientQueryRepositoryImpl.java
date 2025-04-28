/**
*
* Este archivo es la implementación del query repository: ClientRepositoryImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientQueryRepositoryImpl
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.adapters.query;

import ec.gob.imark.catalogo.entities.ClientEntity;
import ec.gob.imark.catalogo.exceptions.ClientException;
import ec.gob.imark.catalogo.mappers.ClientMapper;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import ec.gob.imark.catalogo.repositories.ClientJpaRepository;
import ec.gob.imark.catalogo.messages.MessageSourceUtil;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
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
public class ClientQueryRepositoryImpl implements ClientQueryRepository {
	private final ClientJpaRepository clientJpaRepository;
	private final MessageSourceUtil messageSourceUtil;

	/**
	 *
	 * Método que obtiene los datos por id del cliente
	 *
	 * @name findAllClient
	 * @return List<ClientResponseRecord>
	 */
	@Override
	public List<ClientWithMainAddressResponseRecord> searchClients(String search) {
		//return clientJpaRepository.findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress(search,true);

		List<ClientEntity> clientEntityList = clientJpaRepository.findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress(search,true);
		return clientEntityList.stream().map(ClientMapper.INSTANCE::entityToResponseWithMainAddressRecord).toList();
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllClient
	* @return List<ClientResponseRecord>
	*/
	@Override
	public List<ClientResponseRecord> findAllClient() {
		List<ClientEntity> clientEntityList = clientJpaRepository.findAllClient();
		return clientEntityList.stream().map(ClientMapper.INSTANCE::entityToResponseRecord).toList();
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllPaginateClient
	* @param request
		* parameter request
	* @return Page<ClientResponseRecord>
	*/
	@Override
	public Page<ClientResponseRecord> findAllPaginateClient(PaginationRequestRecord request) {
		Sort pegeableSort =
		"ASC".equalsIgnoreCase(request.sortDirection())
		? Sort.by(request.sortBy()).ascending()
		: Sort.by(request.sortBy()).descending();

		Pageable pageable = PageRequest.of(request.page(), request.size(), pegeableSort);
		Page<ClientEntity> ClientEntityPage = clientJpaRepository.findAllPaginateClient(request.search(), pageable);
		return ClientEntityPage.map(ClientMapper.INSTANCE::entityToResponseRecord);
	}

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findByIdClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord 
	*/
	@Override
	public ClientResponseRecord findByIdClient(ClientRequestRecord request) {
		ClientEntity clientEntity = clientJpaRepository.findByIdClient(request.id())
		.orElseThrow(() -> new ClientException(String.format(messageSourceUtil.getMessage("findByIdClient.component.exception.notfound"))));
		return ClientMapper.INSTANCE.entityToResponseRecord(clientEntity);
	}

}
