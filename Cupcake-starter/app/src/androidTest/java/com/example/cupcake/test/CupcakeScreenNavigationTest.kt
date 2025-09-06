package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import org.junit.Rule
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import com.example.cupcake.CupcakeScreen
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

@get :Rule
val composeTestRule = createAndroidComposeRule<ComponentActivity>()

class CupcakeScreenNavigationTest {
    private lateinit var navController: TestNavHostController

    @Before
    fun setupCupcakeNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    @Test
    fun cupcakeNavHost_verifyStartDestination() {
        assertEquals(CupcakeScreen.Start.name, navController.currentBackStackEntry?.destination?.route)
    }
}
