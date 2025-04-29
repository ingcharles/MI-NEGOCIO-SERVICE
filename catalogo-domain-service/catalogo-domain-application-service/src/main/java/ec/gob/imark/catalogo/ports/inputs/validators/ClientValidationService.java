package ec.gob.imark.catalogo.ports.inputs.validators;

import ec.gob.imark.catalogo.records.response.ClientResponseRecord;

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
  void validateIdentificationNumberSave(String identificationNumber);

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
  void validateIdentificationNumberUpdate(Integer id, String identificationNumber);

}
