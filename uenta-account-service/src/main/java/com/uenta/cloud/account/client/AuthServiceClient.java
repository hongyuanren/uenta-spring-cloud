package com.uenta.cloud.account.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uenta.cloud.account.domain.User;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "uenta-auth-server", fallbackFactory = AuthServiceClientFallbackFactory.class)
public interface AuthServiceClient {

	@RequestMapping(method = RequestMethod.POST, value = "/uaa/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void createUser(User user);
}

@Component
class AuthServiceClientFallbackFactory implements FallbackFactory<AuthServiceClient> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceClientFallbackFactory.class);

	@Override
	public AuthServiceClient create(Throwable cause) {
		return new AuthServiceClient() {
			@Override
			public void createUser(User user) {
				LOGGER.info("fallback; reason was:", cause);

				LOGGER.info("******** 异常发生，进入fallback方法, AUTH SERVICE FAILED! - FALLING BACK");
			}
		};
	}
}
