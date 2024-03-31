package Function;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerHelper {

    public interface OnDateSelectedListener {
        void onDateSelected(int year, int month, int day);
    }

    public static void attachDatePicker(final Context context, final Button button) {
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                        (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {
                            String date = formatDate(selectedYear, selectedMonth, selectedDay);
                            button.setText(date);
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private static String formatDate(int year, int month, int day) {
        return String.format("%02d-%02d-%d", day, month + 1, year);
    }
}
