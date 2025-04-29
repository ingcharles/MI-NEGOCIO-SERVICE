package ec.gob.catalogo.imark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static reactor.core.publisher.Mono.when;

import ec.gob.imark.catalogo.adapters.query.ClientQueryRepositoryImpl;
import ec.gob.imark.catalogo.exceptions.ClientException;
import ec.gob.imark.catalogo.ports.inputs.query.ClientQueryService;
import ec.gob.imark.catalogo.ports.outputs.command.ClientCommandRepository;
import ec.gob.imark.catalogo.ports.outputs.query.ClientQueryRepository;
import ec.gob.imark.catalogo.records.request.AddressRequestRecord;
import ec.gob.imark.catalogo.records.request.ClientRequestRecord;
import ec.gob.imark.catalogo.records.response.AddressResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientResponseRecord;
import ec.gob.imark.catalogo.records.response.ClientWithMainAddressResponseRecord;
import ec.gob.imark.catalogo.services.query.ClientQueryServiceImpl;
import ec.gob.imark.catalogo.services.validators.ClientValidatorServiceImpl;
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

  @Mock
  private ClientCommandRepository clientCommandRepository;

  @InjectMocks
  private ClientQueryServiceImpl clienteService;

  @InjectMocks
  private ClientValidatorServiceImpl clientValidatorService;

  // Caso 1: Buscar cliente por parámetro
  @Disabled("Desactivada temporalmente por refactor")
  @Test
  void buscarClientesPorNombreONumeroIdentificacion() {
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

    // Configuración del mock con condiciones claras
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


  // Caso 2: Crear cliente con dirección matriz
  @Test
  void testCrearClienteConDireccionMatriz() {

    String identificationNumber = "1304049610w";
    AddressRequestRecord addressMock = AddressRequestRecord.builder()
        .province("Pichincha").build();

    ClientRequestRecord clientMock = ClientRequestRecord.builder()
        .identificationType("RUC")
        .identificationNumber(identificationNumber)
        .names("Juan")
        .email("juan@hotmail.com")
        .cellPhone("1234567890")
        .address(addressMock)
        .createdAt(LocalDateTime.now())
        .build();

    /*clienteQueryRepository.findByIdentificationNumber(identificationNumber);
    when(clienteQueryRepository.findByIdentificationNumber(identificationNumber))
        .thenReturn(true);*/

    ClientException exception = assertThrows(ClientException.class, () ->
        clientValidatorService.validateIdentificationNumberSave(identificationNumber));

    // When / Then
    //ClientException exception = assertThrows(ClientException.class, () ->
     //   clientValidatorService.validateIdentificationNumberSave(identificationNumber));
    //assertEquals("Cliente con número de identificación ya existe: 1234567890", exception.getMessage());

    //ClientResponseRecord result = clientCommandRepository.saveClient(clientMock);
    assertEquals("Cliente con número de identificación ya existe: 1234567890", exception.getMessage());
    // Then
    //assertNotNull(result);
    //assertEquals("Pedro", result.names());
    //assertEquals("1234567891", result.identificationNumber());

    //Mockito.verify(clientCommandRepository, times(1)).saveClient(clientMock);


    /*
        // Simular que ya existe un cliente con ese número
    when(clientQueryRepository.existsByIdentificationNumber(identificationNumber))
        .thenReturn(true);

    // Validar que la excepción se lanza
    ClientException exception = assertThrows(ClientException.class, () ->
        clientValidatorService.validateIdentificationNumberSave(identificationNumber));

    assertEquals("Cliente con número de identificación ya existe: 1234567890", exception.getMessage());
     */
  }

}

/*
@Test
void testCrearClienteConDireccionMatriz_DeberiaLanzarExcepcionCuandoClienteExiste() {
    // Given - Configuración que debe fallar
    ClientRequestRecord request = ClientRequestRecord.builder()
        .identificationNumber("1234567890")  // Un ID que ya existe
        .build();

    // Simula que el cliente ya existe
    Mockito.when(clienteRepository.existeClientePorIdentificacion("1234567890"))
           .thenReturn(true);

    // When/Then - Verifica que se lance la excepción
    ClientException exception = assertThrows(ClientException.class, () -> {
        clienteService.crearClienteConDireccionMatriz(request);
    });

    assertEquals("El cliente con ID 1234567890 ya existe", exception.getMessage());

    // Opcional: verifica interacciones con mocks
    Mockito.verify(clienteRepository).existeClientePorIdentificacion("1234567890");
}
 */