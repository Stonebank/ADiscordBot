package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import src.utils.Utility
import java.util.*

abstract class CommandHandler {

    private val commands: HashMap<Array<String>, CommandHandler> = HashMap<Array<String>, CommandHandler>()

    companion object Init {

        init {

            for (c in Utility.getClasses("${CommandHandler::class.java.`package`.name}.container")) {

                val isCommandClass = c.getDeclaredConstructor().newInstance() is CommandHandler

                if (c.isAnonymousClass || !isCommandClass)
                    continue

            }

        }

    }

    abstract fun execute(
        embed: EmbedBuilder?,
        text: StringBuilder?,
        bot: MessageReceivedEvent?,
        vararg cmd: String?
    )

    open fun getCommands(): HashMap<Array<String>, CommandHandler> {
        return commands
    }

}
