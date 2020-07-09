package academy.learnprogramming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   private final static Logger log = LoggerFactory.getLogger(Main.class);
   private static final String CONFIG_LOCATION = "beans.xml";

   public static void main(String[] args) {
       log.info("Guess the Number Game");

       // create context (container)
       ConfigurableApplicationContext context
               = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
       //
       NumberGenerator numberGenerator
               = context.getBean(NumberGenerator.class);
       // call method next() to get random number
       int number = numberGenerator.next();

       // log generator number
       log.info("number = {}", number);

       // get game bean from context (container)
       Game game = context.getBean(Game.class);

       // close context (container)
       context.close();

    }
}
