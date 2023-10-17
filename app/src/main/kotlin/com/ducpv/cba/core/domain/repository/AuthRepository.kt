package com.ducpv.cba.core.domain.repository

import com.ducpv.cba.core.data.network.NetworkDataSource
import javax.inject.Inject

interface AuthRepository {
    // TODO
}

class AuthRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : AuthRepository {
    // TODO
}
