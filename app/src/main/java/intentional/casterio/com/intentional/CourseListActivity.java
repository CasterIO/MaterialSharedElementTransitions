package intentional.casterio.com.intentional;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import intentional.casterio.com.intentional.content.CourseContent;

/**
 * An activity representing a list of Courses. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CourseDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CourseListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private Activity mActivity;

    //SharedElementTransition Names
    private String transImg;
    private String transTitle;
    private String transNum;
    private String transDesc;
    private String transPageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        mActivity = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        transImg = mActivity.getString(R.string.trans_img);
        transTitle = mActivity.getString(R.string.trans_title);
        transNum = mActivity.getString(R.string.trans_num);
        transDesc = mActivity.getString(R.string.trans_desc);
        transPageTitle = mActivity.getString(R.string.trans_page_title);

        View recyclerView = findViewById(R.id.course_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(CourseContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<CourseContent.CourseItem> mValues;
        private Context cxt;

        public SimpleItemRecyclerViewAdapter(List<CourseContent.CourseItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.course_list_content, parent, false);
            cxt = view.getContext();
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);
            holder.mSnippetView.setText(mValues.get(position).lessonList);
            holder.courseLogo.setImageDrawable(ContextCompat.getDrawable(cxt, mValues.get(position).imageId));

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), CourseDetailActivity.class);
                    intent.putExtra(CourseDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                    //Transition Using Hero Image
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.courseLogo.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                    }
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, (View) holder.courseLogo, transImg);

                    //Transition using Number
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.mIdView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                    }
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, (View) holder.mIdView, transNum);

                    //Transition using Title
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.mContentView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                    }
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, (View) holder.mContentView, transTitle);
//
                    //Transition using Course Description
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.mSnippetView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                    }
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, (View) holder.mSnippetViewView, transDesc);

                    //Transition with Multiple Views - OK, all the text items move together - maintaining focus
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.mIdView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mContentView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mSnippetView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//
//                    }
//                    Pair<View, String> p1 = Pair.create((View) holder.mIdView, transNum);
//                    Pair<View, String> p2 = Pair.create((View) holder.mContentView, transTitle);
//                    Pair<View, String> p3 = Pair.create((View) holder.mSnippetView, transDesc);
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, p1, p2, p3);

                    //Transition with Multiple Views #2 - Bad Views Cross other views during transition
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.mIdView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mContentView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//
//                    }
//                    Pair<View, String> p1 = Pair.create((View) holder.mIdView, transNum);
//                    Pair<View, String> p2 = Pair.create((View) holder.mContentView, transTitle);
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, p1, p2);

                    //Transition with ALL Views - Really Bad and confusing too much distracting motion
//                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        holder.courseLogo.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mIdView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mContentView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//                        holder.mSnippetView.setForeground(ContextCompat.getDrawable(mActivity, R.drawable.bound_rect));
//
//                    }
//                    Pair<View, String> p1 = Pair.create((View) holder.mIdView, transNum);
//                    Pair<View, String> p2 = Pair.create((View) holder.mContentView, transTitle);
//                    Pair<View, String> p3 = Pair.create((View) holder.mSnippetView, transDesc);
//                    Pair<View, String> p4 = Pair.create((View) holder.courseLogo, transImg);
//                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, p1, p2, p3, p4);


                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startActivity(intent, options.toBundle());
                    } else {
                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public final TextView mSnippetView;
            public final ImageView courseLogo;
            public CourseContent.CourseItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                mSnippetView = (TextView) view.findViewById(R.id.content_snippet);
                courseLogo = (ImageView) view.findViewById(R.id.course_logo);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
