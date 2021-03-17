package com.techyourchance.dagger2course.common.di

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {
    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    private val stackOverflowApi get() = activityCompositionRoot.stackOverflowApi

    val screensNavigator get() = activityCompositionRoot.screensNavigator

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val dialogsNavigator: DialogsNavigator get() = DialogsNavigator(fragmentManager)

    val fetchQuestionsUseCase: FetchQuestionsUseCase get() = FetchQuestionsUseCase(stackOverflowApi)
    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackOverflowApi)

}