package se.reky.hakan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimplePlayerInteractionTest {

    private SimplePlayerInteraction simplePlayerInteraction;
    private Player player;


    @BeforeEach
    public void playerSetUp() {
        player = new Player();
    }

    private SimplePlayerInteraction playerInteractionSetUp(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);

        IOHandler ioHandler = new IOHandler(scanner);

        return new SimplePlayerInteraction(ioHandler);
    }

    @DisplayName("")
    @Test
    public void testPlayerName (){
        String playerName = "Kalle";

        simplePlayerInteraction = playerInteractionSetUp(playerName);

        simplePlayerInteraction.setupPlayer(player);

        assertEquals("Kalle",player.getName());
    }

    @DisplayName("")
    @Test
    public void testPlayerHealth() {

        player.setHp(10);

        simplePlayerInteraction = playerInteractionSetUp("data");

        simplePlayerInteraction.updatePlayerHealth(player, 10);

        assertEquals(20, player.getHp());
    }


}
