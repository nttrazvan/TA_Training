package tests;

import Pages.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.Helpers;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class calculateRectangle {

    private final int length = 2;

    private final int width = 3;

    Rectangle rectangle = new Rectangle(2,3);

    @BeforeEach
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before the test executes");
        Helpers.getPropValues();
    }

    @Test
    @Tag(value="testArea")
    public void successArea(){
        assertThat(rectangle.area()).isEqualTo(6);
    }

    //this test will fail
    @Test
    @Tag(value="testFailArea")
    public void failArea(){
        assertThat(rectangle.area()).isEqualTo(7);
    }

    @AfterEach
    public void afterMethod(){
        System.out.println("This is the method run after the test executes");
    }
}
