package baseball.service;

import baseball.repository.PlayerRepository;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerService {

    //    private final GameService gameService = new GameService();
    private final PlayerRepository playerRepository = new PlayerRepository();


    public ArrayList<Integer> inputPlayerNumber() {
        ArrayList<Integer> playerNumberList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String playerNumbers = Console.readLine();
//        gameService.checkInputPlayerNumber(playerNumbers);
        checkInputPlayerNumber(playerNumbers);
        for (int i = 0; i < 3; i++) {
            playerNumberList.add(Character.getNumericValue(playerNumbers.charAt(i)));
        }
        return playerNumberList;
    }


    public void setPlayerNumber(ArrayList<Integer> playerNumberList) {
        int firstNumber = playerNumberList.get(0);
        int secondNumber = playerNumberList.get(1);
        int thirdNumber = playerNumberList.get(2);
        playerRepository.setPlayer(firstNumber, secondNumber, thirdNumber);
    }

    public ArrayList<Integer> getPlayerNumber() {
        ArrayList<Integer> playerNumberList = new ArrayList<>();
        playerNumberList.add(playerRepository.getPlayer().getFirstNum());
        playerNumberList.add(playerRepository.getPlayer().getSecondNum());
        playerNumberList.add(playerRepository.getPlayer().getThirdNum());
        return playerNumberList;
    }

    public Boolean inputRestartAnswer() {
        String answer = Console.readLine();
        if (answer.equals("1")) {
            return true;
        } else if (answer.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Integer> checkBallCount(ArrayList<Integer> computerNumbers) {
        ArrayList<Integer> ballCount = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> playerNumbers = getPlayerNumber();
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ballCount.set(0, ballCount.get(0) + 1);
            }
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                ballCount.set(1, ballCount.get(1) + 1);
                ballCount.set(0, ballCount.get(0) - 1);
            }
        }
        return ballCount;
    }


    public void checkInputPlayerNumber(String inputPlayerNumbers) {
        checkForCharacterExistence(inputPlayerNumbers);
        checkTheLength(inputPlayerNumbers);
        checkForDuplicateNumber(inputPlayerNumbers);
        checkThePresenceOfZeros(inputPlayerNumbers);
    }

    public void checkTheLength(String inputPlayerNumbers) {
        if (inputPlayerNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void checkForDuplicateNumber(String inputPlayerNumbers) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (numbers.contains(Character.getNumericValue(inputPlayerNumbers.charAt(i)))) {
                throw new IllegalArgumentException();
            }
            numbers.add(Character.getNumericValue(inputPlayerNumbers.charAt(i)));
        }
    }

    public void checkThePresenceOfZeros(String inputPlayerNumbers) {
        if (inputPlayerNumbers.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public void checkForCharacterExistence(String inputPlayerNumbers) {
        for (int i = 0; i < 3; i++) {
            try {
                Integer.parseInt(inputPlayerNumbers);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

}
