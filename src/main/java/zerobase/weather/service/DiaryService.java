package zerobase.weather.service;

import java.time.LocalDate;
import java.util.List;
import zerobase.weather.domain.Diary;

public interface DiaryService {

	public void saveWeatherDate();

	public void createDiary(LocalDate date, String text);

	public List<Diary> readDiary(LocalDate date);

	public  List<Diary> readDiaries(LocalDate startDate, LocalDate endDate);

	public void updateDiary(LocalDate date, String text);

	public void deleteDiary(LocalDate date);
}
