package com.android.mayojava.trivago.repository;

import com.android.mayojava.trivago.BuildConfig;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by mayowa.adegeye on 02/08/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public abstract class ApplicationTestCase {
}
