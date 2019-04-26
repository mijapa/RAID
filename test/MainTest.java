import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MainTest {

    @Test
    @Parameters({
            "0,0,0",
    })
    public void shouldCheckSomething(int input, int position, int expectedOutput) {
        //GIVEN
        Disc disc = new Disc();
        //WHEN
        disc.write(input, position);
        int readed = disc.read(position);
        //THEN
        assertThat(readed, equalTo(input));
    }
}