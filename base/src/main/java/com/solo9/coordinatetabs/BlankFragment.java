package com.solo9.coordinatetabs;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.solo9.coordinatetabs.base.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public BlankFragment() {
        // Required empty public constructor
    }
    static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        RecyclerView recyclerViewDemo = view.findViewById(R.id.recyclerViewDemo);
        recyclerViewDemo.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDemo.setAdapter(new DemoAdapter1(feedItems(), getContext()));
        return view;
    }
    private List<DemoItem> feedItems() {
        String Titles = "about Section" ;
        List<DemoItem> demoItems = new ArrayList<>();
                DemoItem demoItem = new DemoItem(Titles);
                demoItems.add(demoItem);
                return demoItems;
    }
}
