package genetics.operators.crossover.floatinpoint;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.floatingpoint.FloatingPointChromosome;
import genetics.chromosomes.floatingpoint.FloatingPointGenotype;
import genetics.exceptions.InvalidChromosomeTypeException;
import genetics.operators.crossover.AbstractChromosomeCrossover;
import genetics.chromosomes.util.Pair;

import java.util.Optional;

abstract class AbstractFloatingPointCrossover extends AbstractChromosomeCrossover<FloatingPointGenotype, FloatingPointChromosome> {

    @Override
    protected Pair<FloatingPointChromosome, FloatingPointChromosome> typeCheck(Chromosome first, Chromosome second) {
        if (!(first instanceof FloatingPointChromosome firstParent))
            throw new InvalidChromosomeTypeException(FloatingPointChromosome.class, first.getClass());

        if (!(second instanceof FloatingPointChromosome secondParent))
            throw new InvalidChromosomeTypeException(FloatingPointChromosome.class, second.getClass());

        return new Pair<>(firstParent, secondParent);
    }

    @Override
    protected Pair<FloatingPointGenotype, Optional<FloatingPointGenotype>> mate(FloatingPointGenotype first, FloatingPointGenotype second) {
        Pair<double[], Optional<double[]>> rawPair = mateRaw(first.getRaw(), second.getRaw());

        double[] r1 = rawPair.first();
        Optional<double[]> optionalR2 = rawPair.second();

        return optionalR2.map(r2 -> new Pair<>(first.newInstance(r1), Optional.of(second.newInstance(r2))))
                .orElseGet(() -> new Pair<>(first.newInstance(r1), Optional.empty()));
    }

    protected abstract Pair<double[], Optional<double[]>> mateRaw(double[] first, double[] second);
}
