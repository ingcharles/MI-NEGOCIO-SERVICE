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

import ec.gob.imark.catalogo.entities.AddressEntity;
import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.exceptions.AddressException;
import ec.gob.imark.catalogo.mappers.AddressMapper;
import ec.gob.imark.catalogo.mappers.ClientAddressMapper;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.request.PaginationRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.repositories.AddressJpaRepository;
import ec.gob.imark.catalogo.messages.MessageSourceUtil;
import ec.gob.imark.catalogo.ports.outputs.query.AddressQueryRepository;
import java.util.List;

import ec.gob.imark.catalogo.repositories.ClientAddressJpaRepository;
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
public class AddressQueryRepositoryImpl implements AddressQueryRepository {
	private final ClientAddressJpaRepository clientAddressJpaRepository;
	private final AddressJpaRepository addressJpaRepository;
	private final MessageSourceUtil messageSourceUtil;

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findAllAddress
	* @return List<AddressResponseRecord>
	*/
	@Override
	public List<AddressResponseRecord> findAllAddress(Integer id) {

		List<ClientAddressEntity> addressEntityList = clientAddressJpaRepository.findByClientId(id);
		return addressEntityList.stream().map(ClientAddressMapper.INSTANCE::entityToResponseClientRecord).toList();
	}

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findAllPaginateAddress
	* @param request
		* parameter request
	* @return Page<AddressResponseRecord>
	*/
	@Override
	public Page<AddressResponseRecord> findAllPaginateAddress(PaginationRequestRecord request) {
		Sort pegeableSort =
		"ASC".equalsIgnoreCase(request.sortDirection())
		? Sort.by(request.sortBy()).ascending()
		: Sort.by(request.sortBy()).descending();

		Pageable pageable = PageRequest.of(request.page(), request.size(), pegeableSort);
		Page<AddressEntity> AddressEntityPage = addressJpaRepository.findAllPaginateAddress(request.search(), pageable);
		return AddressEntityPage.map(AddressMapper.INSTANCE::entityToResponseRecord);
	}

	/**
	*
	* Método que obtiene los datos por id cliente de la dirección
	*
	* @name findByIdAddress
	* @param request
		* parameter input request
	* @return AddressResponseRecord 
	*/
	@Override
	public AddressResponseRecord findByIdAddress(AddressRequestRecord request) {
		AddressEntity addressEntity = addressJpaRepository.findByIdAddress(request.id())
		.orElseThrow(() -> new AddressException(String.format(messageSourceUtil.getMessage("findByIdAddress.component.exception.notfound"))));
		return AddressMapper.INSTANCE.entityToResponseRecord(addressEntity);
	}

}
