/**
 * Proyecto 02-EJEMPLO-JAVA-MICROSERVICIO.
 *
 * <p>Clase Dated 4/6/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.imark.catalogo.entities.core;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public interface Dated extends Serializable {
  LocalDateTime getFechaCrea();

  void setFechaCrea(LocalDateTime fechaCrea);

  LocalDateTime getFechaModifica();

  void setFechaModifica(LocalDateTime fechaModifica);
}

