package genetics.operators.mutation.floatingpoint;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.floatingpoint.FloatingPointChromosome;
import genetics.chromosomes.floatingpoint.FloatingPointGenotype;
import genetics.exceptions.InvalidChromosomeTypeException;
import genetics.operators.mutation.AbstractChromosomeMutation;

abstract class AbstractFloatingPointMutation extends AbstractChromosomeMutation<FloatingPointGenotype, FloatingPointChromosome> {

    @Override
    protected final FloatingPointChromosome typeCheck(Chromosome chromosome) {
        if (!(chromosome instanceof FloatingPointChromosome floatingPointChromosome))
            throw new InvalidChromosomeTypeException(FloatingPointChromosome.class, chromosome.getClass());

        return floatingPointChromosome;
    }
}
