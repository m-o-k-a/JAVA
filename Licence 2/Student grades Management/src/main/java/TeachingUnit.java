public class TeachingUnit {
    public TeachingUnitResult teachingUnitResult;
    public int credits;

    public TeachingUnit(TeachingUnitResult teachingUnitResult, int credits) {
        this.teachingUnitResult = teachingUnitResult;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return teachingUnitResult.toString() + " (" + credits + ")";
    }
}
