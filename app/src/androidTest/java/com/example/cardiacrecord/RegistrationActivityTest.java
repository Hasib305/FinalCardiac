package com.example.cardiacrecord;

import static org.junit.Assert.*;
import androidx.test.espresso.Espresso;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;


@RunWith(JUnit4.class)
@LargeTest


public class RegistrationActivityTest {

    @Rule
    public ActivityScenarioRule<RegistrationActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(RegistrationActivity.class);

    @Test
    public void testRegInPage() {

        //onView(withId(R.id.idTVRegister)).perform(click());
        onView(withId(R.id.idEdtUserName)).perform(ViewActions.typeText("kazol196295@outlook.com"));
        pressBack();
        onView(withId(R.id.idEdtPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idedtCnfPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idBtnRegister)).perform(click());
    }


}