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
            "0, 4, 0",
            "1, 1, 1",
            "1, 2, 1",
            "1, 3, 1",
            "1, 4, 1",
            "0, 10, 0",
            "1, 10, 1",
    })
    public void shouldCheckSingleBitWriteRead(int input, int position, int expectedOutput) {
        //GIVEN
        Matrix matrix = new Matrix(3, 10);
        //WHEN
        matrix.write(position, input);
        int readed = matrix.read(position);
        //THEN
        assertThat(readed, equalTo(expectedOutput));
    }

    @Test
    public void shouldCheckMultipleBitWriteRead() {
        //GIVEN
        Matrix matrix = new Matrix(3, 5);

        //WHEN
        matrix.write(0, 1);
        matrix.write(1, 1);
        matrix.write(2, 1);
        matrix.write(3, 1);
        matrix.write(4, 1);
        matrix.write(5, 1);
        matrix.write(6, 1);
        matrix.write(7, 1);
        matrix.write(8, 1);
        matrix.write(9, 1);
        int[][] readed = matrix.toArray();
        int[][] expectedOutput = new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1},
                {1, 0, 1},
        };
        //THEN
        assertThat(readed, equalTo(expectedOutput));
    }
}
