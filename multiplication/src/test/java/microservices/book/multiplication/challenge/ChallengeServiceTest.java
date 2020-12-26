package microservices.book.multiplication.challenge;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;


class ChallengeServiceTest {

    private ChallengeService challengeService;
    @BeforeEach
    void setUp() {
        challengeService = new ChallengeServiceImpl();
    }

    public void checkCorrectAttemptTest(){
        //given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50,60, "Guillermo", 3000);

        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);

        //then
        then(resultAttempt.isCorrect()).isTrue();
    }

    public  void checkWrongAttemptTest(){
        //given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50,60, "Guillermo", 5000);
        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        //then
        then(resultAttempt.isCorrect()).isFalse();
    }
}