package com.napptilus.willywonka.feature.home.data

import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.mock.mockAllWorkersResponse
import com.napptilus.willywonka.network.api.Api
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

private const val PAGE = 1

internal class HomeDataSourceImplTest() {
    @RelaxedMockK
    private lateinit var api: Api
    private lateinit var homeDataSourceImpl: HomeDataSourceImpl

    @Before
    fun init() {
        MockKAnnotations.init(this)
        homeDataSourceImpl = HomeDataSourceImpl(api)
    }

    @Test
    fun `invoking DetailDataSourceImp when API returns a valid response`() {

        val resultOK = mockAllWorkersResponse
        val expectedOKResult = MyResult.Ok(resultOK)

        return runBlocking {
            coEvery {
                api.getAllWorkers(PAGE)
            } returns resultOK

            val result = homeDataSourceImpl.getAllWorkers(PAGE)

            assert(expectedOKResult == result)
        }
    }
}