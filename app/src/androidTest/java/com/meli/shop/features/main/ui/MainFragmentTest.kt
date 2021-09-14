package com.meli.shop.features.main.ui

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.meli.shop.R
import junit.framework.Assert
import org.hamcrest.Matcher
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Luis Ordoñez on 12/09/2021.
 */

@RunWith(AndroidJUnit4::class)
class MainFragmentTest{

    @Test
    fun testEventFragment() {
        launchFragmentInContainer<MainFragment>()
        onView(withId(R.id.editTextSearch))
            .check(ViewAssertions.matches(ViewMatchers.withText("Search Products")))
    }

    @Test
    fun testNavigationToInGameScreen() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val scenario = launchFragmentInContainer<MainFragment>()

        scenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.recyclerViewSearchResults))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ProductAdapter.ViewHolder>(1,clickItemWithId(R.id.cardView)))

        // Verify that performing a click changes the NavController’s state
        Assert.assertEquals(navController.currentDestination?.id, R.id.detailFragment)
    }

    fun clickItemWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id) as View
                v.performClick()
            }
        }
    }
}