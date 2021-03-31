package commands.container

import commands.CommandHandler
import commands.CommandInfo
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import java.awt.Color

@CommandInfo(cmd = "help,commands", description = "Generates a list of all commands")
class ListAllCommands : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String?) {
        val text = StringBuilder()

        val embed = EmbedBuilder().setColor(Color.RED).setTitle("${event.jda.selfUser.name} commands")

        getCommands().forEach { (info: CommandInfo, _: CommandHandler) ->

            for (commands in info.cmd.split(",").toTypedArray())
                text.append("${commands.capitalize()} ")

            text.append("\n${info.description}\n")

            text.append("Globally disabled: ${if (info.disabled) "Yes" else "No"}\n\n")

        }

        embed.setDescription(text)

        event.channel.sendMessage(embed.build()).queue()

    }

}
