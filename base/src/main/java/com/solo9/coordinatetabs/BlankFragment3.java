package com.solo9.coordinatetabs;
import android.os.Bundle;
import com.solo9.coordinatetabs.base.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    public BlankFragment3() {
        // Required empty public constructor
    }
    static BlankFragment3 newInstance() {
        BlankFragment3 fragment = new BlankFragment3();
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
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        RecyclerView recyclerViewDemo = view.findViewById(R.id.recyclerViewDemo3);
        recyclerViewDemo.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDemo.setAdapter(new DemoAdapter2(feedItems(), getContext()));
        return view;
    }

    private List<DemoItem> feedItems() {
        String Titles = "Profession Section";
        List<DemoItem> demoItems = new ArrayList<>();
        DemoItem demoItem = new DemoItem(Titles);
        demoItems.add(demoItem);
        return demoItems;

    }
}
