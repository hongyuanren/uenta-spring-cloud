package com.uenta.cloud.notification.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "uenta-account-service", fallbackFactory = AccountServiceClientFallbackFactory.class)
public interface AccountServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	String getAccount(@PathVariable("accountName") String accountName);

}

@Component
class AccountServiceClientFallbackFactory implements FallbackFactory<AccountServiceClient> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceClientFallbackFactory.class);

	@Override
	public AccountServiceClient create(Throwable cause) {
		return new AccountServiceClient() {
			@Override
			public String getAccount(@PathVariable("accountName") String accountName) {
				LOGGER.info("fallback; reason was:", cause);
	            LOGGER.info("******** 异常发生，进入fallback方法, ACCOUNT SERVICE FAILED! - FALLING BACK");

	            return "ACCOUNT SERVICE FAILED! - FALLING BACK";
			}
		};
	}
}
