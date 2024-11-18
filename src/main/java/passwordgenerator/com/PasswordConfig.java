package passwordgenerator.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordConfig {

    @Bean
    public Map<String, PasswordGenerator> passwordGenerators() {
        Map<String, PasswordGenerator> generators = new HashMap<>();
        generators.put("simple", new SimplePasswordGenerator());
        generators.put("complex", new ComplexPasswordGenerator());
        return generators;
    }

    @Bean
    public PasswordFactory passwordFactory(Map<String, PasswordGenerator> generators) {
        return new PasswordFactory(generators);
    }

    @Bean
    public PasswordGeneratorService passwordService(PasswordFactory passwordFactory) {
        return new PasswordGeneratorService(passwordFactory);
    }

}
