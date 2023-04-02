package com.napptilus.willywonka.feature.detail.domain

import com.napptilus.willywonka.core.result.GenericApiError
import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.mock.mockWorkerResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

private const val ID = 1

internal class GetWorkerByIdUseCaseImplTest() {
    @RelaxedMockK
    private lateinit var detailDataSource: DetailDataSource
    private lateinit var getWorkerByIdUseCaseImpl: GetWorkerByIdUseCaseImpl

    @Before
    fun init() {
        MockKAnnotations.init(this)
        getWorkerByIdUseCaseImpl = GetWorkerByIdUseCaseImpl(detailDataSource)
    }

    @Test
    fun `invoking GetWorkerByIdUseCaseImpl when result is a valid response`() {

        val resultOK = mockWorkerResponse
        val expectedOKResult = MyResult.Ok(resultOK)

        return runBlocking {
            coEvery {
                detailDataSource.getWorkerById(ID)
            } returns expectedOKResult

            val result = getWorkerByIdUseCaseImpl(ID)

            assert(expectedOKResult == result)
        }
    }

    @Test
    fun `invoking GetWorkerByIdUseCaseImpl when result is a failure response`() {

        val resultFailure = GenericApiError.Network
        val expectedFailureResult = MyResult.Err(resultFailure)

        return runBlocking {
            coEvery {
                detailDataSource.getWorkerById(ID)
            } returns expectedFailureResult

            val result = getWorkerByIdUseCaseImpl(ID)

            assert(expectedFailureResult == result)
        }
    }
}

