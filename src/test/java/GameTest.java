import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Катя", 36);
    Player player2 = new Player(2, "Таня", 39);
    Player player3 = new Player(3, "Лена", 53);
    Player player4 = new Player(4, "Саша", 36);
    Player player5 = new Player(5, "Андрей", 41);
    Player player6 = new Player(6, "Леша", 47);

    @Test
    public void test1() {
        game.register(player3);
        game.register(player1);

        int expected = game.round("Лена", "Катя");
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test0() {
        game.register(player1);
        game.register(player4);

        int expected = game.round("Катя", "Саша");
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        game.register(player4);
        game.register(player2);

        int expected = game.round("Саша", "Таня");
        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerTest1() {
        game.register(player1);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "Андрей");
        });
    }

    @Test
    public void playerTest2() {
        game.register(player1);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Катя", "");
        });
    }

    @Test
    public void playerTest4() {
        game.register(player1);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });
    }
}