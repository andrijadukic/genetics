package genetics.operators.selection;

import genetics.chromosomes.Chromosome;
import genetics.chromosomes.population.Population;
import genetics.exceptions.InsufficientPopulationSIze;
import rand.SourceOfRandomness;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.stream.Stream;

public class TournamentSelection implements SelectionOperator {

    private final int tournamentSize;

    public TournamentSelection(int tournamentSize) {
        if (tournamentSize <= 0) throw new InvalidParameterException("Tournament size must be greater than zero");
        this.tournamentSize = tournamentSize;
    }

    @Override
    public Chromosome select(Population population) {
        int size = population.size();

        if (size < tournamentSize) throw new InsufficientPopulationSIze(size, tournamentSize);

        if (size == tournamentSize) return population.getFittest();

        Random random = SourceOfRandomness.getSource();
        return Stream.generate(() -> population.getChromosome(random.nextInt(size)))
                .limit(tournamentSize)
                .max(Chromosome::compareTo)
                .orElseThrow(IllegalStateException::new);
    }
}
