package pl.rafal.bloodindungeon.user;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private CharacterClass characterClass;
    private int userLvl;
    private Double userBalance;
    private int Exp;
    private int hp;
    private int attack;
    private int defence;
    private int intelligence;

}
