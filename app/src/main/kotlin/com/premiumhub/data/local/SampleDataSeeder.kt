package com.premiumhub.data.local

import com.premiumhub.data.local.dao.*
import com.premiumhub.data.local.entity.*
import java.text.SimpleDateFormat
import java.util.*

object SampleDataSeeder {
    
    suspend fun populateDatabase(
        userDao: UserDao,
        shopDao: ShopDao,
        stockDao: StockDao,
        salesDao: SalesDao,
        attendanceDao: AttendanceDao
    ) {
        // Create sample shops
        val shops = listOf(
            ShopEntity(
                id = 1,
                name = "Shop 1",
                type = "MOBILE_SHOP",
                address = "Main Market, City Center",
                phone = "9876543210"
            ),
            ShopEntity(
                id = 2,
                name = "Shop 2",
                type = "MOBILE_SHOP",
                address = "Mall Road, Downtown",
                phone = "9876543211"
            ),
            ShopEntity(
                id = 3,
                name = "Repair Center",
                type = "REPAIR_CENTER",
                address = "Tech Park, Block A",
                phone = "9876543212"
            )
        )
        shopDao.insertShops(shops)
        
        // Create admin user
        val admin = UserEntity(
            id = 1,
            name = "Admin",
            email = "admin@premiumhub.com",
            password = "admin123", // In production, use hashed passwords!
            role = "ADMIN",
            isApproved = true
        )
        userDao.insertUser(admin)
        
        // Create sample staff users
        val staff = listOf(
            UserEntity(
                id = 2,
                name = "Rahul Kumar",
                email = "rahul@premiumhub.com",
                password = "staff123",
                role = "STAFF",
                isApproved = true,
                shopId = 1
            ),
            UserEntity(
                id = 3,
                name = "Priya Sharma",
                email = "priya@premiumhub.com",
                password = "staff123",
                role = "STAFF",
                isApproved = true,
                shopId = 2
            ),
            UserEntity(
                id = 4,
                name = "Amit Singh",
                email = "amit@premiumhub.com",
                password = "staff123",
                role = "STAFF",
                isApproved = true,
                shopId = 3
            ),
            UserEntity(
                id = 5,
                name = "Neha Gupta",
                email = "neha@premiumhub.com",
                password = "staff123",
                role = "STAFF",
                isApproved = false, // Pending approval
                shopId = 1
            )
        )
        staff.forEach { userDao.insertUser(it) }
        
        // Create sample stock items
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(Date())
        
        val stocks = listOf(
            // Shop 1 stocks
            StockEntity(
                itemName = "iPhone 15 Pro",
                quantity = 15,
                category = "Smartphones",
                shopId = 1,
                addedBy = "rahul@premiumhub.com"
            ),
            StockEntity(
                itemName = "Samsung Galaxy S24",
                quantity = 20,
                category = "Smartphones",
                shopId = 1,
                addedBy = "rahul@premiumhub.com"
            ),
            StockEntity(
                itemName = "AirPods Pro",
                quantity = 3, // Low stock!
                category = "Accessories",
                shopId = 1,
                addedBy = "rahul@premiumhub.com"
            ),
            // Shop 2 stocks
            StockEntity(
                itemName = "OnePlus 12",
                quantity = 25,
                category = "Smartphones",
                shopId = 2,
                addedBy = "priya@premiumhub.com"
            ),
            StockEntity(
                itemName = "Xiaomi 14",
                quantity = 18,
                category = "Smartphones",
                shopId = 2,
                addedBy = "priya@premiumhub.com"
            ),
            StockEntity(
                itemName = "Phone Cases",
                quantity = 2, // Low stock!
                category = "Accessories",
                shopId = 2,
                addedBy = "priya@premiumhub.com"
            ),
            // Repair Center stocks
            StockEntity(
                itemName = "Screen Protectors",
                quantity = 50,
                category = "Accessories",
                shopId = 3,
                addedBy = "amit@premiumhub.com"
            ),
            StockEntity(
                itemName = "Repair Tools Kit",
                quantity = 10,
                category = "Tools",
                shopId = 3,
                addedBy = "amit@premiumhub.com"
            )
        )
        stocks.forEach { stockDao.insertStock(it) }
        
        // Create sample sales for today
        val sales = listOf(
            SalesEntity(
                shopName = "Shop 1",
                shopId = 1,
                staffName = "Rahul Kumar",
                staffEmail = "rahul@premiumhub.com",
                totalSales = 125000.0,
                cashSales = 75000.0,
                onlineSales = 50000.0,
                date = today,
                notes = "Good day! Sold 3 iPhones"
            ),
            SalesEntity(
                shopName = "Shop 2",
                shopId = 2,
                staffName = "Priya Sharma",
                staffEmail = "priya@premiumhub.com",
                totalSales = 95000.0,
                cashSales = 55000.0,
                onlineSales = 40000.0,
                date = today,
                notes = "Sold 2 OnePlus and 1 Xiaomi"
            ),
            SalesEntity(
                shopName = "Repair Center",
                shopId = 3,
                staffName = "Amit Singh",
                staffEmail = "amit@premiumhub.com",
                totalSales = 15000.0,
                cashSales = 10000.0,
                onlineSales = 5000.0,
                date = today,
                notes = "5 screen repairs done"
            )
        )
        sales.forEach { salesDao.insertSale(it) }
        
        // Create sample attendance
        val attendance = listOf(
            AttendanceEntity(
                staffName = "Rahul Kumar",
                staffEmail = "rahul@premiumhub.com",
                shopId = 1,
                date = today,
                status = "PRESENT",
                checkInTime = "09:00 AM",
                checkOutTime = "06:00 PM"
            ),
            AttendanceEntity(
                staffName = "Priya Sharma",
                staffEmail = "priya@premiumhub.com",
                shopId = 2,
                date = today,
                status = "PRESENT",
                checkInTime = "09:15 AM"
            ),
            AttendanceEntity(
                staffName = "Amit Singh",
                staffEmail = "amit@premiumhub.com",
                shopId = 3,
                date = today,
                status = "PRESENT",
                checkInTime = "09:30 AM"
            )
        )
        attendance.forEach { attendanceDao.insertAttendance(it) }
    }
}