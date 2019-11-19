package ca.bank.of.canada.weather.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "weather")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Station_Name")
    private String stationName;

    @Column(name = "Province")
    @Enumerated(EnumType.STRING)
    private Province province;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Mean_Temp")
    private BigDecimal meanTemp;

    @Column(name = "Highest_Monthly_Maxi_Temp")
    private BigDecimal highestMonthlyTemp;

    @Column(name = "Lowest_Monthly_Min_Temp")
    private BigDecimal lowestMonthlyTemp;

}
