package genetics.operators.crossover;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.Children;
import genetics.operators.util.DesirabilityPair;
import genetics.operators.util.RouletteWheelContainer;

import java.util.List;

public class CompositeCrossoverOperator extends RouletteWheelContainer<CrossoverOperator> implements CrossoverOperator {

    public CompositeCrossoverOperator(List<DesirabilityPair<CrossoverOperator>> operatorDesirabilityPairs) {
        super(operatorDesirabilityPairs);
    }

    @Override
    public Children crossover(Chromosome first, Chromosome second) {
        return select().crossover(first, second);
    }
}
