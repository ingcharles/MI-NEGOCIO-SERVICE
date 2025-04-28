/**
*
* Este archivo es la implementación del controlador: AddressJpaRepository
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressJpaRepository
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.AddressEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Integer> {


	/**
	*
	* Método que obtiene los datosde las direcciónes por id cliente
	*
	* @name findAllAddress
	* @return List<AddressResponseRecord>>
	*/
	@Query(value="SELECT t FROM AddressEntity t")
	List<AddressEntity> findAllAddress();

	/**
	*
	* Método que obtiene los datosde las direcciónes por id cliente
	*
	* @name findAllPaginateAddress
	* @param search
		* parameter search
	* @param pageable
		* parameter pageable
	* @return Page<AddressEntity>
	*/
	@Query(value="""
	SELECT t FROM AddressEntity t
		WHERE (:search IS NULL OR (
			LOWER(t.province) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.city) LIKE LOWER(CONCAT('%', :search, '%')) OR
			LOWER(t.address) LIKE LOWER(CONCAT('%', :search, '%')) OR
			CAST(t.createdAt AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.updatedAt AS string) LIKE CONCAT('%', :search, '%') )
			)
	""")
	Page<AddressEntity> findAllPaginateAddress(@Param("search") String search, Pageable pageable);

	/**
	*
	* Método que obtiene los datosde las direcciónes por id cliente
	*
	* @name findByIdAddress
	* @param id
		* parameter input id
	* @return AddressEntity
	*/
	@Query(value="SELECT t FROM AddressEntity t WHERE t.id = :id")
	Optional<AddressEntity> findByIdAddress(@Param("id") Integer id);

}
