package br.com.test.b2w.model;

import br.com.test.b2w.TestB2WApplicationTests;
import br.com.test.b2w.exception.UnprocessableEntityException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class TriangleValidatorTest extends TestB2WApplicationTests {

    @Autowired
    TriangleValidator routeValidator;

    @Test
    public void triangle_validate(){
        long[][] triangleConfig = {{6},{3,5},{9,7,1},{4,6,8,4}};
        routeValidator.validate(new Triangle() {{ setTriangle(triangleConfig); }});
    }

    @Test(expected= UnprocessableEntityException.class)
    public void triangle_invalidate(){
        long[][] triangleConfig = {{6},{3,5},{9,7,7,1},{4,6,8,4}};
        routeValidator.validate(new Triangle() {{ setTriangle(triangleConfig); }});
    }


    @Test(expected= UnprocessableEntityException.class)
    public void triangle_null(){
        routeValidator.validate(new Triangle() {{ setTriangle(null); }});
    }

}