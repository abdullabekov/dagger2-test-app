package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.di.activity.ActivityComponent
import com.techyourchance.dagger2course.common.di.activity.ActivityModule
import com.techyourchance.dagger2course.common.di.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.di.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .appComponent((application as MyApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .activityComponent(activityComponent)
                .presentationModule(PresentationModule())
                .build()
    }

    protected val injector get() = presentationComponent
}