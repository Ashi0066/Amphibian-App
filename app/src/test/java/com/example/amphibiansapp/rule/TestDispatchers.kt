package com.example.amphibiansapp.rule

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.Dispatcher
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class TestDispatchersRule
    (val testDispatchers: TestDispatcher = UnconfinedTestDispatcher()) : TestWatcher() {


    override fun starting(description: Description?) {
        Dispatchers.setMain(testDispatchers)
    }

    override fun finished(description: Description?) {
        Dispatchers.resetMain()
    }


}