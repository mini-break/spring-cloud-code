package cn.springcloud.book.config;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by caibosi on 2018-06-26.
 * 我们这里没有指定整个应用实例启用HTTPS，仅仅是开启访问eureka-server的HTTPS配置。
 * 通过自定义配置eureka.client.ssl.key-store和eureka.client.ssl.key-store-password两个属性，
 * 指定eureka-client访问eureka-server的sslContext配置。这里需要在代码里指定DiscoveryClient.DiscoveryClientOptionalArgs
 */
@Profile({"https"})
@Configuration
public class EurekaHttpsClientConfig {

    @Value("${eureka.client.ssl.key-store}")
    String keyStoreFileName;

    @Value("${eureka.client.ssl.key-store-password}")
    String keyStorePassword;

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        builder.withClientName("eureka-https-client1234");
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(
                        this.getClass().getClassLoader().getResource(keyStoreFileName),keyStorePassword.toCharArray()
                )
                .build();
        builder.withCustomSSL(sslContext);

        builder.withMaxTotalConnections(10);
        builder.withMaxConnectionsPerHost(10);

        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        args.setEurekaJerseyClient(builder.build());
        return args;
    }
}
