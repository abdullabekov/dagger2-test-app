package com.techyourchance.dagger2course.common.di.activity

import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationModule
import com.techyourchance.dagger2course.common.di.presentation.UseCasesModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(
            presentationModule: PresentationModule,
            useCasesModule: UseCasesModule
    ): PresentationComponent
}