package com.nexifotech.edumanage.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nexifotech.edumanage.RoleManageCache
import com.nexifotech.edumanage.screen.common.LoginScreen
import com.nexifotech.edumanage.screen.common.SplashScreen

@Composable
fun AppRootNav(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Splash.route
    ){
        //---- SPLASH -----
        composable(NavigationRoutes.Splash.route) {
            SplashScreen(
                onFinish = {
                    val savedRole = RoleManageCache.getRole()

                    if (savedRole == null){
                        navController.navigate(NavigationRoutes.Login.route){
                            popUpTo (NavigationRoutes.Splash.route){ inclusive = true }
                        }
                    }else{
                        when(savedRole){
                            "Student" -> navController.navigate(NavigationRoutes.StudentRoot.route){
                                popUpTo (NavigationRoutes.Splash.route){ inclusive = true }
                            }
                            "Teacher" -> navController.navigate(NavigationRoutes.TeacherRoot.route){
                                popUpTo (NavigationRoutes.Splash.route){ inclusive = true }
                            }
                            "Admin" -> navController.navigate(NavigationRoutes.AdminRoot.route){
                                popUpTo (NavigationRoutes.Splash.route){ inclusive = true }
                            }
                        }

                    }
                }
            )
        }

        // --- LOGIN ---
        composable(NavigationRoutes.Login.route) {
            LoginScreen(
                onLogin = {role->
                    RoleManageCache.saveRole(role)
                    when(role){
                        "Student" -> navController.navigate(NavigationRoutes.StudentRoot.route){
                            popUpTo (NavigationRoutes.Login.route){ inclusive = true }
                        }
                        "Teacher" -> navController.navigate(NavigationRoutes.TeacherRoot.route){
                            popUpTo (NavigationRoutes.Login.route){ inclusive = true }
                        }
                        "Admin" -> navController.navigate(NavigationRoutes.AdminRoot.route){
                            popUpTo (NavigationRoutes.Login.route){ inclusive = true }
                        }
                    }

                }, onSignupClick = {
                    navController.navigate(NavigationRoutes.Signup.route)
                }
            )
        }

        studentGraph(navController)
        teacherGraph(navController)
        adminGraph(navController)

    }
}