package passwordgenerator.com;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordGeneratorController {

    private PasswordFactory passwordFactory;

    public PasswordGeneratorController(PasswordFactory passwordFactory) {
        this.passwordFactory = passwordFactory;
    }

    @GetMapping
    public String get() {
        return "Hello World";
    }

    @PostMapping
    public String generatePassword(@RequestBody PasswordCriteria passwordCriteria) {
        PasswordNameStrategy strategy = switch (passwordCriteria.strategy().toString()) {
            case "SIMPLE" -> PasswordNameStrategy.SIMPLE;
            case "COMPLEX" -> PasswordNameStrategy.COMPLEX;
            case "SOUNDS_LIKE" -> PasswordNameStrategy.SOUNDS_LIKE;
            default -> throw new IllegalArgumentException("Invalid strategy: " + passwordCriteria.strategy());
        };

        return passwordFactory.createPassword(strategy,
                passwordCriteria.length(),
                passwordCriteria.uppercase(),
                passwordCriteria.digits(),
                passwordCriteria.special());
    }
}
