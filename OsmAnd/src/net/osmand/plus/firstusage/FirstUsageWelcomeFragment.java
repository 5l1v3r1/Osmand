package net.osmand.plus.firstusage;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import net.osmand.plus.R;

public class FirstUsageWelcomeFragment extends Fragment {
	public static final String TAG = "FirstUsageWelcomeFragment";
	public static boolean SHOW = true;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.first_usage_welcome_fragment, container, false);
		ImageView backgroundImage = (ImageView) view.findViewById(R.id.background_image);
		if (Build.VERSION.SDK_INT >= 14) {
			backgroundImage.setImageResource(R.drawable.bg_first_usage);
		} else {
			backgroundImage.setImageDrawable(null);
		}

		AppCompatButton skipButton = (AppCompatButton) view.findViewById(R.id.start_button);
		skipButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
					Window w = getActivity().getWindow();
					w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				}
				*/
				FirstUsageWizardFragment.startWizard(getActivity());
			}
		});
		return view;
	}


	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onResume() {
		super.onResume();
		/*
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window w = getActivity().getWindow(); // in Activity's onCreate() for instance
			w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
<<<<<<< HEAD
=======
		*/
		((MapActivity)getActivity()).disableDrawer();
	}

	@Override
	public void onPause() {
		super.onPause();
		((MapActivity)getActivity()).enableDrawer();
>>>>>>> 45cd256... Removed transparent status bar from first screen
	}
}
