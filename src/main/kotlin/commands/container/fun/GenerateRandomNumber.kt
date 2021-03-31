package commands.container.`fun`

import commands.CommandHandler
import commands.CommandInfo
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandInfo(cmd = "rng,randomnumber,roll", description = "Generates a random number between 1-100")
class GenerateRandomNumber : CommandHandler() {

    override fun execute(event: MessageReceivedEvent, vararg cmd: String) {

        if (cmd[1].toIntOrNull() == null) {
            event.channel.sendMessage("Your first argument must be an integer.").queue()
            return
        }

        val min = cmd[1].toInt()

        if (cmd[2].toIntOrNull() == null) {
            event.channel.sendMessage("Your second argument must be an integer.").queue()
            return
        }

        val max = cmd[2].toInt()

        if (min > max) {
            event.channel.sendMessage("The maximum input ($max) has to be higher than the lower input ($min).").queue()
            return
        }

        event.channel.sendMessage("You rolled ${(min..max).random()}!").queue()
    }

}
