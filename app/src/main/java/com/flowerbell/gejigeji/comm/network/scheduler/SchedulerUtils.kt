package com.flowerbell.gejigeji.comm.network.scheduler

/**
 * Created by fanqilong on 2018/3/7.
 */
object SchedulerUtils {
    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}