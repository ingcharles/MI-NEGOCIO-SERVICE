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
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.ClientEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Integer> {

	/**
	 *
	 * Método que obtiene los datos por id del cliente
	 *
	 * @name findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCase
	 * @return List<ClientEntity>>
	 */
	@Query("""
        SELECT DISTINCT c
        FROM ClientEntity c
        LEFT JOIN ClientAddressEntity ca ON c.id = ca.client.id
        LEFT JOIN AddressEntity a ON ca.address.id = a.id
        WHERE ca.isMainAddress = :isMainAddress
          AND (LOWER(c.identificationNumber) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(c.names) LIKE LOWER(CONCAT('%', :search, '%')))
    """)
	List<ClientEntity> findByIdentificationNumberContainingIgnoreCaseOrNamesContainingIgnoreCaseAndAddressesIsMainAddress(@Param("search") String search, @Param("isMainAddress")  Boolean isMainAddress);


	Optional<ClientEntity> findByIdentificationNumber(String identificationNumber);
	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllClient
	* @return List<ClientResponseRecord>>
	*/
	@Query(value="SELECT t FROM ClientEntity t")
	List<ClientEntity> findAllClient();

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findAllPaginateClient
	* @param search
		* parameter search
	* @param pageable
		* parameter pageable
	* @return Page<ClientEntity>
	*/
	@Query(value="""
	SELECT t FROM ClientEntity t
		WHERE (:search IS NULL OR (
			LOWER(t.identificationType) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.identificationNumber) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.names) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.email) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.cellPhone) LIKE LOWER(CONCAT('%', :search, '%')) OR
			CAST(t.createdAt AS string) LIKE CONCAT('%', :search, '%') )
			)
	""")
	Page<ClientEntity> findAllPaginateClient(@Param("search") String search, Pageable pageable);

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name findByIdClient
	* @param id
		* parameter input id
	* @return ClientEntity
	*/
	@Query(value="SELECT t FROM ClientEntity t WHERE t.id = :id")
	Optional<ClientEntity> findByIdClient(@Param("id") Integer id);

}
