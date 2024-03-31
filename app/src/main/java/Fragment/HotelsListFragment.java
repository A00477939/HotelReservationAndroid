package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HotelsListFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private HotelAdapter adapter;
    private List<String> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_list_fragment, container, false);



        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Mcda Hotel","3000$",R.drawable.a));
        items.add(new Item("Hritik Hotel","900$",R.drawable.a));

        adapter = new HotelAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve data passed from hotelsearchFragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            String guestName = bundle.getString("Guest Name");
            String numberOfGuests = bundle.getString("number of guests");

            // Display the guest name in a TextView
            TextView guestNameTextView = view.findViewById(R.id.text_title);
            guestNameTextView.setText("Hotel List For " + guestName);


        }
    }



}
