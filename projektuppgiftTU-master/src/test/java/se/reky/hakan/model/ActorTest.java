package se.reky.hakan.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    Actor actor;
    Player player  = new Player("Kalle", 10, 7);
    Goblin goblin = new Goblin("Goblin", 20, 3);

    @DisplayName("")
    @Test
    public void testAttack() {

        player.attack(goblin);
        assertEquals(13, goblin.getHp());
    }

}
