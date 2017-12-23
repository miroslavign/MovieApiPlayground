/*
 * SchedulerProvider.java
 * Heyandroid
 *
 * Created by Miroslav Ignjatovic on 3/11/2017
 * Copyright (c) 2015 CommonSun All rights reserved.
 */

package rs.novotek.domain.util


import io.reactivex.Scheduler

interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler

    fun newThread(): Scheduler

    fun computationThread(): Scheduler

}
