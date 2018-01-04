/*
 * SchedulerProvider.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/23/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.util

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler

    fun newThread(): Scheduler

    fun computationThread(): Scheduler

}
