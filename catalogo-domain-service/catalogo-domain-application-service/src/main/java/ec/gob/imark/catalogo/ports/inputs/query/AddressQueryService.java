/**
*
* Este archivo es la implementación del controlador: AddressQueryService
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressQueryService
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.inputs.query;

import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import java.util.List;

public interface AddressQueryService {

	/**
	*
	* Método que obtiene los datosde las direcciónes por id cliente
	*
	* @name findAllAddress
	* @return List<AddressResponseRecord>
	*/
	List<AddressResponseRecord> findAllAddress(Integer id);

}
