package intentional.casterio.com.intentional.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import intentional.casterio.com.intentional.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CourseContent {

    /**
     * An array of sample items.
     */
    public static final List<CourseItem> ITEMS = new ArrayList<CourseItem>();

    /**
     * A map of sample items, by ID.
     */
    public static final Map<String, CourseItem> ITEM_MAP = new HashMap<String, CourseItem>();

    static {
        // Add some sample items.
        addItem(createCourseItem(1, "Android Build Variants", makeLessons("In this series you will be introduced to Android Build Variants. You will learn how to add a debug suffix to a debug build and you’ll also learn how to inspect an APK badging using the aapt build tool. You’ll learn how to configure your application for different build configurations and how that can help you with development and production and more.", 1), R.drawable.android_build_variants_sm));
        addItem(createCourseItem(2, "Event Bus", makeLessons("In this course you will be introduced to the Green Robot Event Bus. You will learn how to use the event bus to decouple your application. You will also learn about the various thread modes that Event Bus offers. ", 2), R.drawable.event_bus_sm));
        addItem(createCourseItem(3, "Material Design", makeLessons("In this course you’ll be exposed to various components in the Material Design guidelines. We start off with the Collapsing Toolbar Layout with many more lessons from various instructors to come.", 3), R.drawable.material_design_cover_sm));
        addItem(createCourseItem(4, "Mock Web Server", makeLessons("Testing your application when you use an API has always been quite difficult. Enter MockWebServer. Using MockWebServer you can mock out your API to return the values that you expect during test. This will make your application easier to test and your test more reliable. Learn how to use MockWebServer in this course.", 4), R.drawable.mockwebserver_sm));
        addItem(createCourseItem(5, "Timber Logging", makeLessons("Timber is an easy-to-use and easy-to-customize logging framework for Android. In this course you will learn how to install, configure and customize the Timber Logging library for use in your Android Application.", 5), R.drawable.timber_course_sm));
        addItem(createCourseItem(6, "Espresso Idling Resources", makeLessons("In this course you will learn all about Espresso’s Idling Resource. You’ll learn how it works and how you can build your own custom idling resource to help you with your Android testing.", 6), R.drawable.espresso_idling_sm));
    }

    private static void addItem(CourseItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static CourseItem getItem(int position) {
        return ITEM_MAP.get(position);
    }

    private static CourseItem createCourseItem(int position, String title, String content, int imgId) {
        return new CourseItem(String.valueOf(position), title, content, imgId);
    }

    /**
     * helper class to make dummy data for content
     * @param numLessons
     * @return
     */
    private static String makeLessons(String detailString, int numLessons) {
        StringBuilder builder = new StringBuilder();

        builder.append(detailString + "\n\nLessons for this course: ").append(numLessons);
        builder.append("\n");
        for (int i = 0; i < numLessons; i++) {
            builder.append("\n* Lesson Information");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CourseItem {
        public final String id;
        public final int imageId;
        public final String content;
        public final String lessonList;

        public CourseItem(String id, String content, String lessonsIn, int imgResId) {
            this.id = id;
            this.content = content;
            this.lessonList = lessonsIn;
            this.imageId = imgResId;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
