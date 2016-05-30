package br.com.test.b2w.model;

import br.com.test.b2w.exception.UnprocessableEntityException;
import org.springframework.stereotype.Component;

@Component
public class TriangleValidator {

    public void validate(Triangle triangle) {
        if (triangle == null || triangle.getTriangle() == null) {
            error();
        }
        int row = 1;
        long[][] value = triangle.getTriangle();
        for (long[] rowData : triangle.getTriangle()) {
            if (rowData.length != row){
                error();
            }
            row++;
        }
    }

    void error() {
        throw new UnprocessableEntityException("Invalid Triangle.");
    }
}
