package commands;

import commands.container.GenerateRandomNumber;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Utility;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

public abstract class CommandHandler {

    private static final HashMap<CommandAnnotation, CommandHandler> commands = new HashMap<>();

    public static void init() {

        try {

            for (Class<?> c : Utility.getClasses(GenerateRandomNumber.class.getPackageName())) {

                Object instance = c.getDeclaredConstructor().newInstance();
                boolean isCommandClass = instance instanceof CommandHandler;

                if (c.isAnonymousClass() || !isCommandClass || commands.containsValue(instance))
                    continue;

                if (Arrays.stream(c.getAnnotations()).noneMatch(annotation -> annotation instanceof CommandAnnotation)) {
                    System.err.println(c.getName() + " has no annotation");
                    continue;
                }

                CommandAnnotation annotation = c.getAnnotation(CommandAnnotation.class);

                CommandHandler command = (CommandHandler) instance;
                commands.put(annotation, command);

            }

            System.out.println(commands.size() + " commands has been initialized.");

        } catch (IOException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void handleCommand(String[] cmd, EmbedBuilder embedBuilder, StringBuilder text, MessageReceivedEvent event) {

        commands.forEach((annotation, command) -> {

            // TODO FIX ANNOTATION DISABLED FOR ALL CLASSES (+ CONTINUOUS LOOP)
            if (annotation.disabled()) {
                event.getChannel().sendMessage("This command has been globally disabled.").queue();
                return;
            }

            String[] commands = annotation.cmd().split(",");

            for (String s : commands) {

                if (cmd[0].equalsIgnoreCase("!" + s))
                    command.execute(embedBuilder, text, event, cmd);

            }

        });

    }

    public abstract void execute(EmbedBuilder embedBuilder, StringBuilder text, MessageReceivedEvent event, String... cmd);

}
