import src.Discord;

import javax.security.auth.login.LoginException;

public class Launcher {

    public static void main(String... args) throws LoginException, InterruptedException {

        if (args.length < 1) {
            System.err.println("Discord token is missing from argument.");
            return;
        }

        Discord.discord = new Discord(args[0]);

    }


}
