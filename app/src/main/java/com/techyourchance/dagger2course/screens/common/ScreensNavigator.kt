package com.techyourchance.dagger2course.screens.common

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.di.activity.ActivityScope
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

interface ScreensNavigator {
    fun navigateBack()
    fun toQuestionDetails(questionId: String)
}