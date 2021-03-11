package com.techyourchance.dagger2course.common.composition

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class ActivityCompositionRoot(private val activity: AppCompatActivity, private val appCompositionRoot: AppCompositionRoot) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }
    val layoutInflater get() = activity.layoutInflater
    val fragmentManager get() = activity.supportFragmentManager
    val stackOverflowApi get() = appCompositionRoot.stackOverflowApi
}