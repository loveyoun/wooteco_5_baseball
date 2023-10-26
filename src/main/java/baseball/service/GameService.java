package baseball.service;

import baseball.AppConfig;

public class GameService {

    private static final ComputerService computerService = AppConfig.computerService();
    private static final PlayerService playerService = AppConfig.playerService();
    private static final MessageService messageService = AppConfig.messageService();


    public static void start() {
        boolean gameOn = true;
        int gameCount = 0;

        messageService.startMessage();
        while (gameOn) {
            if (gameOn && gameCount == 0) {
                initGame();
            }
            inputPlayerNumber();
            showBallCount();
            gameCount += 1;
            if (checkStrikeNumber() == 3) {
                gameOn = confirmGameRestart();
                gameCount = 0;
            }
        }

    }

    public static boolean confirmGameRestart() {
        messageService.endMessage();
        messageService.restartMessage();
        return playerService.inputRestartAnswer();
    }

    public static int checkStrikeNumber() {
        return playerService.checkBallCount(computerService.getComputerNumber()).get(1);
    }

    public static void inputPlayerNumber() {
        playerService.setPlayerNumber(playerService.inputPlayerNumber());
    }

    public static void showBallCount() {
        messageService.resultMessage(playerService.checkBallCount(computerService.getComputerNumber()));
    }


    public static void initGame() {
        computerService.setComputerNumber();
    }

}
