package com.withoutincident { package comet {
  import scala.xml.NodeSeq

  import net.liftweb._
    import http._
    import util.Helpers._

  import com.withoutincident.actor._

  case class RenameMe(newName:String)
  case class PostMessage(body:String)

  class ChatComet extends CometActor with CometListener {
    val registerWith = ChatActor

    private var id = nextNum.toString
    private var posterName = "Anonymouse-" + id

    override def render = NodeSeq.Empty

    override def lowPriority = {
      case ChatMessage(from, body) =>
        // Send that chat message down.

      case RenameMe(newName) =>
        ChatActor ! NameChanged(id, newName)

      case NameChanged(id, newName) =>
        if (id == this.id)
          posterName = newName

        // Update clients.

      case PostMessage(body) =>
        ChatActor ! ChatMessage(posterName, body)
    }
  }
} }
