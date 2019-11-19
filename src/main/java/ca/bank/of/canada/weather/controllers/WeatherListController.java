package ca.bank.of.canada.weather.controllers;

import ca.bank.of.canada.weather.domain.WeatherVO;
import ca.bank.of.canada.weather.services.WeatherService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;

@Controller
public class WeatherListController {

    private static final ModelAndView WEATHER_LIST = new ModelAndView("weather_list");

    private WeatherVO searchBean;

    @Autowired
    private WeatherService weatherService;

    @ModelAttribute("searchBean")
    public WeatherVO searchBean() {
        if (searchBean == null) {
            searchBean = WeatherVO.builder().endDate("").startDate("").selectedMeanTemp("").build();
        }
        return searchBean;
    }

    @GetMapping("/weather/list")
    public ModelAndView displayWeatherListPage() {
       WEATHER_LIST.addObject("weatherDetails", weatherService.getWeatherDetailList());
       return WEATHER_LIST;
    }

    @PostMapping(value = "/weather/list/search", params="action=search")
    public ModelAndView displayWeatherSearchListPage(@ModelAttribute("searchBean") WeatherVO searchBean) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            WEATHER_LIST.addObject("weatherDetails", weatherService.getWeatherDetailBetweenDates(
                    simpleDateFormat.parse(searchBean.getStartDate()), simpleDateFormat.parse(searchBean.getEndDate())));
        } catch (Exception e) {
            e.printStackTrace();
            WEATHER_LIST.addObject("weatherDetails", Lists.newArrayList());
        }
        return WEATHER_LIST;
    }

}
