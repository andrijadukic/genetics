package genetics.algorithms.util;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.population.Population;

public record IntermediateResult(int iteration, Chromosome fittest, Population current) {
}
