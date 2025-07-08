package network.chaintech.kmpdatetimepickerdemo.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object AppConstants {
    const val BACK_CLICK_ROUTE = "BACK_CLICK_ROUTE"
    const val NAV_DETAILS_SCREEN = "nav_details_screen"
}

data class NavigationData(
    val routeName: String,
    val data: Int = 0
)

@Serializable
object DatePickerListScreenRoute

@Serializable
data class DatePickerDetailScreenRoute(val type: Int)


@Composable
fun DateTimePickerNav() {
    val navController = rememberNavController()

    NavHostMain(
        navController = navController,
        onNavigate = { routeName ->
            navigateTo(routeName, navController)
        }
    )
}

@Composable
fun NavHostMain(
    navController: NavHostController = rememberNavController(),
    onNavigate: (navigationData: NavigationData) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = DatePickerListScreenRoute,
        modifier = Modifier
            .fillMaxSize(),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(500)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(500)
            )
        }
    ) {
        composable<DatePickerListScreenRoute> {
            DatePickerListScreen(onNavigate)
        }

        composable<DatePickerDetailScreenRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<DatePickerDetailScreenRoute>()
            DatePickerDetailScreen(args.type, onNavigate)
        }
    }
}

fun navigateTo(
    navigationData: NavigationData,
    navController: NavController
) {
    when (navigationData.routeName) {
        AppConstants.BACK_CLICK_ROUTE -> {
            navController.popBackStack()
        }

        AppConstants.NAV_DETAILS_SCREEN -> {
            navController.navigate(DatePickerDetailScreenRoute(type = navigationData.data))
        }

        else -> {
            navController.navigate(navigationData.routeName)
        }
    }
}