package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // fields
    @Value("${game.maxNumber:50}")
    // number after the colon gives it a default value if it cannot be found in the properties file.
    private int maxNumber;
    @Value("${game.guessCount}")
    private int guessCount;
    @Value("${game.minNumber:0}")
    private int minNumber;

    // bean methods
    @Bean
    @MaxNumber
    public  int maxNumber() {
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
    @Bean
    @MinNumber
    public int minNumber() { return minNumber; }

}
