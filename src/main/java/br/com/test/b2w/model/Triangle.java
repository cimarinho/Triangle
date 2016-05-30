package br.com.test.b2w.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Triangle implements Serializable{

    private static final long serialVersionUID = -1755320868988193315L;

    private long [][] triangle;
}
