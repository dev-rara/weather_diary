package rara.weather.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "date_weather")
@Getter
@Setter
@NoArgsConstructor
public class DateWeather {
	@Id
	private LocalDate date;
	private String weather;
	private String icon;
	private double temperature;
}
