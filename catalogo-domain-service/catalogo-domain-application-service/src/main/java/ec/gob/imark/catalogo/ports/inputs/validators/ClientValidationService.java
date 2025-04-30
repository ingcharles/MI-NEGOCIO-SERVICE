package ec.gob.imark.catalogo.ports.inputs.validators;

import ec.gob.imark.catalogo.records.response.ClientResponseRecord;

import java.util.Optional;

public interface ClientValidationService {

  /**
   *
   * * Método que validad si un cliente existe
   *
   * @name validateClientExists
   * @param id
   * parameter Integer id
   * @return ClientResponseRecord
   */
  ClientResponseRecord validateClientExists(Integer id);

  /**
   *
   * * Método que valida si existe un cliente por número de identificación
   *
   * @name validateIdentificationNumberSave
   * @param identificationNumber
   * parameter String identificationNumber
   */
  boolean validateIdentificationNumberSave(String identificationNumber);

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
  boolean validateIdentificationNumberUpdate(Integer id, String identificationNumber);

}
