package com.ApacheCamel.ApacheCamel.route;

import java.io.InputStream;
import java.util.Properties;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileLoaderRoute extends RouteBuilder {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(FileLoaderRoute.class);

    @Value("${profiles}")
    private String[] profiles;

    @Override
    public void configure() throws Exception {

        // Common Exception Handling
        errorHandler(deadLetterChannel("seda:ERROR_HANDLER_QUEUE"));

        Properties prop = new Properties();

        // Iterate through all the properties files
        for (String profile : profiles) {
            try (InputStream inf = this.getClass().getClassLoader().getResourceAsStream(profile + ".properties")) {
                if (inf == null) {
                    logger.error("Properties file not found: {}.properties", profile);
                    continue; // Skip this iteration if file not found
                }
                prop.load(inf);
            } catch (Exception e) {
                logger.error("Error loading properties from file: {}.properties - {}", profile, e.getMessage());
                System.exit(-1); // Consider a different error handling strategy in production
            }
        }

        // Ensure prop is not null and has the property
        String relativePath = prop.getProperty("IB_FILELOAD_INPUT");
        if (relativePath == null) {
            logger.error("IB_FILELOAD_INPUT property is missing in the properties files.");
            System.exit(-1); // Or handle it differently
        }

        from("timer:tick?period=1000") // Trigger every second
            .setBody(constant("Hello, Apache Camel!")) // Set the message to be printed
            .log("${body}"); // Print the message to the console
    }
}
