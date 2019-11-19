package ca.bank.of.canada.weather.repositories;

import ca.bank.of.canada.weather.model.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {

    @Query(value = "from Weather w where w.date BETWEEN :startDate AND :endDate")
    List<Weather> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
