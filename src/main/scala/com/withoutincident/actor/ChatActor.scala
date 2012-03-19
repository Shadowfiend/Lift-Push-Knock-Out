package com.withoutincident { package actor {
  import net.liftweb.actor._
  import net.liftweb.http.ListenerManager

  sealed trait ChatInteraction

  case class ChatMessage(from: String, body: String) extends ChatInteraction
  case class NameChanged(posterId: String, newName: String) extends ChatInteraction

  /**
   * Lifted (!) from Simply Lift, section 2.3.
   */
  object ChatActor extends LiftActor with ListenerManager {
    private var lastInteraction: ChatInteraction = ChatMessage("System", "Welcome") // private state

    /**
     * When we update the listeners, what message do we send?
     * We send the msgs, which is an immutable data structure,
     * so it can be shared with lots of threads without any
     * danger or locking.
     */
    def createUpdate = lastInteraction

    /**
     * process messages that are sent to the Actor.  In
     * this case, we're looking for Strings that are sent
     * to the ChatServer.  We append them to our Vector of
     * messages, and then update all the listeners.
     */
    override def lowPriority = {
      case interaction: ChatInteraction =>
        lastInteraction = interaction
        updateListeners()
    }
  }
} }
