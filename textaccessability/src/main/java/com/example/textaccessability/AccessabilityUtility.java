package com.example.textaccessability;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccessabilityUtility {

    public static ArrayList<View> getAllViews(View v) {
        if (!(v instanceof ViewGroup) || ((ViewGroup) v).getChildCount() == 0)
            return new ArrayList<View>() {{ add(v); }};
        else {
            ArrayList<View> result = new ArrayList<View>() {{ add(v); }};
            int children = ((ViewGroup) v).getChildCount();

            for (int i = 0; i < children; i++) {
                ArrayList<View> childList = getAllViews(((ViewGroup) v).getChildAt(i));
                result.addAll(childList);
            }

            return result;
        }
    }

    public static  <T> ArrayList<T> getViewsOfClass(View view, Class<T> tClass) {
        ArrayList<View> views = getAllViews(view);
        ArrayList<T> items = (ArrayList<T>) views.stream()
                .filter(v -> tClass.isInstance(v))
                .collect(Collectors.toList());

        return items;
    }

    public static View getRootView(View view) {
        if (view.getParent() == null || !(view.getParent() instanceof View)) {
            return view;
        } else {
            return getRootView((View) view.getParent());
        }
    }

}
