package intentional.casterio.com.intentional;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import intentional.casterio.com.intentional.content.CourseContent;

/**
 * A fragment representing a single Course detail screen.
 * This fragment is either contained in a {@link CourseListActivity}
 * in two-pane mode (on tablets) or a {@link CourseDetailActivity}
 * on handsets.
 */
public class CourseDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private CourseContent.CourseItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CourseDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = CourseContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();

            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
                appBarLayout.setExpandedTitleColor(ContextCompat.getColor(activity, android.R.color.transparent));

                ImageView appBarImg = (ImageView) activity.findViewById(R.id.backdrop);
                appBarImg.setImageDrawable(ContextCompat.getDrawable(activity, mItem.imageId));
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.course_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.id)).setText(mItem.id);
            ((TextView) rootView.findViewById(R.id.content)).setText(mItem.content);
            ((TextView) rootView.findViewById(R.id.course_detail)).setText(mItem.lessonList);
        }

        return rootView;
    }
}
