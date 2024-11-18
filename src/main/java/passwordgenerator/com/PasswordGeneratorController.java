package passwordgenerator.com;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordGeneratorController {

    private PasswordGeneratorService passwordGeneratorService;

    public PasswordGeneratorController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @GetMapping
    public String get() {
        return "Hello World";
    }

    public String generatePassword(@RequestBody PasswordCriteria passwordCriteria) {
        return passwordGeneratorService.createPassword(passwordCriteria);
    }
}
