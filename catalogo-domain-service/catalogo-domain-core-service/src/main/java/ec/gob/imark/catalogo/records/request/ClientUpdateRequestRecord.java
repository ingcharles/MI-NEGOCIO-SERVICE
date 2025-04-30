/**
 * Este archivo es el modelo para enviar los datos
 *
 * @copyright imark 06-04-2025
 * @author Carlos Anchundia
 * @version 1.0.0
 * @date 06-04-2025
 * @name ClientRequestRecord
 * @package catalogo-somain-services
 * @subpackage ec.gob.imark.catalogo.controller.query.impl
 * <p>
 * ------------- HISTORIAL DE CAMBIOS ------------
 * 1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
 * <!-- Añadir nuevas entradas de cambios aquí -->
 */
package ec.gob.imark.catalogo.records.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ClientUpdateRequestRecord(

		Integer id,

		@NotBlank(message = "El tipo de identificación es obligatorio")
		@Size(max = 10, message = "El campo no debe superar los 10 caracteres")
		String identificationType,

		@NotBlank(message = "El número de identificación es obligatorio")
		@Size(min = 10, message = "El número de identificación debe tener al menos 10 caracteres")
		@Size(max = 13, message = "El número de identificación debe tener como máximo 13 caracteres")
		String identificationNumber,

		@NotBlank(message = "El nombre del cliente es obligatorio")
		@Size(max = 255, message = "El campo no debe superar los 255 caracteres")
		String names,

		@NotBlank(message = "El correo electrónico es obligatorio")
		@Email(message = "El correo electrónico debe tener un formato válido")
		@Size(max = 100, message = "El correo electrónico no debe superar los 100 caracteres")
		String email,

		@Pattern(regexp = "\\d{10}", message = "El número de celular debe tener máximo 10 dígitos")
		String cellPhone,

		LocalDateTime createdAt,

		LocalDateTime updatedAt
) implements Serializable {

}
