package com.example.cardiacrecord;

import androidx.test.espresso.Espresso;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
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


public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testAddButton() {
        //To sign up
        onView(withId(R.id.idTVRegister)).perform(click());
        onView(withId(R.id.idEdtUserName)).perform(ViewActions.typeText("kazol196295@gmail.com"));
        pressBack();
        onView(withId(R.id.idEdtPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idedtCnfPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idBtnLogin)).perform(click());
        //tO SIGN iN

        onView(withId(R.id.idEdtUserName)).perform(ViewActions.typeText("kazol196295@gmail.com"));
        pressBack();
        onView(withId(R.id.idEdtPwd)).perform(ViewActions.typeText("amardesh"));
        pressBack();
        onView(withId(R.id.idBtnLogin)).perform(click());

        /*
        add
         */
        onView(withId(R.id.idFABAddUser)).perform(click());
        //onView(withId(R.id.dateValue)).perform(ViewActions.typeText("12/10/2021"));
        //onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
        onView(withId(R.id.idName)).perform(ViewActions.typeText("kazol"));
        pressBack();
        onView(withId(R.id.idsPressure)).perform(ViewActions.typeText("120"));
        pressBack();
        onView(withId(R.id.idDPressure)).perform(ViewActions.typeText("90"));
        pressBack();
        onView(withId(R.id.idHeart)).perform(ViewActions.typeText("80"));
        pressBack();
        onView(withId(R.id.idComment)).perform(ViewActions.typeText("UI test data insert"));
        pressBack();

        onView(withId(R.id.idBtnAdd)).perform(click());


        // onView(withId(R.id.AddBUttonId)).perform(click());
//        onView(withId(R.id.dateValue)).perform(ViewActions.typeText("13/10/2021"));
//        onView(withId(R.id.timeValue)).perform(ViewActions.typeText("10:19"));
//        onView(withId(R.id.systolicValue)).perform(ViewActions.typeText("130"));
//        onView(withId(R.id.diastolicValue)).perform(ViewActions.typeText("90"));
//        // pressBack();
//        onView(withId(R.id.heartRateValue)).perform(ViewActions.typeText("70"));
//        pressBack();
//        onView(withId(R.id.commentValue)).perform(ViewActions.typeText("UI test data insert"));
//        pressBack();
//       // onView(withId(R.id.addButton)).perform(click());
//        onView(withId(R.id.addButton)).perform(click());



        // UserRVAdapter.userRVModalArrayList.clear();




        /*
        To view
         */
        // First scroll to the position that needs to be matched and click on it.



//        onView(ViewMatchers.withId(R.id.idRVUser))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//        pressBack();
////
////        /*
////        To update
////         */
////        // Match the text in an item below the fold and check that it's displayed.
//        onView(withId(R.id.idRVUser)).perform(
//                RecyclerViewActions.actionOnItemAtPosition(0, JamiViewAction.clickChildViewWithId(R.id.Edit_buttonId)));
//        onView(withId(R.id.UdateValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UdateValue)).perform(ViewActions.typeText("11/10/2021"));
//        onView(withId(R.id.UtimeValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UtimeValue)).perform(ViewActions.typeText("10:19"));
//        onView(withId(R.id.UsystolicValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UsystolicValue)).perform(ViewActions.typeText("110"));
//        onView(withId(R.id.UdiastolicValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UdiastolicValue)).perform(ViewActions.typeText("80"));
//        // pressBack();
//        onView(withId(R.id.UheartRateValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UheartRateValue)).perform(ViewActions.typeText("70"));
//        pressBack();
//        onView(withId(R.id.UcommentValue)).perform(ViewActions.clearText());
//        onView(withId(R.id.UcommentValue)).perform(ViewActions.typeText("Updated"));
//        pressBack();
//        onView(withId(R.id.UpdateButtonId)).perform(click());
//
//      /*
//        To delete
//        */
//
//        onView(withId(R.id.recyclarView)).perform(
//                RecyclerViewActions.actionOnItemAtPosition(0, JamiViewAction.clickChildViewWithId(R.id.DeleteBUttonId)));
//
//        RecordList.mcl.clear();
//        new Utils().saveData(InstrumentationRegistry.getInstrumentation().getContext());

    }


//    @Test
//    public void testAddNewData() {
//        // Enter name
//        onView(ViewMatchers.withId(R.id.idName))
//                .perform(ViewActions.typeText("John Doe"), ViewActions.closeSoftKeyboard());
//
//        // Enter systolic pressure
//        onView(ViewMatchers.withId(R.id.idsPressure))
//                .perform(ViewActions.typeText("120"), ViewActions.closeSoftKeyboard());
//
//        // Enter diastolic pressure
//        onView(ViewMatchers.withId(R.id.idDPressure))
//                .perform(ViewActions.typeText("80"), ViewActions.closeSoftKeyboard());
//
//        // Enter heart rate
//        onView(ViewMatchers.withId(R.id.idHeart))
//                .perform(ViewActions.typeText("70"), ViewActions.closeSoftKeyboard());
//
//        // Enter comment
//        onView(ViewMatchers.withId(R.id.idComment))
//                .perform(ViewActions.typeText("This is a test comment"), ViewActions.closeSoftKeyboard());
//
//        // Click the "Add" button
//        onView(ViewMatchers.withId(R.id.idBtnAdd))
//                .perform(ViewActions.click());
//
//        // Add any additional assertions or verifications after adding the data
//        // ...
//    }

}