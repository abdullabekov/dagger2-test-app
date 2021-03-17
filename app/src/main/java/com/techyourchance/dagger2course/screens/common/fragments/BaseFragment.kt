package com.techyourchance.dagger2course.screens.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.di.Injector
import com.techyourchance.dagger2course.common.di.PresentationCompositionRoot
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {
    private val compositionRoot
            by lazy { PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot) }

    protected val injector get() = Injector(compositionRoot)
}