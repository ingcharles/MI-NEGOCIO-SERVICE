/**
*
* Este archivo es la implementación del controlador: PruebaUnoJpaRepository
*
* @copyright     imark 08-05-2024
* @author        Carlos Anchundia
* @version       1.0.0
* @date          08-05-2024
* @name          PruebaUnoJpaRepository
* @package       catalogo-dataaccess-services
* @subpackage    ec.gob.imark.catalogo.controller.query.impl
*
* HISTORIAL DE CAMBIOS
*    1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 08-05-2024
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.repositories;

import ec.gob.imark.catalogo.entities.PruebaUnoEntity;
import ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord;
import ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord;
import ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaUnoJpaRepository extends JpaRepository<PruebaUnoEntity, Integer> {

	/**
	*
	* Método que obtiene los datos por id de la tabla prueba_uno
	*
	* @name findAllPruebaUno
	* @param 
	* @return List<PruebaUnoResponseRecord>>
	*/
	@Query(value="SELECT new ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord(t.idUno,t.nombreUno,t.fechaUno,t.estadoUno,t.enteroUno,t.decimalUno,t.itemUno,t.nombreLargoUno) FROM PruebaUnoEntity t")
	Optional<List<PruebaUnoResponseRecord>> findAllPruebaUno();

	/**
	*
	* Método que obtiene los datos por id de la tabla prueba_uno
	*
	* @name findAllPaginatePruebaUno
	* @param search
	* @param pageable
	* @return Page<PruebaUnoResponseRecord>
	*/
	@Query(value="""
	SELECT new ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord(t.idUno,t.nombreUno,t.fechaUno,t.estadoUno,t.enteroUno,t.decimalUno,t.itemUno,t.nombreLargoUno)
		FROM PruebaUnoEntity t 
		WHERE (:search IS NULL OR (
			LOWER(t.nombreUno) LIKE LOWER(CONCAT('%', :search, '%')) OR
			CAST(t.fechaUno AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.estadoUno AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.enteroUno AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.decimalUno AS string) LIKE CONCAT('%', :search, '%') OR
			CAST(t.itemUno AS string) LIKE CONCAT('%', :search, '%') OR
			LOWER(t.nombreLargoUno) LIKE LOWER(CONCAT('%', :search, '%')) )
			)
	""")
	Page<PruebaUnoResponseRecord> findAllPaginatePruebaUno(@Param("search") String search, Pageable pageable);

	/**
	*
	* Método que obtiene los datos por id de la tabla prueba_uno
	*
	* @name findByIdPruebaUno
	* @param idUno
	* @return PruebaUnoResponseRecord
	*/
	@Query(value="SELECT new ec.gob.imark.catalogo.records.response.PruebaUnoResponseRecord(t.idUno,t.nombreUno,t.fechaUno,t.estadoUno,t.enteroUno,t.decimalUno,t.itemUno,t.nombreLargoUno) FROM PruebaUnoEntity t WHERE t.idUno = :idUno")
	PruebaUnoResponseRecord findByIdPruebaUno(@Param("idUno") Integer idUno);

}
