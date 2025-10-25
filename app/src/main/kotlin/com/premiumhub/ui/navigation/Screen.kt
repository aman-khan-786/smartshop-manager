// File: Screen.kt
package com.premiumhub.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Signup : Screen("signup")
    
    // Admin Screens
    object AdminDashboard : Screen("admin_dashboard")
    object ManageStaff : Screen("manage_staff")
    object StaffApproval : Screen("staff_approval")
    object ViewReports : Screen("view_reports")
    
    // Staff Screens
    object StaffDashboard : Screen("staff_dashboard")
    object UploadSales : Screen("upload_sales")
    
    // Common Screens
    object StockManagement : Screen("stock_management")
    object AddStock : Screen("add_stock")
    object EditStock : Screen("edit_stock/{stockId}") {
        fun createRoute(stockId: Int) = "edit_stock/$stockId"
    }
    
    object SalesList : Screen("sales_list")
    object SalesDetail : Screen("sales_detail/{saleId}") {
        fun createRoute(saleId: Int) = "sales_detail/$saleId"
    }
    
    object Attendance : Screen("attendance")
    object AttendanceHistory : Screen("attendance_history")
    
    object Notifications : Screen("notifications")
    object Settings : Screen("settings")
    object Profile : Screen("profile")
}