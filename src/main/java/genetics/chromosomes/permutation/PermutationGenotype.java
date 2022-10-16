package genetics.chromosomes.permutation;

import genetics.chromosomes.RawGenotype;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PermutationGenotype extends RawGenotype<int[]> {

    public PermutationGenotype(int[] raw) {
        super(raw);
    }

    @Override
    public PermutationGenotype copy() {
        int[] rawCopy = new int[raw.length];
        System.arraycopy(raw, 0, rawCopy, 0, rawCopy.length);
        return new PermutationGenotype(rawCopy);
    }

    @Override
    public PermutationGenotype newInstance(int[] raw) {
        return new PermutationGenotype(raw);
    }

    @Override
    public String toString() {
        return Arrays.stream(raw).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(raw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermutationGenotype that = (PermutationGenotype) o;
        return Arrays.equals(raw, that.raw);
    }
}
