package baseball;

import baseball.repository.ComputerRepository;
import baseball.repository.PlayerRepository;
import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.service.MessageService;
import baseball.service.PlayerService;

public class AppConfig {

    public static final GameService gameService = new GameService();
    public static final ComputerService computerService = new ComputerService();
    public static final PlayerService playerService = new PlayerService();
    public static final MessageService messageService = new MessageService();
    public static final ComputerRepository computerRepository = new ComputerRepository();
    public static final PlayerRepository playerRepository = new PlayerRepository();

    public static GameService gameService() {
        return gameService;
    }

    public static ComputerService computerService() {
        return computerService;
    }

    public static PlayerService playerService() {
        return playerService;
    }

    public static MessageService messageService() {
        return messageService;
    }

    public static ComputerRepository computerRepository() {
        return computerRepository;
    }

    public static PlayerRepository playerRepository() {
        return playerRepository;
    }

}
