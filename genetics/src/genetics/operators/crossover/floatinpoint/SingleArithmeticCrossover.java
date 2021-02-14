package genetics.operators.crossover.floatinpoint;

import genetics.chromosomes.util.Pair;
import rand.SourceOfRandomness;

import java.util.Optional;

public class SingleArithmeticCrossover extends AbstractArithmeticCrossover {

    public SingleArithmeticCrossover() {
    }

    public SingleArithmeticCrossover(double alpha) {
        super(alpha);
    }

    @Override
    protected Pair<double[], Optional<double[]>> mateRaw(double[] first, double[] second) {
        int length = first.length;

        double[] child = new double[length];
        int rind = SourceOfRandomness.getSource().nextInt(length);
        child[rind] = alpha * (first[rind] + second[rind]);

        return new Pair<>(child, Optional.empty());
    }
}
