package commands.container

import commands.CommandAnnotation
import commands.CommandHandler
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandAnnotation(cmd = "help,commands", description = "Generates a list of all commands")
class ListAllCommands : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String?) {
        val text = StringBuilder()

        getCommands().forEach { (annotation: CommandAnnotation, _: CommandHandler) ->

            for (commands in annotation.cmd.split(",").toTypedArray())
                text.append("${commands.capitalize()} ")

            text.append("\n${annotation.description}\n")

            text.append("Globally disabled: ${if (annotation.disabled) "Yes" else "No"}\n\n")

        }

        event.channel.sendMessage(text.toString()).queue()

    }

}
