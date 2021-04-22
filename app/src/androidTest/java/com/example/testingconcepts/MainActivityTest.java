package com.example.testingconcepts;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.not;

public class MainActivityTest {
    public static final String USER_TO_BE_TYPED = "jony";
    public static final String PASS_TO_BE_TYPED = "123";
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void displayed(){
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.boton)).check(matches(isDisplayed()));
    }

    @Test
    public void correctText(){
        onView(withId(R.id.title)).check(matches(withText(R.string.app_name)));
        onView(withId(R.id.boton)).check(matches(withText(R.string.next)));
    }

    @Test
    public void buttonChanges(){
        onView(withId(R.id.boton))
                .check(matches(isClickable()))
                .perform(click())
                .check(matches(withText(R.string.back)));
    }

    @Test
    public void login(){
        onView(withId(R.id.username))
                .perform(typeText(USER_TO_BE_TYPED))
                .check(matches(withText(USER_TO_BE_TYPED)))
                .perform(closeSoftKeyboard())
                .check(matches(not(withText(""))));
        onView(withId(R.id.password))
                .perform(typeText(PASS_TO_BE_TYPED))
                .check(matches(withText(PASS_TO_BE_TYPED)))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.boton))
                .check(matches(isClickable()))
                .perform(click());


    }

    @Test
    public void changeActivity(){
        onView(withId(R.id.boton))
                .perform(click());
        onView(withId(R.id.mainactivity2))
                .check(matches(isDisplayed()));
    }

    @Test
    public void changeActivityToSecond(){
        changeActivity();
        onView(withId(R.id.back))
                .perform(click());
        onView(withId(R.id.mainactivity1))
                .check(matches(isDisplayed()));
    }

    @Test
    public void fullTest(){
        login();
    }
}