package rara.weather.service;

import java.time.LocalDate;
import java.util.List;
import rara.weather.domain.Diary;

public interface DiaryService {

	void saveWeatherDate();

	void createDiary(LocalDate date, String text);

	List<Diary> readDiary(LocalDate date);

	List<Diary> readDiaries(LocalDate startDate, LocalDate endDate);

	void updateDiary(LocalDate date, String text);

	void deleteDiary(LocalDate date);
}
