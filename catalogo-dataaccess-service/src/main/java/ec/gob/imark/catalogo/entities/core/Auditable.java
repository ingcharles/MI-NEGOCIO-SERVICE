/**
 * Proyecto 02-EJEMPLO-JAVA-MICROSERVICIO.
 *
 * <p>Clase Auditable 4/6/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.imark.catalogo.entities.core;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA INTERFACE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 4/6/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0
 * @since 4/6/2024
 */
public interface Auditable<P> extends Dated {
  void setIdPersonaCrea(P idPersonaCrea);

  P getIdPersonaModifica();

  void setIdPersonaModifica(P idPersonaModifica);

  String getIpCrea();

  void setIpCrea(String ipCrea);

  String getIpModifica();

  void setIpModifica(String ipModifica);

  String getEquipoModifica();

  void setEquipoModifica(String equipoModifica);

  String getEquipoCrea();

  void setEquipoCrea(String equipoCrea);

  String getMotivoModifica();

  void setMotivoModifica(String motivoModifica);
}
