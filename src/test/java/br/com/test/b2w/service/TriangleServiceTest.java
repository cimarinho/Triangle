package br.com.test.b2w.service;

import br.com.test.b2w.TestB2WApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TriangleServiceTest extends TestB2WApplicationTests {

    @Autowired
    TriangleService triangleService;

    @Test
    public void calculate_total(){
        long[][] triangleConfig = {{6},{3,5},{9,7,1},{4,6,8,4}};


        triangleConfig = new long[][]{{6}};
        assertEquals(6,triangleService.calculateTriangle(triangleConfig));

        triangleConfig = new long[][]{{6},{3,5}};
        assertEquals(11,triangleService.calculateTriangle(triangleConfig));

        triangleConfig = new long[][]{{6},{3,5},{9,7,1}};
        assertEquals(18,triangleService.calculateTriangle(triangleConfig));

        triangleConfig = new long[1][1];
        assertEquals(0,triangleService.calculateTriangle(triangleConfig));
    }
    @Test
    public void triangles(){
        long[][] triangleConfig = new long[1000][1000];
        int column = 1;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < column ; j++) {
                triangleConfig[i][j] = randomNumbers();
            }
            column++;
        }
        assertNotNull(triangleService.calculateTriangle(triangleConfig));
    }

    private long randomNumbers(){
        Random gerador = new Random();
        return gerador.nextLong();
    }

}
