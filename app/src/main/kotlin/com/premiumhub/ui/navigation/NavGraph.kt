// File: NavGraph.kt
package com.premiumhub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Splash Screen
        composable(Screen.Splash.route) {
            // SplashScreen(navController)
        }
        
        // Auth Screens
        composable(Screen.Login.route) {
            // LoginScreen(navController)
        }
        
        composable(Screen.Signup.route) {
            // SignupScreen(navController)
        }
        
        // Admin Screens
        composable(Screen.AdminDashboard.route) {
            // AdminDashboardScreen(navController)
        }
        
        composable(Screen.ManageStaff.route) {
            // ManageStaffScreen(navController)
        }
        
        composable(Screen.StaffApproval.route) {
            // StaffApprovalScreen(navController)
        }
        
        composable(Screen.ViewReports.route) {
            // ViewReportsScreen(navController)
        }
        
        // Staff Screens
        composable(Screen.StaffDashboard.route) {
            // StaffDashboardScreen(navController)
        }
        
        composable(Screen.UploadSales.route) {
            // UploadSalesScreen(navController)
        }
        
        // Stock Screens
        composable(Screen.StockManagement.route) {
            // StockManagementScreen(navController)
        }
        
        composable(Screen.AddStock.route) {
            // AddStockScreen(navController)
        }
        
        // Sales Screens
        composable(Screen.SalesList.route) {
            // SalesListScreen(navController)
        }
        
        // Attendance Screens
        composable(Screen.Attendance.route) {
            // AttendanceScreen(navController)
        }
        
        composable(Screen.AttendanceHistory.route) {
            // AttendanceHistoryScreen(navController)
        }
        
        // Other Screens
        composable(Screen.Notifications.route) {
            // NotificationScreen(navController)
        }
        
        composable(Screen.Settings.route) {
            // SettingsScreen(navController)
        }
        
        composable(Screen.Profile.route) {
            // ProfileScreen(navController)
        }
    }
}