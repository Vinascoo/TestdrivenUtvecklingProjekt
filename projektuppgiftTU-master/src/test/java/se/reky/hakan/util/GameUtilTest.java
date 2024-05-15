package se.reky.hakan.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest {

    private GameUtil gameUtil;
    GameException gameException;

    @DisplayName("")
    @Test
    public void testThrowsException() {
        gameUtil = new GameUtil();

        String input = null;

        assertThrows(GameException.class, () -> { gameUtil.toLowerCaseButFirstLetterCapitalized(input);
        });
    }
}
