package event.message

import commands.CommandHandler
import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class OnMessageReceived : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {

        if (event.author.isBot)
            return

        if (event.isFromType(ChannelType.PRIVATE))
            return

        println(String.format("%s said in %s: %s", event.author.asTag, event.guild.name, event.message.contentRaw))

        val cmd = event.message.contentRaw.split(" ").toTypedArray()

        CommandHandler.handleCommand(cmd, event)

    }

}
