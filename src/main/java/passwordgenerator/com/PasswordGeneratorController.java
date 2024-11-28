package passwordgenerator.com;


import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String generatePassword(@RequestBody PasswordCriteria passwordCriteria) {
        return passwordGeneratorService.createPassword(passwordCriteria);
    }
}
