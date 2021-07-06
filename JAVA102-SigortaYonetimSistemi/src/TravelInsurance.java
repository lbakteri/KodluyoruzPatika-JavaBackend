import java.util.*;

public class TravelInsurance extends Insurance {
    private int ticketPrice;
    private int insuranceMonth;

    public TravelInsurance(Account account) {
        super(account);
    }

    @Override
    public void getInputsFromUser() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the ticket price: ");
            this.ticketPrice = input.nextInt();
            input.nextLine();

            System.out.print("How many months do you want to have insurance?: ");
            this.insuranceMonth = input.nextInt();
            input.nextLine();
        }
        catch (Exception e) {
            System.out.println("Invalid Input");
        }
        calculate();
    }

    @Override
    void calculate() {
        // The insurance price was calculated as 15 percent of the ticket price and 7 percent more for each additional month.

        super.setInsuranceName("Travel Insurance");
        super.setStartAndExpiryDateByMonth(insuranceMonth);

        double insuranceFee = ticketPrice * 0.15 * (1 + (0.07 * insuranceMonth));

        if (super.getAccount() instanceof Enterprise) {
            insuranceFee *= 0.8;
        }
        System.out.println("Travel insurance fee: " + insuranceFee);
    }
}