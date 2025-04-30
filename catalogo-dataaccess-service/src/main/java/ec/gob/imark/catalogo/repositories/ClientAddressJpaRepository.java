/**
*
* Este archivo es la implementación del controlador: ClientAddressJpaRepository
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressJpaRepository
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* ¡HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressJpaRepository extends JpaRepository<ClientAddressEntity, Integer> {

	/**
	 *
	 * Método que obtiene los datos por id del cliente
	 *
	 * @name findByClientId
	 * @param id
	 * parameter input id
	 * @return List<ClientAddressEntity>
	 */
	List<ClientAddressEntity> findByClientId(Integer id);

}
