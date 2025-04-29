package ec.gob.catalogo.imark;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ec.gob.imark.catalogo.entities.ClientEntity;
import ec.gob.imark.catalogo.repositories.ClientJpaRepository;
import ec.gob.imark.catalogo.services.query.ClientQueryServiceImpl;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {ClientQueryServiceImpl.class})//, ClientJpaRepository.class
@SpringBootTest
public class ClienteServiceIntegrationTest {
  //@Autowired
  //private ClientJpaRepository clientRepository;

  @Autowired
  private ClientQueryServiceImpl clientQueryService;

  /*@BeforeEach
  void setUp() {
    // Insertamos datos de prueba reales
    clientRepository.save(new ClientEntity(
        null,
        "RUC",
        "1304049610",
        "Juan Hidalgo",
        "juan@hotmail.com",
        "1234567890",
        "Pichincha",
        "Quito",
        "Av. Esmeraldas"
    ));
  }*/

  @Test
  void buscarClientesPorNombreONumeroIdentificacionDebeRetornarCoincidencias() {
    String search = "Hid"; // Parte del apellido

    List<ClientWithMainAddressResponseRecord> resultado = clientQueryService.searchClients(search);

    assertFalse(resultado.isEmpty(), "Debe encontrar al menos un cliente con 'Hid'");
    assertTrue(resultado.get(0).names().contains("Hid"));
  }
}