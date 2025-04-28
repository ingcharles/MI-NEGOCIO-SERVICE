package ec.gob.imark.catalogo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
  private static final String GROUP_QUERY = "query-services";
  private static final String API_RULES_QUERY = "/query/**";
  private static final String GROUP_COMMAND = "command-services";
  private static final String API_RULES_COMMAND = "/command/**";

  @Bean
  public GroupedOpenApi queryApi() {
    return GroupedOpenApi.builder()
            .group(GROUP_QUERY)
            .pathsToMatch(API_RULES_QUERY)
            .build();
  }

  @Bean
  public GroupedOpenApi commandApi() {
    return GroupedOpenApi.builder()
            .group(GROUP_COMMAND)
            .pathsToMatch(API_RULES_COMMAND)
            .build();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Mi negocio microservicio")
            .version("1.0.0")
            .description("API Rest para lo manipulación de datos de la base datos clientes y direcciónes. "));
  }
}
