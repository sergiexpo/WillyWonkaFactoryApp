package com.napptilus.willywonka.feature.home.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.mock.mockAllWorkersResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

private const val PAGE = 1

class GetAllWorkersUseCaseImplTest() {
    @RelaxedMockK
    private lateinit var homeDataSource: HomeDataSource
    private lateinit var getAllWorkersUseCaseImpl: GetAllWorkersUseCaseImpl

    @Before
    fun init() {
        MockKAnnotations.init(this)
        getAllWorkersUseCaseImpl = GetAllWorkersUseCaseImpl(homeDataSource)
    }

    @Test
    fun `invoking GetAllWorkersUseCaseImpl when result is a valid response`() {

        val resultOK = mockAllWorkersResponse
        val expectedOKResult = MyResult.Ok(resultOK)

        return runBlocking {
            coEvery {
                homeDataSource.getAllWorkers(PAGE)
            } returns expectedOKResult

            val result = getAllWorkersUseCaseImpl(PAGE)

            assert(expectedOKResult == result)

        }
    }

    @Test
    fun `invoking GetAllWorkersUseCaseImpl when result is a failure response`() {

        val resultFailure = GenericApiError.Network
        val expectedFailureResult = MyResult.Err(resultFailure)

        return runBlocking {
            coEvery {
                homeDataSource.getAllWorkers(PAGE)
            } returns expectedFailureResult

            val result = getAllWorkersUseCaseImpl(PAGE)

            assert(expectedFailureResult == result)

        }
    }
}