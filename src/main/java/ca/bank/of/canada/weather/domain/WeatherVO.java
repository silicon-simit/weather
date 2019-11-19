package ca.bank.of.canada.weather.domain;

import ca.bank.of.canada.weather.model.Province;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
public class WeatherVO {

    @NotNull
    @Min(1)
    @Max(Long.MAX_VALUE)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String stationName;

    @NotNull
    private Province province;

    private Date date;

    private BigDecimal meanTemp;

    private BigDecimal highestMonthlyTemp;

    private BigDecimal lowestMonthlyTemp;

    private String startDate;

    private String endDate;

    private String selectedMeanTemp;
}
