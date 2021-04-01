package commands.container.`fun`

import commands.CommandHandler
import commands.CommandInfo
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandInfo(cmd = "legend,whoisthelegend", description = "Generates a random user to be a legend, why? idk.")
class WhoIsTheLegend : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String?) {

        for (member in event.guild.members) {

            if (member.user.isBot)
                continue

            event.channel.sendMessage("${member.asMention} is the legend in ${event.guild.name}!").queue()
            return

        }

    }

}
