package baseball.service;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {

//    private final ComputerRepository computerRepository = new ComputerRepository();


    public Computer setComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }

        int firstNum = computerNumbers.get(0);
        int secondNum = computerNumbers.get(1);
        int thirdNum = computerNumbers.get(2);

//        computerRepository.setComputer(firstNum,secondNum,thirdNum);
        return new Computer(firstNum, secondNum, thirdNum);
    }

    public ArrayList<Integer> getComputerNumber(Computer computer) {
        ArrayList<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(computer.getFirstNum());
        computerNumbers.add(computer.getSecondNum());
        computerNumbers.add(computer.getThirdNum());

        return computerNumbers;
    }

}
