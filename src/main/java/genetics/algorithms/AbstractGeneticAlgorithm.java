package genetics.algorithms;

import genetics.algorithms.conditions.StoppingCondition;
import genetics.algorithms.util.AbstractGeneticAlgorithmSubject;
import genetics.algorithms.util.IntermediateResult;
import genetics.chromosomes.Chromosome;
import genetics.chromosomes.population.Population;
import genetics.exceptions.EmptyPopulationException;

import java.util.Objects;

public abstract class AbstractGeneticAlgorithm extends AbstractGeneticAlgorithmSubject implements GeneticAlgorithm {

    @Override
    public Population run(Population initial, StoppingCondition condition) {
        Objects.requireNonNull(initial);
        Objects.requireNonNull(condition);

        if (initial.size() == 0) throw new EmptyPopulationException();

        validate(initial);

        int iteration = 0;
        Population current = initial.copy();
        Chromosome fittest = current.getFittest();
        while (true) {
            IntermediateResult intermediateResult = new IntermediateResult(iteration, fittest, current);
            notifyObservers(intermediateResult);

            if (condition.isMet(intermediateResult)) break;

            current = next(current);

            Chromosome candidate = current.getFittest();
            if (candidate.compareTo(fittest) > 0) {
                fittest = candidate;
            }

            iteration++;
        }
        return current;
    }

    public abstract void validate(Population initial);

    public abstract Population next(Population current);
}
