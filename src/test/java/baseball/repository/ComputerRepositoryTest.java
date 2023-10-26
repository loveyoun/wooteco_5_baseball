package baseball.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ComputerRepositoryTest")
class ComputerRepositoryTest {

    @Test
    @DisplayName("setComputer&getComputer Test")
    void setComputerTest() {
        ComputerRepository computerRepository = new ComputerRepository();
        computerRepository.setComputer(1,2,3);
        assertThat(computerRepository.getComputer().getFirstNum()).isEqualTo(1);
        assertThat(computerRepository.getComputer().getSecondNum()).isEqualTo(2);
        assertThat(computerRepository.getComputer().getThirdNum()).isEqualTo(3);
    }

}