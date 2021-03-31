package commands.container.`fun`

import commands.CommandHandler
import commands.CommandInfo
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandInfo(cmd = "rng,randomnumber,roll", description = "Generates a random number between 1-100")
class GenerateRandomNumber : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String?) {
        event.channel.sendMessage("You rolled ${(1..100).random()}!").queue()
    }

}
