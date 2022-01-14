package br.com.pubfuture.finances.core;

import br.com.pubfuture.finances.Application;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

//import br.com.pubfuture.finances.api.ApiClient;

@ActiveProfiles(profiles = "integration-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public abstract class BaseIntegrationTest {
    @Autowired
    private Flyway flyway;

    @LocalServerPort
    private int serverPort;

    @BeforeEach
    void setup() {
        setupFlyway();
        setupEach();
    }

    private void setupEach() {}

    //    protected void setLocalHostBasePath(ApiClient apiClient, String path) throws MalformedURLException {
    //        apiClient.setBasePath(new URL("http", "localhost", serverPort, path).toString());
    //    }

    private void setupFlyway() {
        flyway.clean();
        flyway.migrate();
    }
}
