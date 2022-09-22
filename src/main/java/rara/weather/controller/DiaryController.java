package rara.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rara.weather.domain.Diary;
import rara.weather.service.impl.DiaryServiceImpl;

@RestController
@RequiredArgsConstructor
public class DiaryController {
	private final DiaryServiceImpl diaryServiceimpl;

	@ApiOperation(value = "일기 텍스트와 날씨를 이용하여 DB에 일기를 저장합니다.")
	@PostMapping("/create/diary")
	void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "일기를 작성하고 싶은 날짜", example = "2022-01-01") LocalDate date
		, @RequestBody @ApiParam(value = "일기 작성") String text) {

		diaryServiceimpl.createDiary(date, text);
	}

	@ApiOperation(value = "선택한 날짜의 모든 일기 데이터를 가져옵니다.")
	@GetMapping("/read/diary")
	List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회하고 싶은 날짜", example = "2022-01-01")LocalDate date) {
		return  diaryServiceimpl.readDiary(date);
	}

	@ApiOperation(value = "선택한 기간중의 모든 일기 데이터를 가져옵니다.")
	@GetMapping("/read/diaries")
	List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 시작일", example = "2022-01-01") LocalDate startDate,
		@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막날", example = "2022-01-01") LocalDate endDate) {

		return diaryServiceimpl.readDiaries(startDate, endDate);
	}

	@ApiOperation(value = "선택한 날짜의 일기를 수정합니다.")
	@PutMapping("/update/diary")
	void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "수정하고 싶은 날짜", example = "2022-01-01") LocalDate date,
					@RequestBody @ApiParam(value = "일기 수정") String text) {
		diaryServiceimpl.updateDiary(date, text);
	}

	@ApiOperation(value = "선택한 날짜의 일기 데이터를 삭제합니다.")
	@DeleteMapping("/delete/diary")
	void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "일기를 삭제하고 싶은 날짜", example = "2022-01-01") LocalDate date) {
		diaryServiceimpl.deleteDiary(date);
	}
}
