import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DiskTest {

    @Test
    @Parameters({
            "10, 0, 0, 0",
            "10, 1, 1, 1",
            "10, 0, 9, 0"
    })
    public void shouldCheckWriteRead(int size, int input, int position, int expectedOutput) {
        //GIVEN
        Disk disk = new Disk(size);
        //WHEN
        disk.diskWrite(input, position);
        int readed = disk.diskRead(position);
        //THEN
        assertThat(readed, equalTo(expectedOutput));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    @Parameters({
            "10, 1, 10,-1",
            "10, 0, -1, -1",
    })
    public void shouldCheckBounds(int size, int input, int position, int expectedOutput) {
        //GIVEN
        Disk disk = new Disk(size);
        //WHEN
        disk.diskWrite(input, position);
        int readed = disk.diskRead(position);
        //THEN

    }
}
