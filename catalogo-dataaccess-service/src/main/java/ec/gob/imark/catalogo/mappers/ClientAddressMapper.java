/**
*
* Este archivo es la implementación del controlador: ClientAddressMappers
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientAddressMappers
* @package       core
* @subpackage   ec.gob.imark.catalogo.mappers.core
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/

package ec.gob.imark.catalogo.mappers;

import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.mappers.core.GenericMapper;
import ec.gob.imark.catalogo.records.request.ClientAddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientAddressResponseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClientMapper.class, AddressMapper.class})
public interface ClientAddressMapper extends GenericMapper<ClientAddressEntity , ClientAddressResponseRecord> {
	ClientAddressMapper INSTANCE = Mappers.getMapper(ClientAddressMapper.class);

	@Mapping(source = "clientId", target = "client")
	@Mapping(source = "addressId", target = "address")
	@Mapping(source = "isMainAddress", target = "isMainAddress")
	ClientAddressEntity requestRecordToEntity(ClientAddressRequestRecord clientAddressRequestRecord);

	@Override
	ClientAddressResponseRecord entityToResponseRecord(ClientAddressEntity clientAddressEntity);

	@Mapping(source = "address.province", target = "province")
	@Mapping(source = "address.city", target = "city")
	@Mapping(source = "address.address", target = "address")
	@Mapping(source = "isMainAddress", target = "isMainAddress")
	AddressResponseRecord entityToResponseClientRecord(ClientAddressEntity clientAddressEntity);


}
