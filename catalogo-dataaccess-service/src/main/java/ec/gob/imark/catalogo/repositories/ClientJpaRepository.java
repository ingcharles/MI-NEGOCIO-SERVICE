/**
*
* Este archivo es la implementación del controlador: ClientJpaRepository
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientJpaRepository
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* ¡HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.ClientEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Integer> {

	/**
	 *
	 * Método que busca y obtiene los datos del cliente por número de identificación o nombre
	 *
	 * @name findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress
	 * @return List<ClientEntity>>
	 */
	@Query("""
        SELECT DISTINCT c
        FROM ClientEntity c
        LEFT JOIN ClientAddressEntity ca ON c.id = ca.client.id
        LEFT JOIN AddressEntity a ON ca.address.id = a.id
        WHERE ca.isMainAddress = :isMainAddress
          AND ((:search IS NULL or c.identificationNumber = :search)
            OR (:search IS NULL or LOWER(c.names) LIKE LOWER(CONCAT('%', :search, '%'))))
    """)
	List<ClientEntity> findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress(@Param("search") String search, @Param("isMainAddress")  Boolean isMainAddress);

	/**
	 *
	 * Método que busca y obtiene los datos del cliente por número de identificación
	 *
	 * @name findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress
	 * @return List<ClientEntity>>
	 */
	Optional<ClientEntity> findByIdentificationNumber(String identificationNumber);

}
