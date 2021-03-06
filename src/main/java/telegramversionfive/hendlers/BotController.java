package telegramversionfive.hendlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegramversionfive.entity.Bot;

@RestController
public class BotController {
    private static final Logger log = LoggerFactory.getLogger(BotController.class);

    private final Bot bot;
//    311199801 my
//    836127971
    public BotController(Bot bot) {
        log.info("BotController constructor");
        this.bot = bot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        log.info("inner onUpdateReceived()");
        return bot.onWebhookUpdateReceived(update);
    }
}
