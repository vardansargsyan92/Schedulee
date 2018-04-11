package com.xamlab.schedulee;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xamlab.schedulee.views.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void useAppContext() {
        // Context of the app under test.


        /*Context appContext = InstrumentationRegistry.getTargetContext();*/
        onView(withId(R.id.email_et)).perform(typeText("valoda"));
        onView(withId(R.id.email_et)).perform(closeSoftKeyboard());
        onView(withId(R.id.validate_btn)).perform(click()).check(matches(not(isEnabled())));

        /*assertEquals("com.xamlab.schedulee", appContext.getPackageName());*/
    }
}
