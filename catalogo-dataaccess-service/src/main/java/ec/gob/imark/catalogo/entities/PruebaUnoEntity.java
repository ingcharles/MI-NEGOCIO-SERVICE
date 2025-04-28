/**
*
* Este archivo es modelo de la tabla: PruebaUno
*
* @copyright     imark 08-05-2024
* @author        Carlos Anchundia
* @version       1.0.0
* @date          08-05-2024
* @name          PruebaUnoEntity
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 08-05-2024
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prueba_uno", schema = "esq_catalogo")
@Entity
public class PruebaUnoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_uno", nullable = false)
	private Integer idUno;
	
	@NotBlank(message = "{pruebauno.nombreUno.not_blank}")
	@Size(max = 128, message = "{pruebauno.nombreUno.size}")
	@Column(name = "nombre_uno", nullable = false)
	private String nombreUno;
	
	@NotNull(message = "{pruebauno.fechaUno.not_null}")
	@Column(name = "fecha_uno", nullable = false)
	private LocalDateTime fechaUno;
	
	@NotNull(message = "{pruebauno.estadoUno.not_null}")
	@Column(name = "estado_uno", nullable = false)
	private Boolean estadoUno;

	@NotNull(message = "{pruebauno.enteroUno.not_null}")
	@Column(name = "entero_uno", nullable = false)
	private Integer enteroUno;
	
	@NotNull(message = "{pruebauno.decimalUno.not_null}")
	@DecimalMax(value = "999999999.99", message = "{pruebauno.decimalUno.max, El valor debe ser mayor o igual a 999999999.99 }")
	@Column(name = "decimal_uno", nullable = false)
	private Double decimalUno;

	@NotNull(message = "{pruebauno.itemUno.not_null}")
	@Column(name = "item_uno", nullable = false)
	private Integer itemUno;
	
	@Size(max = 500, message = "{pruebauno.nombreLargoUno.size}")
	@Column(name = "nombre_largo_uno")
	private String nombreLargoUno;

	@Override
	public int hashCode()
	{
		return Objects.hash(idUno);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PruebaUnoEntity that = (PruebaUnoEntity) o;
		return idUno.equals(that.idUno);
	}

}
