package com.ducpv.cba.core.data.network

import com.ducpv.cba.core.data.network.retrofit.NetworkApi
import javax.inject.Inject
import javax.inject.Singleton

interface NetworkDataSource {
    // TODO
}


@Singleton
class NetworkDataSourceImpl @Inject constructor(
    private val api: NetworkApi,
) : NetworkDataSource {
    // TODO
}