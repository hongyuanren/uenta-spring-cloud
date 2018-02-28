package com.uenta.cloud.account.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uenta.cloud.account.domain.Account;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "uenta-statistics-service", fallbackFactory = StatisticsServiceClientFallbackFactory.class)
public interface StatisticsServiceClient {

	@RequestMapping(method = RequestMethod.PUT, value = "/statistics/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void updateStatistics(@PathVariable("accountName") String accountName, Account account);

}

@Component
class StatisticsServiceClientFallbackFactory implements FallbackFactory<StatisticsServiceClient> {
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceClientFallbackFactory.class);

	@Override
	public StatisticsServiceClient create(Throwable cause) {
		return new StatisticsServiceClient() {
			@Override
			public void updateStatistics(@PathVariable("accountName") String accountName, Account account) {
				LOGGER.info("fallback; reason was:", cause);

				LOGGER.info("******** 异常发生，进入fallback方法, STATISTICS SERVICE FAILED! - FALLING BACK");
			}
		};
	}
}
