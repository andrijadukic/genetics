package genetics.operators.util;

import rand.SourceOfRandomness;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Random;

public class RouletteWheelContainer<E> extends ProbabilitySelector {

    private final List<E> elements;
    private final double[] rouletteWheel;

    public RouletteWheelContainer(List<DesirabilityPair<E>> operatorDesirabilityPairs) {
        var sortedPairs = operatorDesirabilityPairs.stream().sorted().toList();
        elements = sortedPairs.stream().map(DesirabilityPair::element).toList();
        double[] desirability = sortedPairs.stream().mapToDouble(DesirabilityPair::desirability).toArray();

        if (!isValid(desirability)) throw new InvalidParameterException();

        rouletteWheel = generateRouletteWheel(desirability);
    }

    protected E select() {
        return select(SourceOfRandomness.getSource());
    }

    protected E select(Random random) {
        return elements.get(find(rouletteWheel, random.nextDouble()));
    }
}
