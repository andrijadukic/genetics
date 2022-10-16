package genetics.algorithms;

import genetics.algorithms.conditions.StoppingCondition;
import genetics.algorithms.util.GeneticAlgorithmSubject;
import genetics.chromosomes.population.Population;

public interface GeneticAlgorithm extends GeneticAlgorithmSubject {

    Population run(Population initial, StoppingCondition condition);
}
