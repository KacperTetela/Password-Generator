package passwordgenerator.com.infrastructure;


import org.springframework.web.bind.annotation.*;
import passwordgenerator.com.password.PasswordCriteria;
import passwordgenerator.com.password.PasswordFactory;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordGeneratorController {

    private PasswordFactory passwordFactory;

    public PasswordGeneratorController(PasswordFactory passwordFactory) {
        this.passwordFactory = passwordFactory;
    }

    @PostMapping
    public String generatePassword(@RequestBody PasswordCriteria passwordCriteria) {
        return passwordFactory.createPassword(passwordCriteria);
    }
}
