package com.uenta.cloud.statistics.repository.converter;

import com.mongodb.DBObject;
import com.uenta.cloud.statistics.domain.timeseries.DataPointId;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataPointIdReaderConverter implements Converter<DBObject, DataPointId> {

	@Override
	public DataPointId convert(DBObject object) {

		Date date = (Date) object.get("date");
		String account = (String) object.get("account");

		return new DataPointId(account, date);
	}
}
