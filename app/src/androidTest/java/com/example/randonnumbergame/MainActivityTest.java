package com.example.randonnumbergame;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@LargeTest
public class MainActivityTest {

    ActivityScenario<OnBoarding> scenario;

    @Before
    public void setup(){
        scenario = ActivityScenario.launch(OnBoarding.class);
        scenario.moveToState(Lifecycle.State.RESUMED);
    }

    @Test
    public void testPLayingGame() {
        onView(withId(R.id.on_boarding_btn)).perform(click());
        onView(withId(R.id.on_boarding_btn)).perform(click());
        onView(withId(R.id.on_boarding_btn)).perform(click());
        onView(withId(R.id.on_boarding_btn)).perform(click());

        onView(withId(R.id.easy)).perform(click());

        String randomNumber = "555";
        onView(withId(R.id.enternumber)).perform(ViewActions.typeText(randomNumber));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.trythisbutton)).perform(click());
        onView(withId(R.id.enternumber)).perform(ViewActions.clearText());

        String randomNumber1 = "5995";
        onView(withId(R.id.enternumber)).perform(ViewActions.typeText(randomNumber1));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.trythisbutton)).perform(click());
        onView(withId(R.id.enternumber)).perform(ViewActions.clearText());

        String randomNumber2 = "5555";
        onView(withId(R.id.enternumber)).perform(ViewActions.typeText(randomNumber2));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.trythisbutton)).perform(click());
        onView(withId(R.id.enternumber)).perform(ViewActions.clearText());

        String randomNumber3 = "55";
        onView(withId(R.id.enternumber)).perform(ViewActions.typeText(randomNumber3));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.trythisbutton)).perform(click());
        onView(withId(R.id.enternumber)).perform(ViewActions.clearText());

        String randomNumber4 = "66";
        onView(withId(R.id.enternumber)).perform(ViewActions.typeText(randomNumber4));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.trythisbutton)).perform(click());
        onView(withId(R.id.enternumber)).perform(ViewActions.clearText());

    }
}