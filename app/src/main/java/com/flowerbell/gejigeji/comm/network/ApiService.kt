package com.flowerbell.gejigeji.comm.network

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by fanqilong on 2018/3/7.
 */
interface ApiService {
    /**
    * 首页精选
    */
    @GET("/on")
    fun on(): Observable<String>
}