/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton.mvp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mockit.Expectations
import mockit.Mocked
import mockit.Verifications
import nl.endran.ui.UiApplication
import nl.endran.ui.injections.UiComponent
import nl.endran.ui.mvp.BaseFragment
import nl.endran.ui.mvp.BaseFragmentPresenter
import nl.endran.ui.mvp.BaseFragmentView
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

class BaseFragmentTest {

    @Mocked
    lateinit var layoutInflaterMock: LayoutInflater

    @Mocked
    lateinit var appMock: UiApplication

    @Mocked
    lateinit var uiComponentMock: UiComponent

    @Mocked
    lateinit var viewGroupMock: ViewGroup

    @Mocked
    lateinit var androidViewMock: View

    @Mocked
    lateinit var viewMock: BaseFragmentView<Any, BaseFragmentPresenter<Any>>

    @Mocked
    lateinit var presenterMock: BaseFragmentPresenter<Any>

    lateinit var baseFragment: TestBaseFragment

    @Before
    fun setUp() {
        prepareViewCreationExpectations()

        baseFragment = TestBaseFragment()
    }

    @Test
    fun shouldReturnAndroidViewCreatedByView_WhenOnCreateViewIsCalled() {
        object : Expectations() {
            init {
                viewMock.inflate(layoutInflaterMock, viewGroupMock, null)
                result = androidViewMock
            }
        }

        val androidView = baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)

        Assertions.assertThat(androidView).isSameAs(androidViewMock)
    }

    @Test
    fun shouldCallAndroidViewReadyOnView_whenOnViewCreatedIsCalled() {
        baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)

        baseFragment.onViewCreated(null, null)

        object : Verifications() {
            init {
                viewMock.androidViewReady()
            }
        }
    }

    @Test
    fun shouldCallDeflateOnView_whenOnViewIsDestroyed() {
        baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)

        baseFragment.onDestroyView()

        object : Verifications() {
            init {
                viewMock.deflate()
            }
        }
    }

    @Test
    fun shouldCreateAndSetPresenterOnViewViaStart_whenOnResumeIsCalled() {
        baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)

        preparePresenterCreationExpectations()
        baseFragment.onResume()

        object : Verifications() {
            init {
                viewMock.start(presenterMock)
            }
        }
    }

    @Test
    fun shouldStopView_whenOnPauseIsCalled() {
        baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)

        baseFragment.onPause()

        object : Verifications() {
            init {
                viewMock.stop()
            }
        }
    }

    @Test
    fun shouldBeNullSafe_whenLifecycleCallbacksAreCalledAfterOnDestroy() {
        baseFragment.onCreateView(layoutInflaterMock, viewGroupMock, null)
        baseFragment.onDestroyView()

        baseFragment.onViewCreated(null, null)
        baseFragment.onPause()
        baseFragment.onResume()
        baseFragment.onDestroyView()
    }

    // ---------------

    public inner class TestBaseFragment : BaseFragment<Any, BaseFragmentPresenter<Any>, BaseFragmentView<Any, BaseFragmentPresenter<Any>>>() {
        override fun createView(uiComponent: UiComponent): BaseFragmentView<Any, BaseFragmentPresenter<Any>> {
            Assertions.assertThat(uiComponent).isSameAs(uiComponentMock)
            return viewMock
        }

        override fun createPresenter(uiComponent: UiComponent): BaseFragmentPresenter<Any> {
            Assertions.assertThat(uiComponent).isSameAs(uiComponentMock)
            return presenterMock
        }

        override fun getContext(): Context? {
            return appMock.applicationContext
        }
    }

    private fun prepareViewCreationExpectations() {
        object : Expectations() {
            init {
                layoutInflaterMock.context
                result = appMock
            }

            init {
                appMock.applicationContext
                result = appMock
            }

            init {
                appMock.uiComponent
                result = uiComponentMock
            }
        }
    }

    private fun preparePresenterCreationExpectations() {
        object : Expectations() {

            init {
                appMock.applicationContext
                result = appMock
            }

            init {
                appMock.uiComponent
                result = uiComponentMock
            }
        }
    }
}
