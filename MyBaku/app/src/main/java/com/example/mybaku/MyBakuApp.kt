package com.example.mybaku

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mybaku.ui.AttractionsScreen
import com.example.mybaku.ui.CategoryScreen
import com.example.mybaku.ui.DetailsScreen
import com.example.mybaku.ui.MainCityScreen
import com.example.mybaku.ui.MyBakuViewModel
import com.example.mybaku.ui.ParkScreen
import com.example.mybaku.ui.ShoppingScreen

enum class MyBakuScreens(@StringRes val title: Int) {
    MainCityScreen(title = R.string.start),
    CategoryScreen(title = R.string.categories),
    Attractions(title = R.string.attractions),
    Parks(title = R.string.parks),
    ShoppingCenters(title = R.string.shoppingcenters),

    DetailsScreen(title = R.string.details)
}

enum class BakuContentType {
    LIST_ONLY,
    LIST_AND_DETAIL
}

@Composable
fun MyBakuApp(
    navController: NavHostController = rememberNavController(),
    windowSize: WindowSizeClass,
    modifier: Modifier
) {
    // TODO: Create Controller and initialization
    val backStackEntry by navController.currentBackStackEntryAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyBakuScreens.valueOf(
        backStackEntry?.destination?.route ?: MyBakuScreens.MainCityScreen.name
    )
    val currentRoute = navBackStackEntry?.destination?.route


    // TODO: Create ViewModel
    val viewModel: MyBakuViewModel = viewModel()

    Scaffold(
        topBar = {
            BakuTopAppBar(
                currentScreen = currentRoute,
                backStackEntry = navBackStackEntry,
                navController = navController,
                modifier = modifier
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyBakuScreens.MainCityScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyBakuScreens.MainCityScreen.name) {
                MainCityScreen(
                    uiState = uiState,
                    nextButtonClicked = {
                        navController.navigate(MyBakuScreens.CategoryScreen.name)
                    },
                    modifier = modifier
                )
            }

            composable(route = MyBakuScreens.CategoryScreen.name) {
                CategoryScreen(
                    onCategoryClicked = { category ->
                        if (category.name == "Shopping Centers") {
                            navController.navigate(MyBakuScreens.ShoppingCenters.name)
                        } else if (category.name == "Parks") {
                            navController.navigate(MyBakuScreens.Parks.name)
                        } else if (category.name == "Attractions") {
                            navController.navigate(MyBakuScreens.Attractions.name)
                        }
                    },
                    modifier = modifier
                )
            }

            composable(route = MyBakuScreens.Attractions.name) {
                AttractionsScreen(
                    uiState = uiState,
                    onAttractionClicked = { attraction ->
                        viewModel.subCategoryUpdate(attraction)
                        navController.navigate(MyBakuScreens.DetailsScreen.name)
                    },
                    modifier = modifier
                )
            }

            composable(route = MyBakuScreens.Parks.name) {
                ParkScreen(
                    uiState = uiState,
                    onParkClicked = { park ->
                        viewModel.subCategoryUpdate(park)
                        navController.navigate(MyBakuScreens.DetailsScreen.name)
                    },
                    modifier = modifier
                )
            }

            composable(route = MyBakuScreens.ShoppingCenters.name) {
                ShoppingScreen(
                    uiState = uiState,
                    onShoppingClicked = { shoppingCenter ->
                        viewModel.subCategoryUpdate(shoppingCenter)
                        navController.navigate(MyBakuScreens.DetailsScreen.name)
                    },
                    modifier = modifier
                )
            }

            composable(route = MyBakuScreens.DetailsScreen.name) {
                DetailsScreen(
                    uiState = uiState,
                    modifier = modifier
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BakuTopAppBar(
    currentScreen: String?,
    backStackEntry: NavBackStackEntry?,
    navController: NavHostController,
    modifier: Modifier
) {
    val title = when (currentScreen) {
        MyBakuScreens.MainCityScreen.name -> "MyBaku App"
        MyBakuScreens.CategoryScreen.name -> "Categories"
        MyBakuScreens.Attractions.name -> "Attractions"
        MyBakuScreens.Parks.name -> "Parks"
        MyBakuScreens.ShoppingCenters.name -> "Shopping Centers"
        MyBakuScreens.DetailsScreen.name -> "Details"
        else -> "MyBaku App"
    }

    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}