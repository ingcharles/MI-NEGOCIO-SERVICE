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
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.ClientAddressEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressJpaRepository extends JpaRepository<ClientAddressEntity, Integer> {

	List<ClientAddressEntity> findByClientId(Integer id);

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllClientAddress
	* @return List<ClientAddressResponseRecord>>
	*/
	@Query(value="SELECT t FROM ClientAddressEntity t")
	List<ClientAddressEntity> findAllClientAddress();

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findAllPaginateClientAddress
	* @param search
		* parameter search
	* @param pageable
		* parameter pageable
	* @return Page<ClientAddressEntity>
	*/
	@Query(value="""
	SELECT t FROM ClientAddressEntity t
		WHERE (:search IS NULL OR (
			CAST(t.client.id AS string) LIKE CONCAT('%', :search, '%') OR
			LOWER(t.address.province) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.address.city) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.address.address) LIKE LOWER(CONCAT('%', :search, '%')) OR
			CAST(t.isMainAddress AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.createdAt AS string) LIKE CONCAT('%', :search, '%') )
			)
	""")
	Page<ClientAddressEntity> findAllPaginateClientAddress(@Param("search") String search, Pageable pageable);

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name findByIdClientAddress
	* @param id
		* parameter input id
	* @return ClientAddressEntity
	*/
	@Query(value="SELECT t FROM ClientAddressEntity t WHERE t.id = :id")
	Optional<ClientAddressEntity> findByIdClientAddress(@Param("id") Integer id);

}
