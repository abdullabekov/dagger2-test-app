package com.techyourchance.dagger2course.screens.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }
    protected val injector: PresentationComponent get() = presentationComponent
}