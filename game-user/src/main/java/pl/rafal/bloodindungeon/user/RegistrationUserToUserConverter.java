package pl.rafal.bloodindungeon.user;

import java.util.UUID;

public class RegistrationUserToUserConverter {
    public static User convert(RegistrationUser registrationUser){
        return User.builder()
                .username(registrationUser.getUsername())
                .password(registrationUser.getPassword())
                .intelligence(1)
                .hp(100)
                .defence(1)
                .Exp(100)
                .userBalance(Double.valueOf(100))
                .userLvl(1)
                .attack(10)
                .characterClass(registrationUser.getCharacterClass())
                .build();

    }
}
