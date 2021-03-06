package androidx.viewpager.example;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fiberthemax.example.R;

import java.util.Objects;

public class TextFragment extends Fragment {

    private static final String TAG = TextFragment.class.getSimpleName();
    private static final String ARG_TEXT = "text";

    public String mText;

    public TextFragment() {
    }

    public static TextFragment newInstance(String text) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = Objects.requireNonNull(getView()).findViewById(R.id.textView);
        textView.setText(mText);
        if (mText.equals("3")) {
            Log.d(TAG, "onActivityCreate");
        }

    }
}
