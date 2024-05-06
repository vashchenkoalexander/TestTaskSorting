package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**


 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

	/**
	 * The implementation of this method should sort dates.
	 * The output should be in the following order:
	 * Dates with an 'r' in the month,
	 * sorted ascending (first to last),
	 * then dates without an 'r' in the month,
	 * sorted descending (last to first).
	 * For example, October dates would come before May dates,
	 * because October has an 'r' in it.
	 * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
	 * would sort to
	 * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
	 *
	 * @param unsortedDates - an unsorted list of dates
	 * @return the collection of dates now sorted as per the spec
	 */
	public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
		List<LocalDate> datesWithR = new ArrayList<>();
		List<LocalDate> datesWithoutR = new ArrayList<>();

		// Categorize dates based on whether they have 'r' in the month or not
		for (LocalDate date : unsortedDates) {
			if (isRInMonth(date)) {
				datesWithR.add(date);
			} else {
				datesWithoutR.add(date);
			}
		}

		// Sort dates by month
		datesWithR.sort(Comparator.comparing(LocalDate::getMonthValue));
		datesWithoutR.sort(Comparator.comparing(LocalDate::getMonthValue));

		//Sort dates by year
		datesWithR.sort(Comparator.comparing(date -> date.getYear()));
		datesWithoutR.sort(Comparator.comparing(LocalDate::getYear));

		//reverse ordering in list of dates without R from ASC to DESC
		Collections.reverse(datesWithoutR);

		// concatenate dates Without R into list dates With R
		datesWithR.addAll(datesWithoutR);
		return datesWithR;
	}

	private boolean isRInMonth(LocalDate date) {
		String month = date.getMonth().toString().toLowerCase();
		return month.contains("r");
	}

}