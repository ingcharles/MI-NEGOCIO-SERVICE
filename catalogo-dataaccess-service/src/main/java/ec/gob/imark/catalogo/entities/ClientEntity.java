/**
*
* Este archivo es modelo de la tabla: Client
*
* @copyright     imark 06-04-2025
* @author        Carlos Anchundia
* @version       1.0.0
* @date          06-04-2025
* @name          ClientEntity
* @package       catalogo-domain-services
* @subpackage   ec.gob.imark.catalogo.controller.query.impl
*
*    ------------- HISTORIAL DE CAMBIOS ------------
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
@Table(name = "client", schema = "clients")
@Entity
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotBlank(message = "{client.identificationType.not_blank}")
	@Size(max = 10, message = "{client.identificationType.size}")
	@Column(name = "identification_type", nullable = false)
	private String identificationType;
	
	@NotBlank(message = "{client.identificationNumber.not_blank}")
	@Size(max = 20, message = "{client.identificationNumber.size}")
	@Column(name = "identification_number", nullable = false)
	private String identificationNumber;
	
	@NotBlank(message = "{client.fullName.not_blank}")
	@Size(max = 255, message = "{client.fullName.size}")
	@Column(name = "names", nullable = false)
	private String names;
	
	@NotBlank(message = "{client.email.not_blank}")
	@Size(max = 100, message = "{client.email.size}")
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotBlank(message = "{client.mobileNumber.not_blank}")
	@Size(max = 20, message = "{client.mobileNumber.size}")
	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;

	@NotNull(message = "{client.createdAt.not_null}")
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
		ClientEntity that = (ClientEntity) o;
		return id.equals(that.id);
	}


}
