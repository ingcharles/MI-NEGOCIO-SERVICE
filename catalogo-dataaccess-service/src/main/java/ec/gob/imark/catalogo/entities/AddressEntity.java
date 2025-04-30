/**
*
* Este archivo es modelo de la tabla: Address
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          AddressEntity
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- ¡HISTORIAL DE CAMBIOS ------------
*          1.0.0 - Descripción del cambio inicial - Carlos Anchundia - 06-04-2025
*    <!-- Añadir nuevas entradas de cambios aquí -->
*
*/
package ec.gob.imark.catalogo.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
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
@Table(name = "address", schema = "clients")

@Entity
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotBlank(message = "{address.province.not_blank}")
	@Size(max = 100, message = "{address.province.size}")
	@Column(name = "province", nullable = false)
	private String province;
	
	@NotBlank(message = "{address.city.not_blank}")
	@Size(max = 100, message = "{address.city.size}")
	@Column(name = "city", nullable = false)
	private String city;
	
	@NotBlank(message = "{address.address.not_blank}")
	@Size(max = 255, message = "{address.address.size}")
	@Column(name = "address", nullable = false)
	private String address;

	@NotNull(message = "{address.createdAt.not_null}")
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ClientAddressEntity> clientAddresses;

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
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
		AddressEntity that = (AddressEntity) o;
		return id.equals(that.id);
	}

}
