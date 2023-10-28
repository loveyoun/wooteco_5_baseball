package baseball.repository;

import baseball.domain.Computer;

public class ComputerRepository {

    private Computer computer;

    public void setComputer(int firstNum, int secondNum, int thirdNum) {
        this.computer = new Computer(firstNum, secondNum, thirdNum);
    }

    public Computer getComputer() {
        return this.computer;
    }

}
