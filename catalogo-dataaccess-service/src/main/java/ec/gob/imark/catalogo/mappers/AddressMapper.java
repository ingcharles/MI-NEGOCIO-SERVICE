/**
*
* Este archivo es la implementación del controlador: AddressMappers
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressMappers
* @package       core
* @subpackage   ec.gob.imark.catalogo.mappers.core
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/

package ec.gob.imark.catalogo.mappers;

import ec.gob.imark.catalogo.entities.AddressEntity;
import ec.gob.imark.catalogo.entities.ClientAddressEntity;
import ec.gob.imark.catalogo.mappers.core.GenericMapper;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper extends GenericMapper<AddressEntity , AddressResponseRecord> {
	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	AddressEntity requestRecordToEntity(AddressRequestRecord addressRequestRecord);

	@Override
	AddressResponseRecord entityToResponseRecord(AddressEntity addressEntity);

	@Mapping(source = "clientAddresses", target = "isMainAddress", qualifiedByName = "mainAddressMappingProvince")
	AddressResponseRecord entityToResponseClientRecord(AddressEntity addressEntity);

	@Named("mainAddressMappingProvince")
	default Boolean mapMainProvince(List<ClientAddressEntity> clientAddresses) {
		if (clientAddresses == null) {
			return null;
		}
		return clientAddresses.stream()
				//.filter(ClientAddressEntity::getIsMainAddress)
				.findFirst()
				.map(ClientAddressEntity::getIsMainAddress)
				.orElse(null);
	}
}
