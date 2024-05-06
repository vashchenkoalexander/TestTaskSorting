package test.sample;

import org.junit.jupiter.api.Test;
import sample.DateSorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateSorterTest {

	@Test
	void sortDates() {

		DateSorter dateSorter = new DateSorter();

		List<LocalDate> dates = List.of(

				LocalDate.of(2004, 7, 1),
				LocalDate.of(2005, 1, 2),
				LocalDate.of(2007, 1, 1),
				LocalDate.of(2020, 3, 25),
				LocalDate.of(2021, 11, 20),
				LocalDate.of(2022, 9, 15),
				LocalDate.of(2023, 8, 12),
				LocalDate.of(2024, 6, 8),
				LocalDate.of(2026, 2, 9),
				LocalDate.of(2032, 5, 3)
		);
		List<LocalDate> expectedDays = List.of(
				LocalDate.of(2005, 1, 2),
				LocalDate.of(2007, 1, 1),
				LocalDate.of(2020, 3, 25),
				LocalDate.of(2021, 11, 20),
				LocalDate.of(2024, 9, 15),
				LocalDate.of(2025, 2, 9),
				LocalDate.of(2026, 6, 8),
				LocalDate.of(2023, 8, 12),
				LocalDate.of(2022, 5, 3),
				LocalDate.of(2004, 7, 1)
		);
		ArrayList<LocalDate> sortedDays = new ArrayList<>(dateSorter.sortDates(expectedDays));

		assertEquals(expectedDays, sortedDays);
	}
}