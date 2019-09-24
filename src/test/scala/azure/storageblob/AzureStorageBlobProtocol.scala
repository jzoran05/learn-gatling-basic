package azure.storageblob

import com.azure.storage.common.credentials.SASTokenCredential
import io.gatling.core.protocol.Protocol
import com.azure.storage.blob.BlobServiceClientBuilder
import com.azure.storage.blob.BlobServiceClient
import com.azure.storage.blob.ContainerClientBuilder
import com.azure.storage.blob.ContainerClient
import com.azure.storage.blob.BlobClient
import java.io.ByteArrayInputStream
import com.azure.storage.blob.BlockBlobClient

case class AzureStorageBlobProtocol(endpoint:String,
                                    sasToken:String,
                                    containerName:String) extends Protocol {

  val containerClient = new ContainerClientBuilder()
    .endpoint(endpoint)
    .credential(SASTokenCredential.fromSASTokenString(sasToken))
    .containerName(containerName)
    .buildClient()




  def call(blobName:String): Unit = {

    val blockBlobClient = containerClient.getBlockBlobClient(blobName)
    val dataSample = "samples"

    import java.io.ByteArrayInputStream
    try {
      val dataStream = new ByteArrayInputStream(dataSample.getBytes)
      try blockBlobClient.upload(dataStream, dataSample.length)
      finally if (dataStream != null) dataStream.close()
    }


    println("File uploaded...")
  }
}

