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
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.outputs.command;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import java.util.List;
public interface AddressCommandRepository {

	/**
	*
	* Método que guarda los datos por id cliente de la dirección
	*
	* @name saveAddress
	* @param request
		* parameter input request
	* @return AddressResponseRecord
	*/
	AddressResponseRecord saveAddress(Integer id, AddressRequestRecord request);

	/**
	*
	* Método que actualiza los datos de la dirección
	*
	* @name updateAddress
	* @param request
		* parameter input request
	* @return AddressResponseRecord
	*/
	 AddressResponseRecord updateAddress(AddressRequestRecord request);

}
