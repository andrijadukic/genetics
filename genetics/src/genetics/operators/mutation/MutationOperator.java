package genetics.operators.mutation;

import genetics.chromosomes.Chromosome;

@FunctionalInterface
public interface MutationOperator {

    Chromosome mutate(Chromosome chromosome);

    default MutationOperator then(MutationOperator next) {
        return chromosome -> next.mutate(mutate(chromosome));
    }
}
