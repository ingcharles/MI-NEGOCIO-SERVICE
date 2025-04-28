/**
*
* Este archivo es la implementación del controlador: ClientAddressCommandService
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressCommandService
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.command.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.inputs.command;

import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
public interface ClientAddressCommandService {

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name saveClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	ClientAddressResponseRecord saveClientAddress(ClientAddressRequestRecord request);

	/**
	*
	* Método que obtiene los datos por id del cliente_address
	*
	* @name updateClientAddress
	* @param request
		* parameter input request
	* @return ClientAddressResponseRecord
	*/
	ClientAddressResponseRecord updateClientAddress(ClientAddressRequestRecord request);

}
