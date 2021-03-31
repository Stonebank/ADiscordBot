import com.google.common.base.Stopwatch;
import event.message.OnMessageReceived;
import event.ready.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

public class Discord {

    public static Discord discord;

    private final JDA jda;

    public Discord(String token) throws LoginException, InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Object[] listeners = new Object[] {
                new OnMessageReceived(),
                new ReadyListener()
        };

        jda = JDABuilder.createDefault(token).addEventListeners(listeners).build();
        jda.setAutoReconnect(true);
        jda.awaitReady();

        System.out.printf("Executed in %s mills!\n", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

    }

    public JDA getJda() {
        return jda;
    }

}
