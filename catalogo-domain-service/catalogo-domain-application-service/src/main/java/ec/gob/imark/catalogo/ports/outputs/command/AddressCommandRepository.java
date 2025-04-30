/**
*
* Este archivo es la interfaz del repositorio: Address
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressRepository
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.command.impl
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.outputs.command;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
public interface AddressCommandRepository {

	/**
	*
	* Método que guarda los datos de la dirección por id cliente
	 *
	 * @name saveAddressByIdClient
	 * @param id
	 * parameter Integer id
	 * @param request
	 * parameter AddressRequestRecord
	 * @return AddressResponseRecord
	 */
	AddressResponseRecord saveAddressByIdClient(Integer id, AddressRequestRecord request);

}
