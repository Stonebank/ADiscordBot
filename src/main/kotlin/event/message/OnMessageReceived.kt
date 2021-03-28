package event.message

import commands.CommandHandler
import net.dv8tion.jda.api.EmbedBuilder
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

        val embed = EmbedBuilder()
        val stringBuilder = StringBuilder()
        CommandHandler.handleCommand(cmd, embed, stringBuilder, event)

    }

}
