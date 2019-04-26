import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MatrixTest {
    @Test
    @Parameters({
            "0, 0, 0",
            "0, 1, 0",
            "0, 2, 0",
            "0, 3, 0",
            "0, 4, 0"
    })
    public void shouldCheckWriteRead(int input, int position, int expectedOutput) {
        //GIVEN
        Matrix matrix = new Matrix(3, 10);
        //WHEN
        matrix.matrixWrite(position, input);
        int readed = matrix.matrixRead(position);
        //THEN
        assertThat(readed, equalTo(expectedOutput));
    }
}
