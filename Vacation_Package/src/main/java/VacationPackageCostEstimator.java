import java.util.Scanner;


public class VacationPackageCostEstimator{
    private static final int BASE_COST = 1000;
    private static final int TARIFA_PARIS = 500;
    private static final int TARIFA_NY = 600;
    private static final int LIMITE_PASAJEROS = 80;
    private static final int L2_PAS = 4;
    private static final int L3_PAS = 10;
    private static final double DESC_DIEZ = 0.10;
    private static final double DESC_VEINTE = 0.20;
    private static final int LIMITE_DIAS = 200;
    private static final int LIMITE_DIAS2 = 7;
    private static final int LIMITE_DURACION = 30;
    @SuppressWarnings("unused")
private void main(final String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al estimador de tu paquete vacacional");
        System.out.println("Por favor, ingrese los siguientes datos.");
        System.out.print("Destino (Paris, New York City, o Otro): ");
        String destination = scanner.nextLine();
        System.out.print("Número de viajeros: ");
        int numberOfTravelers = scanner.nextInt();
        System.out.print("Duración de las vacaciones (días): ");
        int duration = scanner.nextInt();


        int additionalCost = 0;
        if (destination.equalsIgnoreCase("Paris")) {
            additionalCost = TARIFA_PARIS;
        } else if (destination.equalsIgnoreCase("New York City")) {
            additionalCost = TARIFA_NY;
        } else if (!destination.equalsIgnoreCase("Otro")) {
            System.out.println("Destino inválido.");
            System.out.println("Costo Total: -1");
            return;
        }

        if (numberOfTravelers <= 0 || numberOfTravelers > LIMITE_PASAJEROS) {
            System.out.println("Número de viajeros inválido.");
            System.out.println("Costo Total: -1");
            return;
        }
        double groupDiscount = 0;
        if (numberOfTravelers > L2_PAS && numberOfTravelers <= L3_PAS) {
            groupDiscount = DESC_DIEZ;
        } else if (numberOfTravelers > L3_PAS) {
            groupDiscount = DESC_VEINTE;
        }

        int penaltyFee = (duration < LIMITE_DIAS2) ? LIMITE_DIAS : 0;

        int promotionDiscount = (duration > LIMITE_DURACION || numberOfTravelers == 2) ? 200 : 0;

        int totalCost = BASE_COST + additionalCost - (int)(BASE_COST * groupDiscount) + penaltyFee - promotionDiscount;

        if (totalCost < 0) {
            System.out.println("Información ingresada inválida.");
            System.out.println("Costo Total: -1");
        } else {
            System.out.println("Costo Total: " + totalCost);
        }

        scanner.close();
    }

}
