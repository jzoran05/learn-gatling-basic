package azure.storageblob

import akka.actor.ActorRef
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.protocol.Protocols

case class AzureStorageBlobActionBuilder() extends ActionBuilder {

  def azureStorageBlobProtocol(protocols: Protocols) =
    protocols.protocol[AzureStorageBlobProtocol]
      .getOrElse(throw new UnsupportedOperationException("AzureStorageBlobProtocol Protocol wasn't registered"))


  override def build(next: ActorRef, protocols: Protocols): ActorRef = {
    actor(actorName("Functioncall")) {
      new FunctionCall(functionName, azureStorageBlobProtocol(protocols), next)
    }
  }
}
