import projectAspects.purchaseDistribution.PDMain;
import projectAspects.purchaseDistribution.PDMainInterface;

public class MainApplication {
    public static void main(String[] args) {
        PDMainInterface trialPD = new PDMain();
        trialPD.launchPDUserInterface();
    }
}
