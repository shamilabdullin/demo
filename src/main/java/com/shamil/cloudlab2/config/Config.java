package com.shamil.cloudlab2.config;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobListDetails;
import com.azure.storage.blob.models.ListBlobsOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${azure.service.connection.string}")
    private String azureConnection;

    @Bean
    public BlobServiceClient blobContainerClient() {
        return new BlobServiceClientBuilder()
                .connectionString(azureConnection)
                .buildClient();
    }

    @Bean
    public ListBlobsOptions listBlobsOptions() {
        return new ListBlobsOptions()
                .setDetails(new BlobListDetails().setRetrieveMetadata(true));
    }

}
