package com.example.textaccessability;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextSizeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextSizeFragment extends Fragment {


    public TextSizeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TextSizeFragment newInstance(String param1, String param2) {
        TextSizeFragment fragment = new TextSizeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_size, container, false);

        Button normalButton = view.findViewById(R.id.normal_button);
        normalButton.setOnClickListener(v -> updateAll(v, 0));

        Button bigButton = view.findViewById(R.id.big_button);
        bigButton.setOnClickListener(v -> updateAll(v, 1));

        Button hugeButton = view.findViewById(R.id.huge_button);
        hugeButton.setOnClickListener(v -> updateAll(v, 2));

        return view;
    }
    public void updateAll(View view, int size){
        AccessibleTextView.updateAccessabilityTexts(AccessabilityUtility.getViewsOfClass(AccessabilityUtility.getRootView(view), AccessibleTextView.class),size);
        AccessibleButton.updateButtons(AccessabilityUtility.getViewsOfClass(AccessabilityUtility.getRootView(view), AccessibleButton.class),size);
        AccessibleCheckBox.updateCheckboxes(AccessabilityUtility.getViewsOfClass(AccessabilityUtility.getRootView(view), AccessibleCheckBox.class),size);
        AccessibleRadioButton.updateRadioButtons(AccessabilityUtility.getViewsOfClass(AccessabilityUtility.getRootView(view), AccessibleRadioButton.class),size);
        AccessibleSwitch.updateAccessibleSwitch(AccessabilityUtility.getViewsOfClass(AccessabilityUtility.getRootView(view), AccessibleSwitch.class),size);
    }
}