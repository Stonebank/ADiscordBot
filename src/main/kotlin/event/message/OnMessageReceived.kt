package event.message

import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class OnMessageReceived : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {

        if (event.isFromType(ChannelType.PRIVATE))
            return

        println(event.message.contentRaw)

        if (event.message.contentRaw.equals(other = "ping", ignoreCase = true))
            event.channel.sendMessage("pong!").queue()

    }

}
