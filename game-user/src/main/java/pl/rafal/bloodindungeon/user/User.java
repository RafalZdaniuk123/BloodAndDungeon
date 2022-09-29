package pl.rafal.bloodindungeon.user;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
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
