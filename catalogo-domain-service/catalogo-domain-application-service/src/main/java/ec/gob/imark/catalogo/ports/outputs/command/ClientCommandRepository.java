/**
*
* Este archivo es la interfaz del repositorio: Client
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientRepository
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.command.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.ports.outputs.command;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import java.util.List;
public interface ClientCommandRepository {

	/**
	*
	* Método que obtiene los datos por id del cliente
	*
	* @name saveClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	ClientResponseRecord saveClient(ClientRequestRecord request);

	/**
	*
	* Método que actualiza los datos por id del cliente
	*
	* @name updateClient
	* @param request
		* parameter input request
	* @return ClientResponseRecord
	*/
	 ClientResponseRecord updateClient(ClientUpdateRequestRecord request);

	/**
	 *
	 * Método que elimina los datos por id del cliente
	 *
	 * @name deleteClient
	 * @param id
	 * parameter input request
	 * @return ClientResponseRecord
	 */
	ClientResponseRecord deleteClient(Integer id);

}
