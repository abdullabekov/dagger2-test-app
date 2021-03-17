package com.techyourchance.dagger2course.common.di

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
        private val activity: AppCompatActivity,
        private val appCompositionRoot: AppCompositionRoot
) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }
    val application get() = appCompositionRoot.application
    val layoutInflater get() = activity.layoutInflater
    val fragmentManager get() = activity.supportFragmentManager
    val stackOverflowApi get() = appCompositionRoot.stackOverflowApi
}