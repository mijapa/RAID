import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FileDiskTest {

    @Test
    @Parameters({
            "10, 0, 0, 0",
            "10, 1, 1, 1",
            "10, 0, 9, 0",
    })
    public void shouldCheckWriteRead(int size, int input, int position, int expectedOutput) {
        //GIVEN
        Disk disk = new FileDisk(size);
        //WHEN
        disk.write(input, position);
        int readed = (Integer) disk.read(position);
        //THEN
        assertThat(readed, equalTo(expectedOutput));

    }

    @Test(expected = RuntimeException.class)
    @Parameters({
            "10, 0, -1",
    })
    public void shouldCheckWriteBounds(int size, int input, int position) {
        //GIVEN
        Disk disk = new FileDisk(size);
        //WHEN
        disk.write(input, position);
    }

    @Test(expected = RuntimeException.class)
    @Parameters({
            "10, -1",
    })
    public void shouldCheckReadBounds(int size, int position) {
        //GIVEN
        Disk disk = new FileDisk(size);
        //WHEN
        disk.read(position);
    }
}
