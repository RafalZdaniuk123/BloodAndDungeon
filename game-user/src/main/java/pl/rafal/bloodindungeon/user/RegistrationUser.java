package pl.rafal.bloodindungeon.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUser {
    private String email;
    private String username;
    private String password;
    private CharacterClass characterClass;
}
