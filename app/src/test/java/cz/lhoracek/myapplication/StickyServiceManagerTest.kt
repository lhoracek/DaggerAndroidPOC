package cz.lhoracek.myapplication

import android.app.Application
import android.content.Intent
import cz.lhoracek.myapplication.core.service.StickyService
import cz.lhoracek.myapplication.core.vm.service.StickyServiceViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class StickyServiceManagerTest {

    @Mock lateinit var app: Application
    @Mock lateinit var vm: StickyServiceViewModel
    @InjectMocks lateinit var stickyServiceManager: StickyService.StickyServiceManager

    @Before
    fun setup(){
        // any suite-wide logic
    }
    @Captor lateinit var intentCaptor: ArgumentCaptor<Intent>
    @Test
    fun startingService() {
        stickyServiceManager.start()
        verify(app).startService(any(Intent::class.java))
    }
}
