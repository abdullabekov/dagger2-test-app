package com.techyourchance.dagger2course.common.di.service

import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {

}