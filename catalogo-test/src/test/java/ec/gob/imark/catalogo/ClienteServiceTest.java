package ec.gob.imark.catalogo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import ec.gob.imark.catalogo.services.query.ClientQueryServiceImpl;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

  @Mock
  private ClientQueryRepository clienteQueryRepository;

  @InjectMocks
  private ClientQueryServiceImpl clienteService;


  // Caso 1: Buscar cliente por parámetro
  @Disabled("Desactivada temporalmente")
  @Test
  void buscarPorNombrePorNumeroIdentificacion_RetornaClientesCoincidentes() {
    final String search = "Juan";
    final String expectedIdNumber = "1304049610";
    final String expectedName = "Juan";

    ClientWithMainAddressResponseRecord clientesMock = ClientWithMainAddressResponseRecord.builder()
        .id(1)
        .identificationType("RUC")
        .identificationNumber(expectedIdNumber)
        .names(expectedName)
        .email("juan@hotmail.com")
        .cellPhone("1234567890")
        .mainProvince("Pichincha")
        .mainCity("Quito")
        .mainAddress("Av. Esmeraldas")
        .createdAt(LocalDateTime.now())
        .build();

    Mockito.when(clienteQueryRepository.searchClients(Mockito.argThat(arg ->
        arg.equals(expectedName) || arg.equals(expectedIdNumber)
    ))).thenReturn(Collections.singletonList(clientesMock));

    // When
    List<ClientWithMainAddressResponseRecord> resultado = clienteService.searchClients(search);

    // Then
    assertFalse(resultado.isEmpty(), "Debería retornar al menos un resultado");
    assertEquals(1, resultado.size(), "Debería retornar exactamente un cliente");

    ClientWithMainAddressResponseRecord registro = resultado.getFirst();
    Assertions.assertAll(
        () -> assertEquals("Juan", registro.names()),
        () -> assertEquals("1304049610", registro.identificationNumber()),
        () -> assertEquals("juan@hotmail.com", registro.email()),
        () -> assertEquals("1234567890", registro.cellPhone()),
        () -> assertEquals("Pichincha", registro.mainProvince()),
        () -> assertEquals("Quito", registro.mainCity()),
        () -> assertEquals("Av. Esmeraldas", registro.mainAddress()),
        () -> assertNotNull(registro.createdAt())
    );

    Mockito.verify(clienteQueryRepository, times(1)).searchClients(search);
    Mockito.verifyNoMoreInteractions(clienteQueryRepository);
  }
}