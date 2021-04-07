package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
/**
 * @EnableOAuth2Sso：将您的服务标记为OAuth 2.0客户。这意味着它将负责将资源所有者（最终用户）重定向到用户必须输入其凭据的授权服务器。完成后，用户将被重定向回具有授权码的客户端（不要与访问代码混淆）。然后客户端通过调用授权服务器获取授权代码并将其交换为访问令牌。只有在此之后，客户端才能使用访问令牌调用资源服务器。
 * 另外，如果你看一下 @ EnableOAuth2Sso 注释你会看到两件有趣的事情：
 * @EnableOAuth2Client 。这是您的服务成为OAuth 2.0客户端的地方。如果您通过 OAuth2RestTemplate 调用这些服务，则可以将访问令牌（在交换授权代码之后）转发给下游服务。
 * @EnableConfigurationProperties（OAuth2SsoProperties.class）。 OAuth2SsoProperties只有一个属性 String loginPath 默认情况下为 / login 。这将通过 OAuth2ClientAuthenticationProcessingFilter 拦截对 / login 的浏览器请求，并将用户重定向到授权服务器。
 */
@EnableOAuth2Sso
public class Ch82ZuulServerApplication extends WebSecurityConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Ch82ZuulServerApplication.class, args);
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login", "/client/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable();
	}
}
