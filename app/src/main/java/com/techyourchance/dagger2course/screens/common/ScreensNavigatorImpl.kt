package com.techyourchance.dagger2course.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.di.activity.ActivityScope
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor (private val activity: AppCompatActivity): ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }
    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}