package test.com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by chris2 on 16-9-23.
 */
public class SampleTest {
    @Test
    public void shouldGetTrue() {
        assertThat(1, is(1));
    }

}
