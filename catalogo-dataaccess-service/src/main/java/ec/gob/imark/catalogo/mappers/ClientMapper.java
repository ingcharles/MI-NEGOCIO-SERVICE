/**
*
* Este archivo es la implementación del controlador: ClientMappers
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientMappers
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
import ec.gob.imark.catalogo.entities.ClientEntity;
import ec.gob.imark.catalogo.mappers.core.GenericMapper;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientUpdateRequestRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface ClientMapper extends GenericMapper<ClientEntity , ClientResponseRecord> {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	ClientEntity requestRecordToEntity(ClientRequestRecord clientRequestRecord);

	ClientEntity requestUpdateRecordToEntity(ClientUpdateRequestRecord clientUpdateRequestRecord);

	ClientEntity responseRecordToEntity(ClientResponseRecord clientResponseRecord);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "identificationType", target = "identificationType")
	@Mapping(source = "identificationNumber", target = "identificationNumber")
	@Mapping(source = "names", target = "names")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "cellPhone", target = "cellPhone")
	@Mapping(source = ".", target = "mainProvince", qualifiedByName = "mainAddressMappingProvince")
	@Mapping(source = ".", target = "mainCity", qualifiedByName = "mainAddressMappingCity")
	@Mapping(source = ".", target = "mainAddress", qualifiedByName = "mainAddressMappingAddress")
	@Mapping(source = "createdAt", target = "createdAt")
	@Mapping(source = "updatedAt", target = "updatedAt")
	ClientWithMainAddressResponseRecord entityToResponseWithMainAddressRecord(ClientEntity clientEntity);

	@Override
	ClientResponseRecord entityToResponseRecord(ClientEntity clientEntity);

	ClientRequestRecord entityToRequestRecord(ClientEntity clientEntity);


	@Named("mainAddressMappingProvince")
	default String mapMainProvince(ClientEntity client) {
		if (client.getClientAddresses() == null) return null;
		return client.getClientAddresses().stream()
				.filter(ClientAddressEntity::getIsMainAddress)
				.findFirst()
				.map(ca -> ca.getAddress().getProvince())
				.orElse(null);
	}

	@Named("mainAddressMappingCity")
	default String mapMainCity(ClientEntity client) {
		if (client.getClientAddresses() == null) return null;
		return client.getClientAddresses().stream()
				.filter(ClientAddressEntity::getIsMainAddress)
				.findFirst()
				.map(ca -> ca.getAddress().getCity())
				.orElse(null);
	}

	@Named("mainAddressMappingAddress")
	default String mapMainStreetAddress(ClientEntity client) {
		if (client.getClientAddresses() == null) return null;
		return client.getClientAddresses().stream()
				.filter(ClientAddressEntity::getIsMainAddress)
				.findFirst()
				.map(ca -> ca.getAddress().getAddress())
				.orElse(null);
	}
}
