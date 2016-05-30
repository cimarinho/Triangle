package br.com.test.b2w.service;

import br.com.test.b2w.model.Triangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import static br.com.test.b2w.config.CacheConfig.CACHE_TRIANGLE;

@Service
@Slf4j
public class TriangleService implements Serializable {

    private static final long serialVersionUID = 8670630161959587107L;

    @Cacheable(value = CACHE_TRIANGLE)
    public long total(Triangle triangle){
        log.info("Triangle {} calcule total",triangle);
        return calculateTriangle(triangle.getTriangle());
    }

    long calculateTriangle(long [][] value){
        int position = 0;
        long sum = value[0][position];
        for(int ite = 1 ; ite < value.length ; ite++){
            position = getPosition(value[ite],position);
            sum += value[ite][position];
        }
        return sum;
    }

    int getPosition(long [] value, int position){
        if(value[position] > value[position+1]){
            return position;
        }
        return position +1;
    }
}
