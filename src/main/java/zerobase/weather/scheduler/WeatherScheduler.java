package zerobase.weather.scheduler;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.service.impl.DiaryServiceImpl;

@Component
@AllArgsConstructor
@EnableScheduling
public class WeatherScheduler {

	private final DiaryServiceImpl diaryServiceImpl;

	@Transactional
	@Scheduled(cron = "0 0 1 * * *")
	public void weatherDateScheduling() {
		diaryServiceImpl.saveWeatherDate();
	}

}
