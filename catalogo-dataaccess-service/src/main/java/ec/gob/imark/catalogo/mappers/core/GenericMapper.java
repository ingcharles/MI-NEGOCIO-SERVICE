/**
 * Proyecto 02-EJEMPLO-JAVA-MICROSERVICIO.
 *
 * <p>Clase GenericMapper 3/6/2024.
 *
 * <p>Copyright 2024 Consejo de la Judicatura.
 *
 * <p>Todos los derechos reservados.
 */
package ec.gob.imark.catalogo.mappers.core;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA INTERFACE --.
 *
 * <p>
 * Historial de cambios:
 *
 * <ul>
 * <li> 1.0.0 - Descripción del cambio inicial - Carlos.Anchundia - 3/6/2024
 * <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Carlos.Anchundia
 * @version 1.0.0
 * @since 3/6/2024
 */
public interface GenericMapper<E, R> {

  R entityToResponseRecord(E entity);

  R recordPageToRecordPage(R recordPage);

}
