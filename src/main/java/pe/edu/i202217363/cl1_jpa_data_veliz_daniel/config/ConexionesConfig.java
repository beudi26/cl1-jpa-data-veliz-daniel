package pe.edu.i202217363.cl1_jpa_data_veliz_daniel.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String bdWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String bdWorldUser;
    @Value("${DB_WORLD_PASS}")
    private String bdWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String bdWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(bdWorldUrl);
        config.setUsername(bdWorldUser);
        config.setPassword(bdWorldPass);
        config.setDriverClassName(bdWorldDriver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000); //4 minutos en milisegundos
        config.setConnectionTimeout(45000); //45 segundos en milisegundos

        return new HikariDataSource(config);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatFactoryCustomizer(HikariDataSource hikariDataSource) {
        return factory -> factory.addContextCustomizers(context -> {
            try {
                Context initCtx = new InitialContext();
                initCtx.bind("java:comp/env/jdbc/World",hikariDataSource);
            }catch (NamingException e){
                e.printStackTrace();
            }
        });
    }
}
