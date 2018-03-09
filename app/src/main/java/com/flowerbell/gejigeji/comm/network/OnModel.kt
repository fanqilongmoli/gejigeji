package com.flowerbell.gejigeji.comm.network

import com.flowerbell.gejigeji.comm.network.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by fanqilong on 2018/3/7.
 */
class OnModel {
    fun on():Observable<String>{
        return RetrofitManager.service.on().compose(SchedulerUtils.ioToMain())
    }
}