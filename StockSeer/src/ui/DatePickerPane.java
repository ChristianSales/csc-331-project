package ui;

import javax.swing.JPanel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.IntStream;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Component;

import javax.swing.Box;

public class DatePickerPane extends JPanel {
	private JComboBox<String> cbMonth;
	private JComboBox<String> cbDayOfMonth;
	private JComboBox<String> cbYear;

	/**
	 * Create the panel.
	 */
	public DatePickerPane() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel lblMonth = new JLabel("Month");
		add(lblMonth);

		cbMonth = new JComboBox<String>();
		add(cbMonth);
		cbMonth.addItem("--");
		for (int i = 1; i <= 12; i++) {
			cbMonth.addItem(i + "");
		}

		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);

		JLabel lblDay = new JLabel("Day");
		add(lblDay);

		cbDayOfMonth = new JComboBox<String>();
		add(cbDayOfMonth);
		cbDayOfMonth.addItem("--");
		String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
		for (String m : months) {
			cbDayOfMonth.addItem(m);
		}

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);

		JLabel lblYear = new JLabel("Year");
		add(lblYear);

		cbYear = new JComboBox<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		cbYear.addItem("--");
		for (int i = year; i <= year + 2; i++) {
			cbYear.addItem(i + "");
		}
		add(cbYear);
	}

	public GregorianCalendar getDate() {
		if (isDateValid()) {
			int year = Integer.parseInt((String) cbYear.getSelectedItem());
			int month = Integer.parseInt((String) cbMonth.getSelectedItem());
			int dayOfMonth = Integer.parseInt((String) cbDayOfMonth.getSelectedItem());
			GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
			return date;
		}
		return null;
	}

	public boolean isDateValid() {
		if (cbDayOfMonth.getSelectedIndex() == 0 || cbMonth.getSelectedIndex() == 0 || cbYear.getSelectedIndex() == 0) {
			return false;
		}
		int month = cbMonth.getSelectedIndex();
		int day = cbDayOfMonth.getSelectedIndex();
		int year = Integer.parseInt((String) cbYear.getSelectedItem());
		if (month == 2) {
			// leap year
			if (year % 4 == 0 && day > 29) {
				return false;
			}
			// non-leap year
			if (day > 28) {
				return false;
			}
		}
		int[] monthsHas31 = { 4, 6, 9, 11 };
		if (IntStream.of(monthsHas31).anyMatch(x -> x == month) && day > 30) {
			return false;
		}
		return true;
	}
}
