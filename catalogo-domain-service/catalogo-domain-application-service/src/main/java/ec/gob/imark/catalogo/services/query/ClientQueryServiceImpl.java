/**
*
* Este archivo es la implementación del controlador: ClientQueryControllerImpl
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientQueryControllerImpl
* @package       catalogoAllPaginateservices
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.services.query;
import ec.gob.imark.catalogo.exceptions.ClientException;
import ec.gob.imark.catalogo.ports.inputs.query.ClientQueryService;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.Return;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientQueryServiceImpl implements ClientQueryService {

	private final ClientQueryRepository clientQueryRepository;

	/**
	 *
	 * * Método que busca y obtiene los datos del cliente
	 *
	 * @name findAllClient
	 * @return List<ClientResponseRecord>
	 */
	@Override
	public List<ClientWithMainAddressResponseRecord> searchClients(String search) {
		return clientQueryRepository.searchClients(search);
	}

	/*@Override
	public ClientEntity validateClientExists(Integer id) {
		return clientJpaRepository.findById(id)
				.orElseThrow(() -> new ClientException(String.format("Cliente no encontrado con Id: %s", id)));
	}

	@Override
	public void validateIdentificationNumberUpdate(ClientEntity clientExistingEntity, String identificationNumber) {
		clientJpaRepository.findByIdentificationNumber(identificationNumber)
				.filter(c -> !c.getId().equals(clientExistingEntity.getId()))
				.ifPresent(c -> {
					throw new ClientException(
							String.format("Número de identificación ya utilizado no puede ser modificado: %s",
									clientExistingEntity.getIdentificationNumber()));
				});
	}*/

}
