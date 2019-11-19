package ca.bank.of.canada.weather.services;

import ca.bank.of.canada.weather.converters.WeatherConverter;
import ca.bank.of.canada.weather.domain.WeatherVO;
import ca.bank.of.canada.weather.repositories.WeatherRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<WeatherVO> getWeatherDetailList() {
        return WeatherConverter.convertToDomain(Lists.newArrayList(weatherRepository.findAll()));
    }
    public List<WeatherVO> getWeatherDetailBetweenDates(Date startDate, Date endDate) {
        return WeatherConverter.convertToDomain(Lists.newArrayList(weatherRepository.getAllBetweenDates(startDate, endDate)));
    }

}
