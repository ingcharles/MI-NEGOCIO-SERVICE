/**
*
* Este archivo es la interfaz del repositorio: Client
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientRepository
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.outputs.query;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import java.util.List;
import java.util.Optional;


public interface ClientQueryRepository {

	/**
	 *
	 * * Método que busca y obtiene los datos del cliente por id
	 *
	 * @name findById
	 * @param id
	 * parameter Integer id
	 * @return List<ClientResponseRecord>
	 */
	Optional<ClientResponseRecord> findById(Integer id);

	/**
	 *
	 * * Método que busca y obtiene los datos del cliente por número de identificación
	 *
	 * @param identificationNumber
	 * parameter String identificationNumber
	 * @name findByIdentificationNumber
	 * @return List<ClientResponseRecord>
	 */
	Optional<ClientResponseRecord> findByIdentificationNumber(String identificationNumber);

	/**
	 *
	 * * Método que busca y obtiene los datos del cliente por número de identificación o nombre
	 *
	 * @param search
	 * parameter String search
	 * @name searchClients
	 * @return List<ClientWithMainAddressResponseRecord>
	 */
	List<ClientWithMainAddressResponseRecord> searchClients(String search);

}
