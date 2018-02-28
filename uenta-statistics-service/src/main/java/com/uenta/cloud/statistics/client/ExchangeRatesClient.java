package com.uenta.cloud.statistics.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uenta.cloud.statistics.domain.Currency;
import com.uenta.cloud.statistics.domain.ExchangeRatesContainer;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @author nin
 *
 */
@FeignClient(url = "${rates.url}", name = "rates-client", fallbackFactory = ExchangeRatesClientFallbackFactory.class)
public interface ExchangeRatesClient {

	@RequestMapping(method = RequestMethod.GET, value = "/latest")
	ExchangeRatesContainer getRates(@RequestParam("base") Currency base);

}

@Component
class ExchangeRatesClientFallbackFactory implements FallbackFactory<ExchangeRatesClient> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesClientFallbackFactory.class);

	@Override
	public ExchangeRatesClient create(Throwable cause) {
		return new ExchangeRatesClient() {
			@Override
			public ExchangeRatesContainer getRates(@RequestParam("base") Currency base) {
				LOGGER.info("fallback; reason was:", cause);
				LOGGER.info("******** 异常发生，进入fallback方法, STATISTICS SERVICE FAILED! - FALLING BACK");

	            return null;
			}
		};
	}
}


