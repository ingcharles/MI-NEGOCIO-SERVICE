package ec.gob.imark.catalogo;

import ec.gob.imark.catalogo.adapters.command.ClientCommandRepositoryImpl;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.services.query.ClientQueryServiceImpl;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:postgresql://localhost:5432/mybusinessdb",
    "spring.datasource.username=postgres",
    "spring.datasource.password=admin",
    "spring.datasource.driver-class-name=org.postgresql.Driver",
})
@Transactional
public class ClienteServiceIntegrationTest {

  @Autowired
  private ClientCommandRepositoryImpl clientCommandRepository;

  @Autowired
  private ClientQueryServiceImpl clientQueryService;

  // Caso 1: Buscar cliente por parámetro

  @BeforeEach
  void setUp() {
    AddressRequestRecord direccionPrincipal = AddressRequestRecord.builder()
        .province("Pichincha")
        .city("Quito")
        .address("Av. Amazonas N12-34")
        .isMainAddress(true)
        .build();

    AddressRequestRecord direccionSecundaria = AddressRequestRecord.builder()
        .province("Guayas")
        .city("Guayaquil")
        .address("Av. Francisco de Orellana")
        .isMainAddress(false)
        .build();

    ClientRequestRecord cliente1 = ClientRequestRecord.builder()
        .identificationType("CED")
        .identificationNumber("1712345678")
        .names("Juan Pérez López")
        .email("juan.perez@example.com")
        .cellPhone("0987654321")
        .address(direccionPrincipal)
        .build();

    ClientRequestRecord cliente2 = ClientRequestRecord.builder()
        .identificationType("RUC")
        .identificationNumber("1798765432101")
        .names("Empresa XYZ SA")
        .email("info@empresa.com")
        .cellPhone("0998765433")
        .address(direccionSecundaria)
        .build();

    clientCommandRepository.saveClient(cliente1);
    clientCommandRepository.saveClient(cliente2);


  }

  @Disabled("Desactivada temporalmente")
  @Test
  void buscarPorNombre_RetornaClientesCoincidentes() {
    String search = "Juan";

    List<ClientWithMainAddressResponseRecord> resultado = clientQueryService.searchClients(search);

    assertAll(
        () -> assertFalse(resultado.isEmpty(), "Debe encontrar al menos un cliente"),
        () -> assertEquals(1, resultado.size(), "Debe encontrar exactamente un cliente"),
        () -> assertTrue(resultado.getFirst().names().contains(search),
            "El nombre debe contener el texto buscado")
    );
  }

  @Disabled("Desactivada temporalmente")
  @Test
  void buscarPorNumeroIdentificacion_RetornaClienteExacto() {
    String searchTerm = "1712345678";

    List<ClientWithMainAddressResponseRecord> resultado = clientQueryService.searchClients(
        searchTerm);

    assertAll(
        () -> assertEquals(1, resultado.size(), "Debe encontrar exactamente un cliente"),
        () -> assertEquals(searchTerm, resultado.getFirst().identificationNumber(),
            "La número de identificacion debe contener el texto buscado"),
        () -> assertEquals("Juan Pérez López", resultado.getFirst().names())
    );
  }

  @Disabled("Desactivada temporalmente")
  @Test
  void buscarPorTextoInexistente_RetornaListaVacia() {
    String searchTerm = "Inexistente";

    List<ClientWithMainAddressResponseRecord> resultado = clientQueryService.searchClients(
        searchTerm);

    assertTrue(resultado.isEmpty(), "No debe encontrar clientes");
  }

  @Disabled("Desactivada temporalmente")
  @Test
  void buscarPorTextoVacio_RetornaClientesMainAddress() {
    List<ClientWithMainAddressResponseRecord> resultado = clientQueryService.searchClients(null);

    assertEquals(1, resultado.size(), "Debe retornar todos los clientes");
  }

}