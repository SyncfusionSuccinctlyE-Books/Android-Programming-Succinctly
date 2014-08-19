package com.example.userinterfacewidgets;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.Dialog;
import android.app.DatePickerDialog;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Create and return the date picker dialog
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        
        PickerActivity context = (PickerActivity) getActivity();
        return new DatePickerDialog(context, context, year, month, day);
    }

}
