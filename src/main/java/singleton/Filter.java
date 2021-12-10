package singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {

        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        for (int integer : source) {
            if (integer > treshold){
                result.add(integer);
                logger.log(String.format("Элемент %d проходит", integer));
            }else{
                logger.log(String.format("Элемент %d не проходит", integer));
            }
        }

        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));

        return result;

    }
}
