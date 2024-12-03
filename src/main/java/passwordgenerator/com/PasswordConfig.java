package passwordgenerator.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordConfig {

    @Bean
    public Map<PasswordNameStrategy, PasswordGenerator> passwordGenerators() {
        Map<PasswordNameStrategy, PasswordGenerator> generators = new HashMap<>();
        generators.put(PasswordNameStrategy.SIMPLE, new SimplePasswordGenerator());
        generators.put(PasswordNameStrategy.COMPLEX, new ComplexPasswordGenerator());
        return generators;
    }

    @Bean
    public PasswordFactory passwordFactory(Map<PasswordNameStrategy, PasswordGenerator> generators) {
        return new PasswordFactory(generators);
    }

}
