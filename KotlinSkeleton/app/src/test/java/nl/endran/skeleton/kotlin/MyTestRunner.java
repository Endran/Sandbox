package nl.endran.skeleton.kotlin;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;

import mockit.internal.startup.Startup;

public class MyTestRunner extends RobolectricGradleTestRunner {

    static { Startup.verifyInitialization(); }

    public MyTestRunner(final Class<?> klass) throws InitializationError {
        super(klass);
    }
}
