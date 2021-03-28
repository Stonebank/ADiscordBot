package commands.container

import commands.CommandAnnotation
import commands.CommandHandler
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandAnnotation(cmd = "rng,randomnumber,roll", description = "Generates a random number between 1-100")
class GenerateRandomNumber : CommandHandler() {

    override fun execute(embedBuilder: EmbedBuilder?, text: StringBuilder?, event: MessageReceivedEvent, vararg cmd: String?) {

        val random = (1..100).random()
        event.channel.sendMessage("You rolled $random!").queue()

    }

}
