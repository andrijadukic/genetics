package genetics.operators.crossover;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.Children;

@FunctionalInterface
public interface CrossoverOperator {

    Children crossover(Chromosome first, Chromosome second);
}
