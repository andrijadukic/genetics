package genetics.operators.mutation;

import genetics.chromosomes.AbstractChromosome;
import genetics.chromosomes.Chromosome;
import genetics.chromosomes.Genotype;

public abstract class AbstractChromosomeMutation<G extends Genotype, C extends AbstractChromosome<G>> implements MutationOperator {

    @Override
    public final Chromosome mutate(Chromosome chromosome) {
        C original = typeCheck(chromosome);
        G originalGenotype = original.getGenotype();
        return original.newInstance(mutate(originalGenotype));
    }

    protected abstract C typeCheck(Chromosome chromosome);

    protected abstract G mutate(G genotype);
}
