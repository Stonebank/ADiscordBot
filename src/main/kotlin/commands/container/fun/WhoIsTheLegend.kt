package commands.container.`fun`

import commands.CommandHandler
import commands.CommandInfo
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandInfo(cmd = "legend,whoisthelegend", description = "Generates a random user to be a legend, why? idk.")
class WhoIsTheLegend : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String?) {

        var legend = event.guild.members[(0 until event.guild.members.size).random()]

        while (legend.user.isBot)
            legend = event.guild.members[(0 until event.guild.members.size).random()]

        event.channel.sendMessage("${legend.asMention} is the legend in ${event.guild.name}!").queue()
    }

}
