package nl.example.data;

import lombok.Getter;
import nl.example.common.env.Environment;

public class AtlassianAccount {

    private static AtlassianAccount atlassianAccount;

    @Getter
    private final String emailAddress;
    @Getter
    private final String password;

    private AtlassianAccount() {
        Environment environment = Environment.getInstance();
        emailAddress = environment.getProperty("atlassianAccountEmail");
        password = environment.getProperty("atlassianAccountPassword");
    }

    public static AtlassianAccount getInstance() {
        if (atlassianAccount == null) {
            atlassianAccount = new AtlassianAccount();
        }
        return atlassianAccount;
    }

}
