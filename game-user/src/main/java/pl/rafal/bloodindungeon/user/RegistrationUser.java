package pl.rafal.bloodindungeon.user;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUser {
    private String username;
    private String password;
    private CharacterClass characterClass;
}
