package event.ready

import commands.CommandHandler
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.EventListener
import javax.annotation.Nonnull

class ReadyListener : EventListener {

    override fun onEvent(@Nonnull event: GenericEvent) {

        if (event is ReadyEvent) {

            // Loading the commands
            CommandHandler.init()

            println("${event.jda.selfUser.name} is ready for usage!")

        }

    }

}
