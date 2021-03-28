import event.message.OnMessageReceived;
import event.ready.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Discord {

    public static Discord discord;

    private final JDA jda;

    public Discord(String token) throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault(token).addEventListeners(new OnMessageReceived(), new ReadyListener()).build();
        jda.setAutoReconnect(true);
        jda.awaitReady();
    }

    public JDA getJda() {
        return jda;
    }

}
