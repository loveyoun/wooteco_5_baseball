package baseball;

import baseball.service.GameService;

public class Controller {

    private static final GameService gameService = AppConfig.gameService();

    public static void baseballGame() {
        gameService.start();
    }

}
