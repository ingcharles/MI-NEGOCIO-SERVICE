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
* ¡HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.adapters.query;

import ec.gob.imark.catalogo.entities.ClientEntity;
import ec.gob.imark.catalogo.mappers.ClientMapper;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import ec.gob.imark.catalogo.repositories.ClientJpaRepository;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientQueryRepositoryImpl implements ClientQueryRepository {
	private final ClientJpaRepository clientJpaRepository;

	@Override
	public Optional<ClientResponseRecord> findById(Integer id) {
		return clientJpaRepository.findById(id)
				.map(ClientMapper.INSTANCE::entityToResponseRecord);
	}

	@Override
	public Optional<ClientResponseRecord> findByIdentificationNumber(String identificationNumber) {
		return clientJpaRepository.findByIdentificationNumber(identificationNumber)
				.map(ClientMapper.INSTANCE::entityToResponseRecord);
	}
	/**
	 *
	 * Método que busca y obtiene los datos del cliente por número de identificación o nombre
	 *
	 * @name findAllClient
	 * @return List<ClientResponseRecord>
	 */
	@Override
	public List<ClientWithMainAddressResponseRecord> searchClients(String search) {
		List<ClientEntity> clientEntityList = clientJpaRepository.findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress(search,true);
		return clientEntityList.stream().map(ClientMapper.INSTANCE::entityToResponseWithMainAddressRecord).toList();
	}


}
