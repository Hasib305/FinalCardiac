/**
 * This class contains UI tests for the RegistrationActivity.
 */
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

    /**
     * Test the registration process and various UI actions in the RegistrationActivity.
     */
    @Test
    public void testRegInPage() {

        // Enter registration details
        onView(withId(R.id.idEdtUserName)).perform(ViewActions.typeText("kazol9629445@outloo.com"));
        pressBack();
        onView(withId(R.id.idEdtPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idedtCnfPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idBtnRegister)).perform(click());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Add user details
        onView(withId(R.id.idFABAddUser)).perform(click());
        onView(withId(R.id.idName)).perform(ViewActions.typeText("kazol"));
        pressBack();
        onView(withId(R.id.idsPressure)).perform(ViewActions.typeText("120"));
        pressBack();
        onView(withId(R.id.idDPressure)).perform(ViewActions.typeText("1"));
        pressBack();
        onView(withId(R.id.idHeart)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.idComment)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();

        onView(withId(R.id.idBtnUpdate)).perform(click());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform a click action on the CardView at position 0
        onView(ViewMatchers.withId(R.id.idRVUser))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Perform update action
        onView(withId(R.id.idBtnU)).perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.idDPressure)).perform(ViewActions.typeText("1"));
        pressBack();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.idBtnUpdate)).perform(click());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform another click action on the CardView at position 0
        onView(ViewMatchers.withId(R.id.idRVUser))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Perform update action
        onView(withId(R.id.idBtnU)).perform(click());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Modify comment and delete user
        onView(withId(R.id.idComment)).perform(ViewActions.typeText("."));
        pressBack();
        onView(withId(R.id.idBtnDelete)).perform(click());
    }
}
