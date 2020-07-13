package academy.learnprogramming;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    /*
    add a logger
    add a field of type Game and autowire it
    add a field guessCount (int) and initialize it to 10
    add a @PostConstruct method and log value of game to confirm it was autowired (not null)

    game: Game
    guessCount: int

    String getMainMessage();
    String getResultMessage();
     */
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    int guessCount = 10;
    @Autowired
    private Game game;

    @Override
    public String getMainMessage() {
        log.info("logged the main message");
        return "here is a message";
    }

    @PostConstruct
    @Override
    public String getResultMessage() {
        log.info("logged the result message, and: " + guessCount);
        return "here is a result message";
    }

}
