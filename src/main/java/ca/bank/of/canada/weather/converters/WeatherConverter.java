package ca.bank.of.canada.weather.converters;

import ca.bank.of.canada.weather.domain.WeatherVO;
import ca.bank.of.canada.weather.model.Weather;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WeatherConverter {

    public static List<Weather> convertToModel(List<WeatherVO> weatherVOList) {
        return weatherVOList.stream().map(WeatherConverter::convertToModel).collect(toList());
    }

    public static List<WeatherVO> convertToDomain(List<Weather> weatherList) {
        return weatherList.stream().map(WeatherConverter::convertToDomain).collect(toList());
    }

    public static Weather convertToModel(WeatherVO weatherVO) {
        return Weather.builder().id(weatherVO.getId()).province(weatherVO.getProvince()).date(weatherVO.getDate())
                .highestMonthlyTemp(weatherVO.getHighestMonthlyTemp()).lowestMonthlyTemp(weatherVO.getLowestMonthlyTemp())
                .meanTemp(weatherVO.getMeanTemp()).stationName(weatherVO.getStationName())
                .build();
    }

    public static WeatherVO convertToDomain(Weather weather) {
        return WeatherVO.builder().id(weather.getId()).province(weather.getProvince()).date(weather.getDate())
                .highestMonthlyTemp(weather.getHighestMonthlyTemp()).lowestMonthlyTemp(weather.getLowestMonthlyTemp())
                .meanTemp(weather.getMeanTemp()).stationName(weather.getStationName())
                .build();
    }
}
