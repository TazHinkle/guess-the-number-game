package academy.learnprogramming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   private final static Logger log = LoggerFactory.getLogger(Main.class);

   public static void main(String[] args) {
       log.info("Guess the Number Game");

       // create context (container)
       ConfigurableApplicationContext context
               = new AnnotationConfigApplicationContext(AppConfig.class);
       //
       NumberGenerator numberGenerator
               = context.getBean(NumberGenerator.class);
       // call method next() to get random number
       int number = numberGenerator.next();

       // log generator number
       log.info("number = {}", number);

       // get game bean from context (container)
       Game game
               = context.getBean(Game.class);

       // get MessageGenerator bean and call both methods.
       MessageGenerator messageGenerator
               = context.getBean(MessageGenerator.class);
       String messageMain = messageGenerator.getMainMessage();
       log.info(messageMain);
       String messageResult = messageGenerator.getResultMessage();
       log.info(messageResult);

       // close context (container)
       context.close();

    }
}
