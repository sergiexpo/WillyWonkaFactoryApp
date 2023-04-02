package com.napptilus.willywonka.feature.detail.data

import com.napptilus.willywonka.core.result.MyResult
import com.napptilus.willywonka.feature.mock.mockWorkerResponse
import com.napptilus.willywonka.network.api.Api
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

private const val ID = 1

internal class DetailDataSourceImplTest() {
    @RelaxedMockK
    private lateinit var api: Api
    private lateinit var detailDataSourceImpl: DetailDataSourceImpl

    @Before
    fun init() {
        MockKAnnotations.init(this)
        detailDataSourceImpl = DetailDataSourceImpl(api)
    }

    @Test
    fun `invoking DetailDataSourceImp when API returns a valid response`() {

        val resultOK = mockWorkerResponse
        val expectedOKResult = MyResult.Ok(resultOK)

        return runBlocking {
            coEvery {
                api.getWorkerById(ID)
            } returns resultOK

            val result = detailDataSourceImpl.getWorkerById(ID)

            assert(expectedOKResult == result)
        }
    }
}