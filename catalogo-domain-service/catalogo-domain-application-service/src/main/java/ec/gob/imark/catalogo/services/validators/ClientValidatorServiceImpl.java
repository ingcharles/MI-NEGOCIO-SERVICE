package ec.gob.imark.catalogo.services.validators;

import ec.gob.imark.catalogo.exceptions.ClientException;
import ec.gob.imark.catalogo.ports.inputs.validators.ClientValidationService;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientValidatorServiceImpl implements ClientValidationService {

  private final ClientQueryRepository clientQueryRepository;

  /**
   *
   * * Método que validad si un cliente existe
   *
   * @name validateClientExists
   * @param id
   * parameter Integer id
   * @return ClientResponseRecord
   */
  public ClientResponseRecord validateClientExists(Integer id) {
    return clientQueryRepository.findById(id)
        .orElseThrow(() -> new ClientException(String.format("Cliente no encontrado con Id: %s", id)));
  }

  /**
   *
   * * Método que valida si existe un cliente por numero de identificación
   *
   * @name validateIdentificationNumberSave
   * @param identificationNumber
   * parameter String identificationNumber
   */
  public boolean validateIdentificationNumberSave(String identificationNumber) {
    Optional<ClientResponseRecord> result = clientQueryRepository.findByIdentificationNumber(identificationNumber);
    result.ifPresent(_ -> {
      throw new ClientException(String.format("Cliente con número de identificación ya existe: %s", identificationNumber));
    });
    return true;
  }

  /**
   *
   * * Método que valida si al actualizar un cliente cambia de número de identificación
   *
   * @name validateIdentificationNumberUpdate
   * @param id
   * parameter Integer id
   * @param identificationNumber
   * parameter String identificationNumber
   */
  public boolean validateIdentificationNumberUpdate(Integer id, String identificationNumber) {
    clientQueryRepository.findByIdentificationNumber(identificationNumber)
            .filter(c -> !c.id().equals(id))
            .ifPresent(c -> {
              throw new ClientException("Cliente con número de identificación ya está en uso: " + identificationNumber);
            });
    return true;
  }

}
