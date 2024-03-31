package Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

import Function.DatePickerHelper;

public class hotelsearchFragment extends Fragment {
    private Button startDateButton;
    private Button endDateButton;
    private EditText guestName;
    private EditText numberOfGuest;
    private Button submitButton;
    View view;
    ConstraintLayout mainLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hotelsearch, container, false);

        startDateButton = view.findViewById(R.id.startdate);
        DatePickerHelper.attachDatePicker(getContext(), startDateButton);

        endDateButton = view.findViewById(R.id.enddate);
        DatePickerHelper.attachDatePicker(getContext(), endDateButton);

        Button searchButton = view.findViewById(R.id.btn_search);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainLayout = view.findViewById(R.id.main);
        guestName = view.findViewById(R.id.edit_name);
        numberOfGuest = view.findViewById(R.id.edit_guests);
        submitButton = view.findViewById(R.id.btn_search);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Search 2 button clicked!");
                String strName = guestName.getText().toString();
                String strNumber = numberOfGuest.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Guest Name", strName);
                bundle.putString("number of guests", strNumber);


                // set Fragment class Arguments
                HotelsListFragment hotelsListFragment = new HotelsListFragment();
                hotelsListFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();



                fragmentTransaction.replace(R.id.check, hotelsListFragment);
                fragmentTransaction.remove(hotelsearchFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
