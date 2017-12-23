package rs.novotek.movieapiplayground.util

import io.reactivex.schedulers.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import rs.novotek.domain.util.SchedulerProvider


/**
 * Created by BX on 12/6/2017.
 */
class SchedulerProviderImpl : SchedulerProvider {
    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun backgroundThread(): Scheduler {
        return Schedulers.io()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun computationThread(): Scheduler {
        return Schedulers.computation()
    }
}