package com.moblab.cnn_news.test

import android.content.Context
import com.moblab.cnn_news.testInjector
import com.moblab.cnn_news.ui.about.AboutPresenter
import com.moblab.cnn_news.ui.about.AboutScreen
import com.moblab.cnn_news.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class AboutTest {

    @InjectMocks
    lateinit var aboutPresenter : AboutPresenter

    @Mock
    private lateinit var aboutScreen: AboutScreen

    private lateinit var context: Context

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        MockitoAnnotations.initMocks(this)
        //aboutScreen = mock()
        context = RuntimeEnvironment.application.getApplicationContext()
        aboutPresenter.attachScreen(aboutScreen)
    }

    @Test
    fun showAboutDetailsTest(){
        aboutPresenter.getAboutDetails()
        verify(aboutScreen).showAboutDetails()
    }


    @After
    fun tearDown() {
        aboutPresenter.detachScreen()
    }

}