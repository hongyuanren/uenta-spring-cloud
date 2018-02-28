package com.uenta.cloud.notification.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.uenta.cloud.notification.domain.Frequency;

@Component
public class FrequencyWriterConverter implements Converter<Frequency, Integer> {

	@Override
	public Integer convert(Frequency frequency) {
		return frequency.getDays();
	}
}
