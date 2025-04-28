/**
 * Proyecto catalogo-consulta-causas-clex.<br> Clase MessageSourceUtil 4/2/2024.<br> Copyright 2024
 * Consejo de la Judicatura.<br> Todos los derechos reservados.
 */

package ec.gob.imark.catalogo.messages;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - Francisco.Zabala - 4/2/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author Francisco.Zabala
 * @version 1.0.0 $
 * @since 4/2/2024
 */
@Component
@RequiredArgsConstructor
public class MessageSourceUtil {

  private final MessageSource messageSource;

  public String getMessage(String key) {
    Locale currentLocale = LocaleContextHolder.getLocale();
    return messageSource.getMessage(key, null, currentLocale);
  }
}
